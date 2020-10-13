package nio;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @author shuaifeng.gao
 * @since 2020-06-11 10:46
 **/
public class Main {

    public static void main(String[] args) {
        byte[] a = {1,2,3,4};

//        dirAllocate();
//        heapAllocate();
        networkInterface();
    }

    private static void dirAllocate(){
        long start = System.currentTimeMillis();
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1900000000);
        for (int i = 0; i < 1900000000; i++) {
            byteBuffer.put((byte)1);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void heapAllocate(){
        long start = System.currentTimeMillis();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1900000000);
        for (int i = 0; i < 1900000000; i++) {
            byteBuffer.put((byte)1);
        }
        System.out.println(System.currentTimeMillis() - start);
    }

    private static void networkInterface(){
        try {
            Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
            while (nis.hasMoreElements()){
                NetworkInterface ni = nis.nextElement();
                System.out.println("网络设备名称：" + ni.getName());
                System.out.println("网络设备显示名称：" + ni.getDisplayName());
                System.out.println("网络接口索引：" + ni.getIndex());
                System.out.println("isUp：" + ni.isUp());
                System.out.println("isLoopback：" + ni.isLoopback());
                System.out.println("ni:" + ni);
                System.out.println("MTU(Maximum Transmission Unit):" + ni.getMTU());
                System.out.println("supInterface:" + (ni.getSubInterfaces().hasMoreElements() ? ni.getSubInterfaces().nextElement() : null));
                System.out.println("isVirtual:" + ni.isVirtual());
                System.out.println("MAC 地址：" + Arrays.toString( ni.getHardwareAddress() ));
                System.out.println("supportsMulticast:" + ni.supportsMulticast());

                Enumeration<InetAddress> ads = ni.getInetAddresses();
                while (ads.hasMoreElements()){
                    InetAddress ad = ads.nextElement();
                    System.out.println("+ :" + ad);
                    System.out.println("+ getCanonicalHostName:" + ad.getCanonicalHostName());
                    System.out.println("+ getHostName:" + ad.getHostName());
                    System.out.println("+ getHostAddress:" + ad.getHostAddress());
                    System.out.println("+ getAddress:" + Arrays.toString(ad.getAddress()));
                }

                System.out.println("****************");
            }

        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

}
