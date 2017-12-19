package ejbJNDI;

import javax.annotation.Resource;

/**
 * Created by Nick on 19.12.2017.
 *
 * there rBean used like local jndi bean,
 * if you want use RemoteBean from remote server, you should see on remoteJNDI.Client
 */
public class Client {
    @Resource(lookup = "remBean")
    private static RemoteBean rBean;

    public static void main(String[] args) {
        rBean.increment();
        rBean.printNumb();
        System.out.println(rBean.getNumb());
    }
}
