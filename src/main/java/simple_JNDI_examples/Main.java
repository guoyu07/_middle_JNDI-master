package simple_JNDI_examples;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by Nick on 18.12.2017.
 */
public class Main {
    @Resource(lookup = "java:global/deploymentD")
    private static String injectJNDI;

    static {
        try {
            InitialContext initialContext = new InitialContext();
            initialContext.bind("java:global/prog", 100);
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws NamingException {
        //from deployment descriptor
        printLookup("java:global/deploymentD");
        //set it programatically
        printLookup("java:global/prog");
        System.out.println(injectJNDI);
    }
    public static void printLookup(String name) throws NamingException {
        Context context = new InitialContext(); //.lookup("java:comp/env");
        String element = (String) context.lookup(name);
        //or simply//element = InitialContext.doLookup(name);
        System.out.println(element);
    }

/*
Four different types of bindings are supported:

Simple - A primitive or java.net.URL entry (default is java.lang.String).
Object Factory - This allows to to specify the javax.naming.spi.ObjectFactory that is used to create the looked up value.
External Context - An external context to federate, such as an LDAP Directory Service
Lookup - The allows to create JNDI aliases, when this entry is looked up it will lookup the target and return the result.

An example standalone.xml might look like:

<subsystem xmlns="urn:jboss:domain:naming:2.0" >
  <bindings>
    <simple name="java:global/a" value="100" type="int" />
    <simple name="java:global/jbossDocs" value="https://docs.jboss.org" type="java.net.URL" />
    <object-factory name="java:global/b" module="com.acme" class="org.acme.MyObjectFactory" />
    <external-context name="java:global/federation/ldap/example” class="javax.naming.directory.InitialDirContext" cache="true">
      <environment>
        <property name="java.naming.factory.initial" value=“com.sun.jndi.ldap.LdapCtxFactory” />
        <property name="java.naming.provider.url" value=“ldap://ldap.example.com:389” />
        <property name="java.naming.security.authentication" value=“simple” />
        <property name="java.naming.security.principal" value=“uid=admin,ou=system” />
        <property name="java.naming.security.credentials" value=“secret” />
      </environment>
    </external-context>
    <lookup name="java:global/c" lookup="java:global/b" />
 </bindings>
</subsystem>*/
}
