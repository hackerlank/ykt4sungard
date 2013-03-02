package org.king.check.domain;
// Generated by MyEclipse - Hibernate Tools

import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;



/**
 * Tworkconfinfo generated by MyEclipse - Hibernate Tools
 */
public class Tworkconfinfo extends AbstractTworkconfinfo implements Comparable, java.io.Serializable {

    // Constructors

    /** default constructor */
    public Tworkconfinfo() {
    }

    
    /** full constructor */
    public Tworkconfinfo(String workconfName, Integer overdueTime, Integer leaveearlyTime, Integer overTime, Integer delayTime, Integer checkTime,String deptId) {
        super(workconfName, overdueTime, leaveearlyTime, overTime, delayTime, checkTime,deptId);        
    }


	/**
	 * @see java.lang.Comparable#compareTo(Object)
	 */
	public int compareTo(Object object) {
		Tworkconfinfo myClass = (Tworkconfinfo) object;
		return new CompareToBuilder().toComparison();
	}


	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Tworkconfinfo)) {
			return false;
		}
		Tworkconfinfo rhs = (Tworkconfinfo) object;
		return new EqualsBuilder().isEquals();
	}


	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(775163919, 998661925).toHashCode();
	}


	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("overTime", this.getOverTime())
				.append("overdueTime", this.getOverdueTime()).append(
						"delayTime", this.getDelayTime()).append("workconfId",
						this.getWorkconfId()).append("workconfName",
						this.getWorkconfName()).append("checkTime",
						this.getCheckTime()).append("leaveearlyTime",
						this.getLeaveearlyTime()).toString();
	}
   
}
