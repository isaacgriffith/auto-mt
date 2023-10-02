package dev.siliconcode.auto_mt.app.testreq.isp.clustering

import spock.lang.Specification
import tech.tablesaw.api.BooleanColumn
import tech.tablesaw.api.DoubleColumn
import tech.tablesaw.api.StringColumn
import tech.tablesaw.columns.AbstractColumn

class ClusteringStrategySelectorSpec extends Specification {
    void setup() {
    }

    void cleanup() {
    }

    def "SelectClusterMethod"(AbstractColumn column, Class expectedType) {
        given:
        def selector = ClusteringStrategySelector.getInstance()

        when:
        def strategy = selector.selectClusterMethod(column)

        then:
        expectedType.isInstance(strategy)

        where:
        column                      | expectedType
        DoubleColumn.create("test") | NumericalClustering.class
        StringColumn.create("test") | CategoricalClustering.class
    }

    def "SelectClusterMethod Throws Exception"() {
        given:
        def selector = ClusteringStrategySelector.getInstance()

        when:
        def strategy = selector.selectClusterMethod(BooleanColumn.create("test"))

        then:
        thrown(RuntimeException)
    }

    def "SelectClusterMethod Null Feature Vector"() {
        given:
        def selector = ClusteringStrategySelector.getInstance()

        when:
        def strategy = selector.selectClusterMethod(null)

        then:
        thrown(RuntimeException)
    }
}
