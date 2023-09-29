package utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class AppUtils {
    public static List<String> repoList() throws IOException {
        return FileUtils.readLines(new File("repoList.txt"), "utf-8");
    }
}
