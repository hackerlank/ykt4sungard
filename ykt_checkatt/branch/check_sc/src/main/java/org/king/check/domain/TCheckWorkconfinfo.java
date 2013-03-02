package org.king.check.domain;
// Generated by MyEclipse - Hibernate Tools

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;



/**
 * TCheckWorkconfinfo generated by MyEclipse - Hibernate Tools
 */
public class TCheckWorkconfinfo extends AbstractTCheckWorkconfinfo implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public TCheckWorkconfinfo() {
    }

	/** minimal constructor */
    public TCheckWorkconfinfo(TCheckWorkconfinfoId id) {
        super(id);        
    }
    
    /** full constructor */
    public TCheckWorkconfinfo(TCheckWorkconfinfoId id, String workinfoId, String worktimeId, String ifwork) {
        super(id, workinfoId, worktimeId, ifwork);        
    }

	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof TCheckWorkconfinfo)) {
			return false;
		}
		TCheckWorkconfinfo rhs = (TCheckWorkconfinfo) object;
		return new EqualsBuilder().isEquals();
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-474306067, -1397161343).toHashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("id", this.getId()).append(
				"workinfoId", this.getWorkinfoId()).append("ifwork",
				this.getIfwork()).append("worktimeId", this.getWorktimeId())
				.toString();
	}


}
