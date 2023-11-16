/*
 * MIT License
 *
 * SiliconCode AutoMT - Experiments
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
package dev.siliconcode.auto_mt.experiments.runner.detectmrs

import dev.siliconcode.auto_mt.experiments.command.ArtifactIdentifierCommand
import dev.siliconcode.auto_mt.experiments.command.LanguageLoader
import dev.siliconcode.auto_mt.experiments.command.ProjectGenerator
import dev.siliconcode.auto_mt.experiments.runner.StudyPhase

/**
 * Detecting MRs Phase 2
 *
 * Goal: Detect each function for each language
 *
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
class DetectingMRsPhaseTwo extends StudyPhase {

    LanguageLoader loader
    ProjectGenerator projGen
    ArtifactIdentifierCommand artifactIdentifier

    DetectingMRsPhaseTwo() {
        super("Phase Two", "Using ML Techniques to Detect MRs for Programs without Test Oracles")
    }

    @Override
    void initWorkflow(ConfigObject runnerConfig, int num) {
        loader = new LanguageLoader()
        projGen = new ProjectGenerator()
        artifactIdentifier = new ArtifactIdentifierCommand()
    }

    @Override
    void executeStudy() {
        loader.execute(context)
        context.languages.each { lang ->
            projGen.execute(context, lang)
            artifactIdentifier.execute(context, lang)
        }
    }
}
