package org.king.check.domain;



/**
 * AbstractVacation generated by MyEclipse - Hibernate Tools
 */

public abstract class AbstractVacation extends org.king.framework.domain.BaseObject implements java.io.Serializable {


    // Fields    

     private String vactionid;
     private String departid;
     private String startdate;
     private String enddate;
     private String vactionalname;
     private String isglobe;


    // Constructors

    /** default constructor */
    public AbstractVacation() {
    }

    
    /** full constructor */
    public AbstractVacation(String departid, String startdate, String enddate, String vactionalname,String isglobe) {
        this.departid = departid;
        this.startdate = startdate;
        this.enddate = enddate;
        this.vactionalname = vactionalname;
        this.isglobe=isglobe;
    }

   
    // Property accessors

    public String getVactionid() {
        return this.vactionid;
    }
    
    public void setVactionid(String vactionid) {
        this.vactionid = vactionid;
    }

    public String getDepartid() {
		return departid;
	}


	public void setDepartid(String departid) {
		this.departid = departid;
	}

	
	public String getEnddate() {
		return enddate;
	}


	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}


	public String getStartdate() {
		return startdate;
	}


	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}


	public String getVactionalname() {
        return this.vactionalname;
    }
    
    public void setVactionalname(String vactionalname) {
        this.vactionalname = vactionalname;
    }


	public String getIsglobe() {
		return isglobe;
	}


	public void setIsglobe(String isglobe) {
		this.isglobe = isglobe;
	}
   








}