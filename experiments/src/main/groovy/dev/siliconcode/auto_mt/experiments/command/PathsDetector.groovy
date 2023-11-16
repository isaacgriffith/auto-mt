package dev.siliconcode.auto_mt.experiments.command

import com.google.common.collect.Sets
import dev.siliconcode.auto_mt.experiments.ExperimentContext
import dev.siliconcode.auto_mt.lib.code.FileType
import dev.siliconcode.auto_mt.lib.code.Project
import dev.siliconcode.auto_mt.lib.code.ProjectFile
import groovy.util.logging.Slf4j
import org.apache.commons.lang3.tuple.Pair

import java.nio.file.Paths

/**
 * C Paths Detector
 *
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
@Slf4j
class PathsDetector {

    ExperimentContext context

    PathsDetector(ExperimentContext context) {
        this.context = context
    }

    void detect() {
        log.info "Detecting Project Paths..."

        Pair<List<String>, List<String>> pairs = buildGraph(FileType.SOURCE)
        String[] src = pairs.getLeft()
        String[] test = pairs.getRight()

        context.getProject().setSrcPath(src)
        context.getProject().setTestPath(test)

        pairs = buildGraph(FileType.BINARY)
        String[] bin = pairs.getLeft()

        context.getProject().setBinPath(bin)

        log.info "Finished Detecting Project Paths"
    }

    Pair<List<String>, List<String>> buildGraph(FileType type) {
        log.info "Building Graph"

        Project proj = context.getProject()
        String dir = Paths.get(context.getProjectDirectory()).toAbsolutePath().toString()

        List<ProjectFile> files = proj.getFilesByType(type)
        List<String> names = []
        files.each { file -> names << file.getName().replace(dir, "").substring(1) }

        Set<String> paths = Sets.newHashSet(names)
        Set<String> testPaths = Sets.newHashSet()
        paths.each {
            if (it.contains("test"))
                testPaths << it
        }
        paths.removeAll(testPaths)

        testPaths.each { path ->
            files.each { file ->
                if (file.getName().contains(path))
                    file.setType(FileType.TEST)
            }
        }

        log.info "Finished Building Graph"
        Pair.of(paths.asList(), testPaths.asList())
    }
}
