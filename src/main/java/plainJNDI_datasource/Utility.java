package plainJNDI_datasource;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by Nick on 18.12.2017.
 */

//@Component
public class Utility {
    public static DataSource DS;

    static {
        try {
            //java:comp/env - can use only in enterprise components
            Context context = (Context) new InitialContext().lookup("java:comp/env");
            DS = (DataSource) context.lookup("jdbs/DBconnect");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    /*@Bean
    public DataSource createDS() {
        DataSource localDS = null;
        try {
            //java:comp/env - can use only in enterprise components
            Context context = (Context) new InitialContext().lookup("java:comp/env");
            localDS = (DataSource) context.lookup("jdbs/DBconnect");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return localDS;
    }*/
}
