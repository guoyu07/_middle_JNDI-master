package springJNDI_datasource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Nick on 18.12.2017.
 */
@Component
public class DAO {
    @Autowired
    @Qualifier("jndiDataSource")
    private DataSource DS;

    public void add(Object o) {
        try {
            Connection connection = DS.getConnection();
            Statement st = connection.createStatement();
            //// and so on!
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
