package dev.siliconcode.auto_mt.app.testreq.isp.clustering

import spock.lang.Specification
import tech.tablesaw.api.DoubleColumn

class NumericalClusteringSpec extends Specification {

    def "Cluster"() {
        given:
        def clustering = new NumericalClustering()
        def name = "test"
        def feature = DoubleColumn.create("test", [1.0, 2.0, 3.0, 4.0, 5.0, 6.0])

        when:
        def blocks = clustering.cluster(name, feature)

        then:
        blocks.size() == 2
        blocks[0].getName() == name
        blocks[0].getMin() == 1.0
        blocks[0].getMax() == 3.0
        blocks[1].getName() == name
        blocks[1].getMin() == 4.0
        blocks[1].getMax() == 6.0
    }
}
