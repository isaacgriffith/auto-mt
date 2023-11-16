package dev.siliconcode.auto_mt.experiments.command

import dev.siliconcode.auto_mt.experiments.ExperimentContext
import org.apache.spark.ml.Pipeline
import org.apache.spark.ml.PipelineModel
import org.apache.spark.ml.PipelineStage
import org.apache.spark.ml.classification.DecisionTreeClassifier
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator
import org.apache.spark.ml.feature.IndexToString
import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.ml.feature.StringIndexerModel
import org.apache.spark.ml.feature.VectorIndexer
import org.apache.spark.ml.feature.VectorIndexerModel
import org.apache.spark.sql.Dataset
import org.apache.spark.sql.Row

class BasicTreeClassifyCommand extends AbstractCommand {

    BasicTreeClassifyCommand() {
        super("Basic Decision Tree Classification")
    }

    @Override
    void execute(ExperimentContext context) {
        var test,train,validate = split_data(context)
        var model = train_model(train)
        var accuracy = test_model(model, test)
        var predictions = predict(model, validate)
        var results = evaluate(predictions, validate)
        save_results(results)
        save_model(model.stages()[2])
    }

    private def split_data(context) {
        var data = context.data
        var splits = data.randomSplit((double[]) [0.6, 0.2, 0.2])
        var train = splits[0]
        var test = splits[1]
        var validate = splits[2]
        return [test,train,validate]
    }

    private def train_model(Dataset<Row> trainingData) {
        StringIndexerModel labelIndexer = new StringIndexer()
                .setInputCol("label")
                .setOutputCol("indexedLabel")
                .fit(trainingData);

        VectorIndexerModel featureIndexer = new VectorIndexer()
                .setInputCol("features")
                .setOutputCol("indexedFeatures")
                .setMaxCategories(4) // features with > 4 distinct values are treated as continuous.
                .fit(trainingData);

        DecisionTreeClassifier dt = new DecisionTreeClassifier()
                .setLabelCol("indexedLabel")
                .setFeaturesCol("indexedFeatures");

        IndexToString labelConverter = new IndexToString()
                .setInputCol("prediction")
                .setOutputCol("predictedLabel")
                .setLabels(labelIndexer.labelsArray()[0]);

        Pipeline pipeline = new Pipeline()
                .setStages(new PipelineStage[]{labelIndexer, featureIndexer, dt, labelConverter});
        PipelineModel model = pipeline.fit(trainingData);
        return model
    }

    private def test_model(PipelineModel model, Dataset<Row> test) {
        var result = model.transform(test)
        var predictionAndLabels = result.select("prediction", "label")
        var evaluator = new MulticlassClassificationEvaluator()
                .setMetricName("accuracy")
        return evaluator.evaluate(predictionAndLabels)
    }

    private def predict(PipelineModel model, Dataset<Row>validate) {
        return model.transform(validate)
    }

    private def evaluate(predictions, validate) {
        var predictionAndLabels = result.select("prediction", "label")
        var evaluator = new MulticlassClassificationEvaluator()
                .setMetricName("accuracy")
        var accuracy = evaluator.evaluate(predictionAndLabels)
    }

    private def save_results(results) {
        // TODO
    }

    private def save_model(model) {
        // TODO
    }

    @Override
    String getName() {
        return null
    }
}
