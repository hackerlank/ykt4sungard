package org.king.check.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;



/**
 * AbstractClerk generated by MyEclipse - Hibernate Tools
 */

public abstract class AbstractClerk extends org.king.framework.domain.BaseObject implements java.io.Serializable {


    // Fields    

     private Integer clerkid;
     private String isseat;
     private String isirregularrest;
     private String password;
     private String stunumber;
     private String cardnumber;
     private String clerkname;
     private String isextrawork;
     private String worktimeconfid;

     private Department department;
     
    // Constructors

    /** default constructor */
    public AbstractClerk() {
    }

	/** minimal constructor */
    public AbstractClerk(Integer clerkid) {
        this.clerkid = clerkid;
    }
    
    /** full constructor */
    public AbstractClerk(Integer clerkid, String departmentid, String isseat, String isirregularrest, String password, String stunumber, String cardnumber, String clerkname, String isextrawork, String worktimeconfid) {
        this.clerkid = clerkid;
        this.isseat = isseat;
        this.isirregularrest = isirregularrest;
        this.password = password;
        this.stunumber = stunumber;
        this.cardnumber = cardnumber;
        this.clerkname = clerkname;
        this.isextrawork = isextrawork;
        this.worktimeconfid = worktimeconfid;
    }

   
    // Property accessors



    public String getIsseat() {
        return this.isseat;
    }
    
    public void setIsseat(String isseat) {
        this.isseat = isseat;
    }

    public String getIsirregularrest() {
        return this.isirregularrest;
    }
    
    public void setIsirregularrest(String isirregularrest) {
        this.isirregularrest = isirregularrest;
    }

    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public String getStunumber() {
        return this.stunumber;
    }
    
    public void setStunumber(String stunumber) {
        this.stunumber = stunumber;
    }

    public String getCardnumber() {
        return this.cardnumber;
    }
    
    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber;
    }

    public String getClerkname() {
        return this.clerkname;
    }
    
    public void setClerkname(String clerkname) {
        this.clerkname = clerkname;
    }

    public String getIsextrawork() {
        return this.isextrawork;
    }
    
    public void setIsextrawork(String isextrawork) {
        this.isextrawork = isextrawork;
    }

    public String getWorktimeconfid() {
        return this.worktimeconfid;
    }
    
    public void setWorktimeconfid(String worktimeconfid) {
        this.worktimeconfid = worktimeconfid;
    }

    
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof AbstractClerk)) {
			return false;
		}
		AbstractClerk rhs = (AbstractClerk) object;
		return new EqualsBuilder().append(this.password, rhs.password).append(this.cardnumber,
				rhs.cardnumber).append(this.worktimeconfid, rhs.worktimeconfid)
				.append(this.clerkname, rhs.clerkname).append(
						this.isirregularrest, rhs.isirregularrest).append(
						this.stunumber, rhs.stunumber).append(this.isseat,
						rhs.isseat).append(this.clerkid, rhs.clerkid).append(
						this.isextrawork, rhs.isextrawork).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-1226525101, 851959011)
				.append(this.password).append(
						this.cardnumber).append(this.worktimeconfid).append(
						this.clerkname).append(this.isirregularrest).append(
						this.stunumber).append(this.isseat)
				.append(this.clerkid).append(this.isextrawork).toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
				.append("stunumber", this.stunumber).append("isirregularrest",
						this.isirregularrest).append("isseat", this.isseat)
				.append("clerkname", this.clerkname).append("password",
						this.password).append("worktimeconfid",
						this.worktimeconfid).append("isextrawork",
						this.isextrawork).append("cardnumber", this.cardnumber)
				.append("clerkid", this.clerkid).toString();
	}

	public Integer getClerkid() {
		return clerkid;
	}

	public void setClerkid(Integer clerkid) {
		this.clerkid = clerkid;
	}
   








}