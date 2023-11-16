/*
 * MIT License
 *
 * SiliconCode AutoMT - Library
 * Copyright (c) 2023 SiliconCode, LLC and Isaac Griffith, PhD
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package dev.siliconcode.auto_mt.lib.parserop

import groovy.util.logging.Slf4j
import org.yaml.snakeyaml.Yaml

@Singleton
@Slf4j
class ArtifactIdentifierRegistrar {

    Map<String, ArtifactIdentifier> artifactIdentifierMap = [:]

    void registerIdentifiers() {
        if (artifactIdentifierMap.size() > 0) {
            return
        }

        Yaml yaml = new Yaml()
        InputStream input = ArtifactIdentifierRegistrar.class.getResourceAsStream("artifact_identifiers.yaml");
        List<ArtifactIdentifier> identifiers = yaml.loadAll(input) as List<ArtifactIdentifier>
        identifiers.each { artifactIdentifier ->
            artifactIdentifierMap[artifactIdentifier.language] = artifactIdentifier
        }
        log.info "Registered ${artifactIdentifierMap.size()} artifact identifiers"
    }

    ArtifactIdentifier getArtifactIdentifier(String language) {
        if (artifactIdentifierMap.size() == 0) {
            registerIdentifiers()
        }
        return artifactIdentifierMap[language]
    }

    static void main(String[] args) {
        ArtifactIdentifierRegistrar registrar = getInstance()
        println(registrar.getArtifactIdentifier("c"))
    }
}
