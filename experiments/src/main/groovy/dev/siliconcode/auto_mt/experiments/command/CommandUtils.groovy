package dev.siliconcode.auto_mt.experiments.command

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

/**
 * @author Isaac D. Griffith, Ph.D.
 * @version 1.0.0
 */
class CommandUtils {

    static String normalizePathString(String path) {
        String sep = File.separator
        if (!path.endsWith(sep)) {
            path += sep;
        }
        path
    }
    
    static String absolutePathString(String path) {
        Path p = Paths.get(path)
        p.toAbsolutePath().toString()
    }
    
    static boolean verifyFileExists(String path, String file) {
        Path p = Paths.get(path, file)
        Files.exists(p)
    }
}
