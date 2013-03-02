package org.king.check.domain;



/**
 * TclerkdevmappingId generated by MyEclipse - Hibernate Tools
 */

public class TclerkdevmappingId  implements java.io.Serializable {


    // Fields    

     private Integer custId;
     private Integer deviceId;


    // Constructors

    /** default constructor */
    public TclerkdevmappingId() {
    }

    

   
    // Property accessors

    public Integer getCustId() {
        return this.custId;
    }
    
    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public Integer getDeviceId() {
        return this.deviceId;
    }
    
    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TclerkdevmappingId) ) return false;
		 TclerkdevmappingId castOther = ( TclerkdevmappingId ) other; 
         
		 return ( (this.getCustId()==castOther.getCustId()) || ( this.getCustId()!=null && castOther.getCustId()!=null && this.getCustId().equals(castOther.getCustId()) ) )
 && ( (this.getDeviceId()==castOther.getDeviceId()) || ( this.getDeviceId()!=null && castOther.getDeviceId()!=null && this.getDeviceId().equals(castOther.getDeviceId()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCustId() == null ? 0 : this.getCustId().hashCode() );
         result = 37 * result + ( getDeviceId() == null ? 0 : this.getDeviceId().hashCode() );
         return result;
   }   





}