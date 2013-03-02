package org.king.security.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;



/**
 * AbstractPerson generated by MyEclipse - Hibernate Tools
 */

public abstract class AbstractPerson extends org.king.framework.domain.BaseObject implements java.io.Serializable {


    // Fields    

     private Integer custid;
     private String stuempno;
     private String custname;
     private String sex;
     private String email;
     private Integer custtype;
     private String tel;
     private String mobile;
     private String addr;
     private String deptcode;
     private Account account;

    // Constructors

    /** default constructor */
    public AbstractPerson() {
    }

    /** full constructor */
    public AbstractPerson(Integer custid, String stuempno, String custname, String sex, String email, Integer custtype, String tel, String mobile, String addr,String deptcode) {
        this.custid = custid;
        this.stuempno = stuempno;
        this.custname = custname;
        this.sex = sex;
        this.email = email;
        this.custtype = custtype;
        this.tel = tel;
        this.mobile = mobile;
        this.addr = addr;
        this.deptcode = deptcode;
    }

   
    // Property accessors


    public Integer getCustid() {
        return custid;
    }

    public void setCustid(Integer custid) {
        this.custid = custid;
    }

    public String getStuempno() {
        return stuempno;
    }

    public void setStuempno(String stuempno) {
        this.stuempno = stuempno;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCusttype() {
        return custtype;
    }

    public void setCusttype(Integer custtype) {
        this.custtype = custtype;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    /**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof AbstractPerson)) {
			return false;
		}
		AbstractPerson rhs = (AbstractPerson) object;
        return new EqualsBuilder().append(this.custid, rhs.custid).append(this.addr, rhs.addr)
                .append(this.custtype, rhs.custtype).append(this.custname, rhs.custname)
                .append(this.email, rhs.email).append(this.mobile, rhs.mobile)
                .append(this.stuempno, rhs.stuempno).append(this.sex, rhs.sex)
                .append(this.tel, rhs.tel).append(this.deptcode,rhs.deptcode).isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
        return new HashCodeBuilder(-1964393905, -474767665).append(this.custid)
                .append(this.addr).append(this.custtype)
                .append(this.custname).append(this.email).append(this.mobile)
                .append(this.stuempno).append(this.sex)
                .append(this.tel).append(this.deptcode).toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("custid", this.custid).append("addr", this.addr)
                .append("custtype", this.custtype).append("custname", this.custname)
                .append("email", this.email).append("mobile", this.mobile)
                .append("stuempno", this.stuempno).append("sex", this.sex)
                .append("tel", this.tel).append("deptcode",this.deptcode).toString();
	}
}