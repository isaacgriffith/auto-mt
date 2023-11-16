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
package dev.siliconcode.auto_mt.experiments.runner.predmrskernel

import dev.siliconcode.auto_mt.experiments.EmpiricalStudy
import dev.siliconcode.auto_mt.experiments.runner.StudyConfigReader

class PredictingMRsWithGraphKernelsExperiment  extends EmpiricalStudy {
    private static final String STUDY_NAME = "Predicting MRs with Graph Kernels Experiment"
    private static final String STUDY_DESC = ""

    PredictingMRsWithGraphKernelsExperiment() {
        super(STUDY_NAME, STUDY_DESC, new StudyConfigReader(getConfigFileName(), getConfigHeaders()))

        this.phases = [
                new PredictMRsPhaseOne(),
                new PredictMRsPhaseTwo(),
                new PredictMRsPhaseThree(),
                new PredictMRsPhaseFour(),
                new PredictMRsPhaseFive(),
                new PredictMRsPhaseSix(),
                new PredictMRsPhaseSeven(),
                new PredictMRsPhaseEight(),
        ]
        this.headers = PredictingMRsWithGraphKernelsConstants.HEADERS
        this.keyHeaders = []
        this.identifier = PredictingMRsWithGraphKernelsConstants.ID
    }

    def static getConfigHeaders() {
        return []
    }

    def static getConfigFileName() {
        "experiment.conf"
    }
}
