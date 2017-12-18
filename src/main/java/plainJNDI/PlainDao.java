package plainJNDI;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Nick on 18.12.2017.
 */
public class PlainDao {
    private DataSource DS;
    private Connection connection;

    public PlainDao() {
        this.DS = Utility.DS;
    }

    public void add(Object o) {
        try {
            this.connection = DS.getConnection();
            Statement st = this.connection.createStatement();
            //// and so on!
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
