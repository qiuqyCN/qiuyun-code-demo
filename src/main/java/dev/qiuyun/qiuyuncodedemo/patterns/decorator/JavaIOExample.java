package dev.qiuyun.qiuyuncodedemo.patterns.decorator;// ============================================
// 5. Java I/O 装饰器模式示例
// ============================================

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Java I/O 是装饰器模式的经典应用
 * InputStream 是 Component，FileInputStream 是 ConcreteComponent
 * BufferedInputStream、DataInputStream 等是 Decorator
 */
public class JavaIOExample {

    public static void demonstrateIO() {
        String filePath = "example.txt";

        try {
            // 基础文件流
            InputStream fileStream = new FileInputStream(filePath);

            // 添加缓冲功能（装饰）
            InputStream bufferedStream = new BufferedInputStream(fileStream);

            // 添加数据读取功能（再次装饰）
            DataInputStream dataStream = new DataInputStream(bufferedStream);

            // 或者使用更高级的装饰
            Reader reader = new InputStreamReader(dataStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(reader);

            // 读取文件内容
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 写入示例：同样使用装饰器模式
     */
    public static void demonstrateOutput() {
        String filePath = "output.txt";

        try {
            // FileOutputStream -> BufferedOutputStream -> DataOutputStream
            FileOutputStream fos = new FileOutputStream(filePath);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            DataOutputStream dos = new DataOutputStream(bos);

            // 现在可以方便地写入各种数据类型
            dos.writeUTF("Hello, Decorator Pattern!");
            dos.writeInt(42);
            dos.writeDouble(3.14159);

            dos.close(); // 关闭最外层的装饰器会自动关闭内部的流

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

