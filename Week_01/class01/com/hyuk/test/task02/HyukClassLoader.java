package class01.com.hyuk.test.task02;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author : Hyuk
 * @description : HyukClassLoader
 * @date : 2020/10/20 10:30 下午
 */
public class HyukClassLoader extends ClassLoader{

    private String filePath;

    public HyukClassLoader(String filePath) {
        this.filePath = filePath;
    }


    @Override
    protected Class<?> findClass(String name) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(new URI("file://" + filePath)));
            for (int i = 0, len = bytes.length; i < len; ++i) {
                bytes[i] = (byte) (255 - bytes[i]);
            }
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
        throw new RuntimeException("加载类异常");
    }

    public static void main(String[] args) {
        Class<?> clazz = new HyukClassLoader("/Users/liwenbin/work/idea-workspace/JAVA-000/Week_01/class01/com/hyuk/test/task02/Hello.xlass")
                .findClass("Hello");

        Method method = null;
        try {
            method = clazz.getMethod("hello", null);
            method.invoke(clazz.newInstance(), null);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
