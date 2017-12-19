package LDAP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by Nick on 19.12.2017.
 */
@Component
public class DaoImpl implements Dao {
    private LdapTemplate template;

    @Autowired
    public DaoImpl(LdapTemplate ldapTemplate) {
        this.template = ldapTemplate;
    }

    @Override
    public LdapEntity getEntity(int id) {
        //business code here
        return null;
    }

    @Override
    public void addEntity() {
        //business code here
    }
}
