package nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author shuaifeng.gao
 * @since 2020-06-12 10:25
 **/
public class SocketMain {

    public static void main(String[] args) throws IOException, InterruptedException {

        for (int i = 0; i < 100; i++) {
            System.out.println("client begin:" + i);
            Socket socket = new Socket("localhost", 8088);
            System.out.println("client end:" + i);
        }

//        Socket socket = new Socket("localhost", 8088);
//        System.out.println("连接成功");
//        Thread.sleep(2000);
//        OutputStream os = socket.getOutputStream();
//        os.write("我是中国人1".getBytes());
//        Thread.sleep(1000);
//        os.write("我是中国人2".getBytes());
//        Thread.sleep(1000);
//        os.write("我是中国人4".getBytes());
//        System.out.println("发送结束");
//        os.close();
//        socket.close();
    }

}
