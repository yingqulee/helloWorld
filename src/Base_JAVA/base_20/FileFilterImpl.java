package Base_JAVA.base_20;

import java.io.File;
import java.io.FileFilter;

public class FileFilterImpl implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        return pathname.isDirectory() || pathname.getPath().toLowerCase().endsWith(".java");
    }
}
