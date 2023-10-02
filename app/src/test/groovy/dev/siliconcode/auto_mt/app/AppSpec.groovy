package dev.siliconcode.auto_mt.app

import spock.lang.Specification

/**
 * Unit test for simple App.
 */
class AppSpec extends Specification {
    void setup() {
    }

    void cleanup() {
    }

    def "Main"() {
        given:
        def app = new App()

        when:
        app.main([])

        then:
        true
    }
}
