package com.ds.trainapplication.mapping;
// Generated Apr 8, 2019 9:29:15 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.ds.trainapplication.bean.AbstractTimestampEntity;


/**
 * TrainHasSchedulestationId generated by hbm2java
 */
@Embeddable
public class TrainHasSchedulestationId  extends AbstractTimestampEntity implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = -2260326951834584351L;
	/**
	 * 
	 */
	private int trainId;
     private int scheduleStationId;
     private int scheduleStationStationId;

    public TrainHasSchedulestationId() {
    }

    public TrainHasSchedulestationId(int trainId, int scheduleStationId, int scheduleStationStationId) {
       this.trainId = trainId;
       this.scheduleStationId = scheduleStationId;
       this.scheduleStationStationId = scheduleStationStationId;
    }
   


    @Column(name="train_id", nullable=false)
    public int getTrainId() {
        return this.trainId;
    }
    
    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }


    @Column(name="scheduleStation_id", nullable=false)
    public int getScheduleStationId() {
        return this.scheduleStationId;
    }
    
    public void setScheduleStationId(int scheduleStationId) {
        this.scheduleStationId = scheduleStationId;
    }


    @Column(name="scheduleStation_station_id", nullable=false)
    public int getScheduleStationStationId() {
        return this.scheduleStationStationId;
    }
    
    public void setScheduleStationStationId(int scheduleStationStationId) {
        this.scheduleStationStationId = scheduleStationStationId;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof TrainHasSchedulestationId) ) return false;
		 TrainHasSchedulestationId castOther = ( TrainHasSchedulestationId ) other; 
         
		 return (this.getTrainId()==castOther.getTrainId())
 && (this.getScheduleStationId()==castOther.getScheduleStationId())
 && (this.getScheduleStationStationId()==castOther.getScheduleStationStationId());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getTrainId();
         result = 37 * result + this.getScheduleStationId();
         result = 37 * result + this.getScheduleStationStationId();
         return result;
   }   


}


