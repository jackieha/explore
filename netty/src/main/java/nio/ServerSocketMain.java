package nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author shuaifeng.gao
 * @since 2020-06-12 10:19
 **/
public class ServerSocketMain {

    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8088), 10);
        Thread.sleep(5000);
        for (int i = 0; i < 100; i++) {
            System.out.println("server accept begin:  " + i);
            Socket socket = serverSocket.accept();
            System.out.println("server accept end:  " + i);
//            socket.close();
        }

        Thread.sleep(100000);

//        char[] chars = new char[15];
//        ServerSocket serverSocket = new ServerSocket(8088);
//        System.out.println("阻塞开始");
//        Socket socket = serverSocket.accept();
//        System.out.println("链接建立！");
//        InputStream is = socket.getInputStream();
//        InputStreamReader isr = new InputStreamReader(is);
//        System.out.println("开始读取数据");
//        int length = isr.read(chars);
//        System.out.println("读取到数据");
//        while (length != -1){
//            System.out.println(new String(chars, 0, length));
//            length = isr.read(chars);
//        }
//        is.close();
//        isr.close();
//        socket.close();
//        serverSocket.close();
//        System.out.println("DONE!!!");
    }

}
