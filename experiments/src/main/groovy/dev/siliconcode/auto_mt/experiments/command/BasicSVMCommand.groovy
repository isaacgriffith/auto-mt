package dev.siliconcode.auto_mt.experiments.command

import dev.siliconcode.auto_mt.experiments.ExperimentContext
import org.apache.spark.ml.classification.LinearSVC
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator

class BasicSVMCommand extends AbstractCommand {

    BasicSVMCommand() {
        super("Basic Support Vector Machine Classification")
    }

    @Override
    void execute(ExperimentContext context) {
        var test,train,validate = split_data(context)
        var model = train_model(train)
        var accuracy = test_model(model, test)
        var predictions = predict(model, validate)
        var results = evaluate(predictions, validate)
        save_results(results)
        save_model(model)
    }

    private def split_data(context) {
        var data = context.data
        var splits = data.randomSplit([0.6, 0.2, 0.2])
        var train = splits[0]
        var test = splits[1]
        var validate = splits[2]
        return [test,train,validate]
    }

    private def train_model(train) {
        LinearSVC lsvc = new LinearSVC()
            .setMaxIter(10)
            .setRegParam(0.1)
        return lsvc.fit(train)
    }

    private def test_model(model, test) {
        var result = model.transform(test)
        var predictionAndLabels = result.select("prediction", "label")
        var evaluator = new MulticlassClassificationEvaluator()
            .setMetricName("accuracy")
        return evaluator.evaluate(predictionAndLabels)
    }

    private def predict(model, validate) {
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
