package LDAP;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Nick on 19.12.2017.
 */
@Entity
public class LdapEntity {
    @Id
    public Integer id;
    public String name;
}
