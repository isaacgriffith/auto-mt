package dev.siliconcode.auto_mt.app.testreq.isp.clustering

import spock.lang.Specification
import tech.tablesaw.api.StringColumn

class CategoricalClusteringSpec extends Specification {

    def "Cluster"() {
        given:
        def clustering = new CategoricalClustering()
        def name = "test"
        def feature = StringColumn.create("test", ["Very Small", "Small", "Medium", "Large", "Very Large"])

        when:
        def blocks = clustering.cluster(name, feature)

        then:
        blocks.size() == 5
        blocks[0].getName() == name
        blocks[0].getValue() == "Small"
        blocks[1].getName() == name
        blocks[1].getValue() == "Medium"
        blocks[2].getName() == name
        blocks[2].getValue() == "Large"
        blocks[3].getName() == name
        blocks[3].getValue() == "Very Large"
        blocks[4].getName() == name
        blocks[4].getValue() == "Very Small"
    }
}
