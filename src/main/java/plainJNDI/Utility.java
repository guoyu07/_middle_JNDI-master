package plainJNDI;

import javax.ejb.EJB;
import javax.ejb.Stateless;
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
            Context context = new InitialContext();
            DS = (DataSource) context.lookup("jdbs/DBconnect");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
