package dev.siliconcode.auto_mt.experiments.command

import com.google.common.collect.HashBasedTable
import com.google.common.collect.Table
import dev.siliconcode.auto_mt.experiments.ExperimentContext
import dev.siliconcode.auto_mt.lib.cfg.ControlFlowNode
import dev.siliconcode.auto_mt.lib.cfg.StatementType
import dev.siliconcode.auto_mt.lib.code.Method
import org.jgrapht.Graph
import org.jgrapht.graph.DefaultEdge

class NodeFeatureExtractor extends AbstractCommand implements FeatureExtractor {

    NodeFeatureExtractor() {
        super("Node Feature Extractor - Extracts features from the CFG nodes")
    }

    @Override
    void execute(ExperimentContext context) {
        Table<Method, String, Integer> features = HashBasedTable.create()
        context.system.projects.each { proj ->
            proj.getAllMethods().each { method ->
                Graph<ControlFlowNode, DefaultEdge> graph = method.cfg.getGraph()
                Map<String, Integer> mFeatures = [:]
                graph.vertexSet().each { node ->
                    if (node.getType() != StatementType.METHSTRT || node.getType() != StatementType.METHEND) {
                        String op = node.getLabel()
                        int din = graph.incomingEdgesOf(node).size()
                        int dout = graph.outgoingEdgesOf(node).size()
                        String feature = "${op}-${din}-${dout}"
                        if (feature in mFeatures.keySet()) {
                            mFeatures[feature] += 1
                        } else {
                            mFeatures[feature] = 1
                        }
                    }
                }
                for (String feature : mFeatures.keySet()) {
                    features.put(method, feature, (Integer) features[feature])
                }
            }
        }
    }

    @Override
    String getName() {
        return this.name
    }
}
