package org.king.check.domain;
// Generated by MyEclipse - Hibernate Tools

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;



/**
 * Tattserialrecord generated by MyEclipse - Hibernate Tools
 */
public class Tattserialrecord extends AbstractTattserialrecord implements java.io.Serializable {

    // Constructors

    /** default constructor */
    public Tattserialrecord() {
    }

    
    /** full constructor */
    public Tattserialrecord(Integer cardId, String phyId, String showCardno, String attDate, String attTime, String operId, String operDate, String operTime, String remark, Integer custId) {
        super(cardId, phyId, showCardno, attDate, attTime, operId, operDate, operTime, remark, custId);        
    }


	/**
	 * @see java.lang.Object#equals(Object)
	 */
	public boolean equals(Object object) {
		if (!(object instanceof Tattserialrecord)) {
			return false;
		}
		Tattserialrecord rhs = (Tattserialrecord) object;
		return new EqualsBuilder().isEquals();
	}


	/**
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder(-1064533611, -1526804305).toHashCode();
	}


	/**
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new ToStringBuilder(this).append("attTime", this.getAttTime())
				.append("serialId", this.getSerialId()).append("operTime",
						this.getOperTime()).append("custId", this.getCustId())
				.append("operId", this.getOperId()).append("showCardno",
						this.getShowCardno()).append("attDate",
						this.getAttDate()).append("cardId", this.getCardId())
				.append("phyId", this.getPhyId()).append("remark",
						this.getRemark())
				.append("operDate", this.getOperDate()).toString();
	}
   
}
