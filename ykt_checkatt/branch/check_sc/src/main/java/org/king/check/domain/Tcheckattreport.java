package org.king.check.domain;

// Generated by MyEclipse - Hibernate Tools

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * TCheckattReport generated by MyEclipse - Hibernate Tools
 */
public class TCheckattReport extends AbstractTCheckattReport implements
		java.io.Serializable { 

	// Constructors

	/** default constructor */
	public TCheckattReport() {
	}

	/** minimal constructor */
	public TCheckattReport(TCheckattReportId id) {
		super(id);
	}

	/** full constructor */
	public TCheckattReport(TCheckattReportId id, String ifoffice,
			Integer worktimeValue, Integer factValue, Integer handTimes,
			Integer overtimeValue, Integer tworestValue, Integer holidayValue,
			Integer delayValue, Integer leaveEarly, Integer leaveValue,
			String leaveType, Integer leaveTime, Integer ext1, Integer ext2,
			Integer ext3, Integer ext4, Integer ext5, Integer checkNum,
			Integer delayNum, Integer earlyNum, Integer leaveNum,
			Integer extcheckNum, Integer worktimeNum) {
		super(id, ifoffice, worktimeValue, factValue, handTimes, overtimeValue,
				tworestValue, holidayValue, delayValue, leaveEarly, leaveValue,
				leaveType, leaveTime, ext1, ext2, ext3, ext4, ext5, checkNum,
				delayNum, earlyNum, leaveNum, extcheckNum, worktimeNum);
	}

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof TCheckattReport)) {
			return false;
		}
		TCheckattReport rhs = (TCheckattReport) object;
		return new EqualsBuilder().isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(946537753, 897899083).toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("extcheckNum",
				this.getExtcheckNum()).append("holidayValue",
				this.getHolidayValue()).append("id", this.getId()).append(
				"worktimeValue", this.getWorktimeValue()).append("ext1",
				this.getExt1()).append("earlyNum", this.getEarlyNum()).append(
				"checkNum", this.getCheckNum()).append("overtimeValue",
				this.getOvertimeValue()).append("factValue",
				this.getFactValue()).append("handTimes", this.getHandTimes())
				.append("ext4", this.getExt4()).append("ext3", this.getExt3())
				.append("leaveTime", this.getLeaveTime()).append("delayNum",
						this.getDelayNum()).append("leaveType",
						this.getLeaveType()).append("ext5", this.getExt5())
				.append("ext2", this.getExt2()).append("leaveNum",
						this.getLeaveNum()).append("leaveEarly",
						this.getLeaveEarly()).append("worktimeNum",
						this.getWorktimeNum()).append("delayValue",
						this.getDelayValue()).append("ifoffice",
						this.getIfoffice()).append("leaveValue",
						this.getLeaveValue()).append("tworestValue",
						this.getTworestValue()).toString();
	}

}
