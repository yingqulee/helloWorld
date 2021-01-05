package Inspiration;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) {

        InetAddress address = null;
        try {
//            address = InetAddress.getByName("www.baidu.com");;
//            address = InetAddress.getAllByName("www.baidu.com");
            address = InetAddress.getLocalHost();
            System.out.println(address);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
