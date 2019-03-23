package pri.zxx.learndemo.threademo.javabase.classload.classloader;

/**
 * @author: 一杯咖啡
 * @desc:
 * @createTime: 2018-11-16-0:40
 */
public class BootstrapClassLoader {

    public static void main(String[] args) {
        System.out.println("Bootstrap:" + String.class.getClassLoader());
        System.out.println("rootClassLoader: " + System.getProperty("sun.boot.class.path"));
        System.out.println("extClassLoder: " + System.getProperty("java.ext.dirs"));
        System.out.println("applicationClassLoder: " + System.getProperty("java.class.path"));
        System.out.println("applicationgClassLoaderParentClass: " + BootstrapClassLoader.class.getClassLoader());
    }
}
