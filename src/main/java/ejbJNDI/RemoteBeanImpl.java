package ejbJNDI;

import javax.ejb.Remote;
import javax.ejb.Stateful;

/**
 * Created by Nick on 18.12.2017.
 *
 * After deploy, this bean will be available remotely
 */
@Stateful(mappedName = "remBean") // or @Stateless, in any way, it must be a session bean
@Remote(RemoteBean.class)
public class RemoteBeanImpl implements RemoteBean {
    private volatile int numb = 0;
    @Override
    public void increment() {
        numb++;
    }

    @Override
    public void printNumb() {
        System.out.println(numb);
    }

    @Override
    public int getNumb() {
        return numb;
    }
}
