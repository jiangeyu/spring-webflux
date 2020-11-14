package lang.nio;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午2:28 2019/12/19
 */
public class ServerDemo {

    public static void main(String[] args) {
        int port = 8080;

        MultiTimeServer timeServer = new MultiTimeServer(port);
        new Thread(timeServer, "server1").start();
    }
}
