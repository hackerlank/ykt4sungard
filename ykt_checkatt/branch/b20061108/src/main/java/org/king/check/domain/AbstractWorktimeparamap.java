package org.king.check.domain;



/**
 * AbstractWorktimeparamap generated by MyEclipse - Hibernate Tools
 */

public abstract class AbstractWorktimeparamap extends org.king.framework.domain.BaseObject implements java.io.Serializable {


    // Fields    

     private String mapid;
     private String paraid;
     private String worktimeconfid;


    // Constructors

    /** default constructor */
    public AbstractWorktimeparamap() {
    }

    
    /** full constructor */
    public AbstractWorktimeparamap(String paraid, String worktimeconfid) {
        this.paraid = paraid;
        this.worktimeconfid = worktimeconfid;
    }

   
    // Property accessors

    public String getMapid() {
        return this.mapid;
    }
    
    public void setMapid(String mapid) {
        this.mapid = mapid;
    }

    public String getParaid() {
        return this.paraid;
    }
    
    public void setParaid(String paraid) {
        this.paraid = paraid;
    }

    public String getWorktimeconfid() {
        return this.worktimeconfid;
    }
    
    public void setWorktimeconfid(String worktimeconfid) {
        this.worktimeconfid = worktimeconfid;
    }
   








}