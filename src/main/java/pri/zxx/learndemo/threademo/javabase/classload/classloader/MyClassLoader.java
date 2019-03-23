package pri.zxx.learndemo.threademo.javabase.classload.classloader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author 一杯咖啡
 * @desc 自定义类加载器 从本地磁盘中加载指定的类。
 * @createTime 2018-11-17-22:09
 */
public class MyClassLoader extends ClassLoader {
    private final static Path DEFAULT_CLASS_DIR = Paths.get("F:");
    private final Path classDir;

    public MyClassLoader() {
        this.classDir = DEFAULT_CLASS_DIR;
    }

    public MyClassLoader(Path classDir) {
        this.classDir = classDir;
    }

    public MyClassLoader(String classDir, ClassLoader parent) {
        super(parent);
        this.classDir = Paths.get(classDir);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //绕过应用类加载器，不排除根类加载器、扩展类加载器
        //绕过所有父类加载器，用当前加载器
        //MyClassLoader myClassLoader = new MyClassLoader("F:\\",null);
        //MyClassLoader myClassLoader = new MyClassLoader("F:\\",MyClassLoader.class.getClassLoader().getParent());
        MyClassLoader myClassLoader = new MyClassLoader();
        //name 为文件编译时的路径，且加载文件时需要对应的文件夹路径
        Class<?> aClass = myClassLoader.loadClass("javabase.classload.classloader.HelloWorld");
        Class<?> bClass = myClassLoader.loadClass("javabase.classload.classloader.InitHello");
        System.out.println("aclass :" + aClass.getClassLoader() + "\nbclass:" + bClass.getClassLoader());
        //注释以下代码，类会被加载进jvm 但是不会初始化
        Object init = bClass.newInstance();
        Method bShow = bClass.getMethod("show");
        Object hello = aClass.newInstance();
        //invoke(Object,args) Object 代表目标对象的指定方法调用，这里是调用 hello 对象的show 方法。args 代表方法需要的参数
        Method show = aClass.getMethod("show");
        show.invoke(hello);
        bShow.invoke(init);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("name :" + name);
        byte[] classBytes = this.readClassBytes(name);
        if (null == classBytes || classBytes.length == 0) {
            throw new ClassNotFoundException("can not load this class" + name);
        }
        System.out.println("classlenth:" + classBytes.length);
        return this.defineClass(name, classBytes, 0, classBytes.length);
    }

    /*读取二进制class文件*/
    public byte[] readClassBytes(String name) throws ClassNotFoundException {
        String classPath = name.replace(".", "/");
        System.out.println("classpath :" + classPath);
        Path classFullPath = classDir.resolve(Paths.get(classPath + ".class"));
        System.out.println("classFullpath:" + classFullPath);
        if (!classFullPath.toFile().exists()) {
            throw new ClassNotFoundException("the class " + name + " not found.");
        }
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Files.copy(classFullPath, baos);
            return baos.toByteArray();
        } catch (IOException e) {
            throw new ClassNotFoundException("load the class" + name + " occur error.", e);
        }
    }

    @Override
    public String toString() {
        return "My ClassLoader";
    }
}
