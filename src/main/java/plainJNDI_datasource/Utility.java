package plainJNDI_datasource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by Nick on 18.12.2017.
 */

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
}
