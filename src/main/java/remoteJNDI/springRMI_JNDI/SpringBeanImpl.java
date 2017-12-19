package remoteJNDI.springRMI_JNDI;

/**
 * Created by Nick on 19.12.2017.
 */
public class SpringBeanImpl implements SpringBean {
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
