package org.king.check.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractTDept entity provides the base persistence definition of the TDept
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTDept  implements java.io.Serializable {

	// Fields

	private String deptcode;
	private String areacode;
	private String deptname;
	private String deptename;
	private String deptfullname;
	private String fdeptcode;
	private Integer deptlevel;
	private String olddeptcode;
	private String useflag;
	private String lastsaved;
	private Integer depttype;
	private Set classCourseplan = new HashSet();

	// Constructors


	/** default constructor */
	public AbstractTDept() {
	}

	public Set getClassCourseplan() {
		return classCourseplan;
	}

	public void setClassCourseplan(Set classCourseplan) {
		this.classCourseplan = classCourseplan;
	}

	/** minimal constructor */
	public AbstractTDept(String deptcode) {
		this.deptcode = deptcode;
	}

	/** full constructor */
	public AbstractTDept(String deptcode, String areacode, String deptname,
			String deptename, String deptfullname, String fdeptcode,
			Integer deptlevel, String olddeptcode, String useflag,
			String lastsaved, Integer depttype) {
		this.deptcode = deptcode;
		this.areacode = areacode;
		this.deptname = deptname;
		this.deptename = deptename;
		this.deptfullname = deptfullname;
		this.fdeptcode = fdeptcode;
		this.deptlevel = deptlevel;
		this.olddeptcode = olddeptcode;
		this.useflag = useflag;
		this.lastsaved = lastsaved;
		this.depttype = depttype;
	}

	// Property accessors

	public String getDeptcode() {
		return this.deptcode;
	}

	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}

	public String getAreacode() {
		return this.areacode;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public String getDeptname() {
		return this.deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDeptename() {
		return this.deptename;
	}

	public void setDeptename(String deptename) {
		this.deptename = deptename;
	}

	public String getDeptfullname() {
		return this.deptfullname;
	}

	public void setDeptfullname(String deptfullname) {
		this.deptfullname = deptfullname;
	}

	public String getFdeptcode() {
		return this.fdeptcode;
	}

	public void setFdeptcode(String fdeptcode) {
		this.fdeptcode = fdeptcode;
	}

	public String getOlddeptcode() {
		return this.olddeptcode;
	}

	public void setOlddeptcode(String olddeptcode) {
		this.olddeptcode = olddeptcode;
	}

	public String getUseflag() {
		return this.useflag;
	}

	public void setUseflag(String useflag) {
		this.useflag = useflag;
	}

	public String getLastsaved() {
		return this.lastsaved;
	}

	public void setLastsaved(String lastsaved) {
		this.lastsaved = lastsaved;
	}

	public Integer getDeptlevel() {
		return deptlevel;
	}

	public void setDeptlevel(Integer deptlevel) {
		this.deptlevel = deptlevel;
	}

	public Integer getDepttype() {
		return depttype;
	}

	public void setDepttype(Integer depttype) {
		this.depttype = depttype;
	}
}