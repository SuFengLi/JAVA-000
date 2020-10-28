package class04;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : Hyuk
 * @description : HttpServer
 * @date : 2020/10/26 1:22 上午
 */
public class HttpServer {

    public static void main(String[] args) {
        try {
//            startHttpServer01();
//            startHttpServer02();
            startHttpServer03();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void startHttpServer01() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8099);
        while (true) {
            try (Socket socket = serverSocket.accept()) {
                service(socket);
            }
        }
    }

    private static void startHttpServer02() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8099);
        while (true) {
            try (Socket socket = serverSocket.accept()) {
                new Thread(() -> service(socket)).start();
            }
        }
    }

    private static void startHttpServer03() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8099);
        Executor executor = Executors.newFixedThreadPool(20);
        while (true) {
            try (Socket socket = serverSocket.accept()) {
                executor.execute(() -> service(socket));
            }
        }
    }

    private static void service(Socket socket) {
        try {
            Thread.sleep(20);
            try (PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true)) {
                printWriter.println("HTTP/1.1 200 OK");
                printWriter.println("Content-Type:text/html;charset=utf-8");
                printWriter.println();
                printWriter.write("hello,nio");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
