package org.king.check.domain;



/**
 * AbstractWorkconf generated by MyEclipse - Hibernate Tools
 */

public abstract class AbstractWorkconf extends org.king.framework.domain.BaseObject implements java.io.Serializable {


    // Fields    

     private String workconfid;
     private String confname;
     private Integer permitlatetime;
     private Integer preearly;
     private Integer ondutyad;
     private Integer offdutyovertime;


    // Constructors

    /** default constructor */
    public AbstractWorkconf() {
    }

    
    /** full constructor */
    public AbstractWorkconf(String confname, Integer permitlatetime, Integer preearly, Integer ondutyad, Integer offdutyovertime) {
        this.confname = confname;
        this.permitlatetime = permitlatetime;
        this.preearly = preearly;
        this.ondutyad = ondutyad;
        this.offdutyovertime = offdutyovertime;
    }

   
    // Property accessors

    public String getWorkconfid() {
        return this.workconfid;
    }
    
    public void setWorkconfid(String workconfid) {
        this.workconfid = workconfid;
    }

    public String getConfname() {
        return this.confname;
    }
    
    public void setConfname(String confname) {
        this.confname = confname;
    }

    public Integer getPermitlatetime() {
        return this.permitlatetime;
    }
    
    public void setPermitlatetime(Integer permitlatetime) {
        this.permitlatetime = permitlatetime;
    }

    public Integer getPreearly() {
        return this.preearly;
    }
    
    public void setPreearly(Integer preearly) {
        this.preearly = preearly;
    }

    public Integer getOndutyad() {
        return this.ondutyad;
    }
    
    public void setOndutyad(Integer ondutyad) {
        this.ondutyad = ondutyad;
    }

    public Integer getOffdutyovertime() {
        return this.offdutyovertime;
    }
    
    public void setOffdutyovertime(Integer offdutyovertime) {
        this.offdutyovertime = offdutyovertime;
    }
   








}