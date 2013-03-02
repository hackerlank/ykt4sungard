package org.king.check.domain;



/**
 * TcheckattinfoId generated by MyEclipse - Hibernate Tools
 */

public class TcheckattinfoId  implements java.io.Serializable {


    // Fields    

     private Integer custId;
     private String checkDate;


    // Constructors

    /** default constructor */
    public TcheckattinfoId() {
    }

    

   
    // Property accessors

    public Integer getCustId() {
        return this.custId;
    }
    
    public void setCustId(Integer custId) {
        this.custId = custId;
    }

    public String getCheckDate() {
        return this.checkDate;
    }
    
    public void setCheckDate(String checkDate) {
        this.checkDate = checkDate;
    }
   



   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TcheckattinfoId) ) return false;
		 TcheckattinfoId castOther = ( TcheckattinfoId ) other; 
         
		 return ( (this.getCustId()==castOther.getCustId()) || ( this.getCustId()!=null && castOther.getCustId()!=null && this.getCustId().equals(castOther.getCustId()) ) )
 && ( (this.getCheckDate()==castOther.getCheckDate()) || ( this.getCheckDate()!=null && castOther.getCheckDate()!=null && this.getCheckDate().equals(castOther.getCheckDate()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getCustId() == null ? 0 : this.getCustId().hashCode() );
         result = 37 * result + ( getCheckDate() == null ? 0 : this.getCheckDate().hashCode() );
         return result;
   }   





}