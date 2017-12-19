package LDAP;

/**
 * Created by Nick on 19.12.2017.
 */
public interface Dao {
    LdapEntity getEntity(int id);
    void addEntity();
}
