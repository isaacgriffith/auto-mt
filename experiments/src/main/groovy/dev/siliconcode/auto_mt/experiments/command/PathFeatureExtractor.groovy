package dev.siliconcode.auto_mt.experiments.command

import com.google.common.collect.HashBasedTable
import com.google.common.collect.Table
import dev.siliconcode.auto_mt.experiments.ExperimentContext
import dev.siliconcode.auto_mt.lib.cfg.ControlFlowNode
import dev.siliconcode.auto_mt.lib.cfg.StatementType
import dev.siliconcode.auto_mt.lib.code.Method
import org.jgrapht.Graph
import org.jgrapht.GraphPath
import org.jgrapht.alg.shortestpath.DijkstraShortestPath
import org.jgrapht.graph.DefaultEdge

class PathFeatureExtractor extends AbstractCommand implements FeatureExtractor {

    PathFeatureExtractor() {
        super("Path Feature Extractor - Extracts features from the CFG paths")
    }

    @Override
    void execute(ExperimentContext context) {
        Table<Method, String, Integer> features = HashBasedTable.create()
        context.system.projects.each { proj ->
            proj.getAllMethods().each { method ->
                Graph<ControlFlowNode, DefaultEdge> graph = method.cfg.getGraph()
                Map<String, Integer> mFeatures = [:]
                ControlFlowNode start = graph.vertexSet().find { node -> node.getType() == StatementType.METHSTRT }
                DijkstraShortestPath dijkstra = new DijkstraShortestPath(graph)
                graph.vertexSet().each { node ->
                    if (node.getType() != StatementType.METHSTRT || node.getType() != StatementType.METHEND) {
                        GraphPath<ControlFlowNode, DefaultEdge> path = dijkstra.getPath(start, node)
                        List<String> labels = []
                        path.getVertexList().each { n ->
                            labels << n.getLabel()
                        }
                        String feature = labels.join("-")
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
