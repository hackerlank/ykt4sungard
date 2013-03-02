package org.king.security.domain;
// Generated by MyEclipse - Hibernate Tools



/**
 * Account generated by MyEclipse - Hibernate Tools
 */
public class Account extends AbstractAccount implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Account() {
    }
    
    /** minimal constructor */
    public Account(String name) {
        super(name);
    }
    
    /** full constructor */
    public Account(String name, String password, String enabled) {
        super(name, password, enabled);        
    }
   
}
