package remoteJNDI;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

/**
 * Created by Nick on 18.12.2017.
 */
public class Client {
    private static Properties prop;
    private static Context context;
    static {
        try {
            prop = new Properties();
            prop.put(Context.INITIAL_CONTEXT_FACTORY, org.jboss.naming.remote.client.InitialContextFactory.class.getName());
            prop.put(Context.PROVIDER_URL, "remote://localhost:4447");
            context = new InitialContext(prop);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws NamingException {
        /**
         * we can get bean address from jboss admin panel or by our methods lookupRemoteBeanStateless(), lookupRemoteBeanStateful()
         */
        printLookup("ejb:myapp/myejbjar/MyEjbName!com.test.MyRemoteInterface");
    }

    public static void printLookup(String name) throws NamingException {
        System.out.println(context.lookup(name));
    }

    /**
     * Create bean name in order to remotely lookup it
     */
    private static String lookupRemoteBeanStateless() throws NamingException {
        // The app name is the application name of the deployed EJBs. This is typically the ear name
        // without the .ear suffix. However, the application name could be overridden in the application.xml of the
        // EJB deployment on the server.
        // Since we haven't deployed the application as a .ear, the app name for us will be an empty string
        final String appName = "";
        // This is the module name of the deployed EJBs on the server. This is typically the jar name of the
        // EJB deployment, without the .jar suffix, but can be overridden via the ejb-jar.xml
        // In this example, we have deployed the EJBs in a jboss-as-ejb-remote-app.jar, so the module name is
        // jboss-as-ejb-remote-app
        final String moduleName = "jboss-as-ejb-remote-app";
        // AS7 allows each deployment to have an (optional) distinct name. We haven't specified a distinct name for
        // our EJB deployment, so this is an empty string
        final String distinctName = "";
        // The EJB name which by default is the simple class name of the bean implementation class
        final String beanName = RemoteBean.class.getSimpleName();
        // the remote view fully qualified class name
        final String viewClassName = RemoteBeanImpl.class.getName();

        return new String("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
    }

    /**
     * Create bean name in order to lookup it
     */
    private static String lookupRemoteBeanStateful() throws NamingException {
        // The app name is the application name of the deployed EJBs. This is typically the ear name
        // without the .ear suffix. However, the application name could be overridden in the application.xml of the
        // EJB deployment on the server.
        // Since we haven't deployed the application as a .ear, the app name for us will be an empty string
        final String appName = "";
        // This is the module name of the deployed EJBs on the server. This is typically the jar name of the
        // EJB deployment, without the .jar suffix, but can be overridden via the ejb-jar.xml
        // In this example, we have deployed the EJBs in a jboss-as-ejb-remote-app.jar, so the module name is
        // jboss-as-ejb-remote-app
        final String moduleName = "jboss-as-ejb-remote-app";
        // AS7 allows each deployment to have an (optional) distinct name. We haven't specified a distinct name for
        // our EJB deployment, so this is an empty string
        final String distinctName = "";
        // The EJB name which by default is the simple class name of the bean implementation class
        final String beanName = RemoteBean.class.getSimpleName();
        // the remote view fully qualified class name
        final String viewClassName = RemoteBeanImpl.class.getName();
        // notice the ?stateful string as the last part of the jndi name for stateful bean lookup
        return new String("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName + "?stateful");
    }
}
