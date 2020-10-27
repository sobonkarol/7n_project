package utils;

public class Directory {
    public static final String HOME_DIR = System.getProperty("user.home");
    public static final String PROJECT_DIR = System.getProperty("user.dir");
    public static final String DRIVER_DIR;

    public Directory() {
    }

    static {
        DRIVER_DIR = PROJECT_DIR + "/driver";
    }
}
