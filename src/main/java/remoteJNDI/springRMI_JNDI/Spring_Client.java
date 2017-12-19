package remoteJNDI.springRMI_JNDI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by Nick on 19.12.2017.
 */
@Component
public class Spring_Client {
    @Autowired
    @Qualifier("remoteBean")
    private static SpringBean remote;

    public static void main(String[] args) {
        remote.increment();
        remote.printNumb();
        System.out.println(remote.getNumb());
    }
}
