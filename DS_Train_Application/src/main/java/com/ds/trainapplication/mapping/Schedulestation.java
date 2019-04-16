package com.ds.trainapplication.mapping;
// Generated Apr 8, 2019 9:29:15 PM by Hibernate Tools 4.3.1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ds.trainapplication.bean.AbstractTimestampEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Schedulestation generated by hbm2java
 */
@Entity
@Table(name = "schedulestation", catalog = "trainapplication")
public class Schedulestation extends AbstractTimestampEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6969983007143685148L;

	private SchedulestationId id;
	private Station station;
	private Date arrivalTime;
	private Date departureTime;
	private Set<TrainHasSchedulestation> trainHasSchedulestations = new HashSet<TrainHasSchedulestation>(0);

	public Schedulestation() {
	}

	public Schedulestation(SchedulestationId id, Station station) {
		this.id = id;
		this.station = station;
	}

	public Schedulestation(SchedulestationId id, Station station, Date arrivalTime, Date departureTime,
			Set<TrainHasSchedulestation> trainHasSchedulestations) {
		this.id = id;
		this.station = station;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.trainHasSchedulestations = trainHasSchedulestations;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "id", nullable = false)),
			@AttributeOverride(name = "stationId", column = @Column(name = "station_id", nullable = false)) })
	public SchedulestationId getId() {
		return this.id;
	}

	public void setId(SchedulestationId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "station_id", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	public Station getStation() {
		return this.station;
	}

	public void setStation(Station station) {
		this.station = station;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "arrival_time", length = 10)
	public Date getArrivalTime() {
		return this.arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "departure_time", length = 10)
	public Date getDepartureTime() {
		return this.departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "schedulestation")
	@JsonIgnore
	public Set<TrainHasSchedulestation> getTrainHasSchedulestations() {
		return this.trainHasSchedulestations;
	}

	public void setTrainHasSchedulestations(Set<TrainHasSchedulestation> trainHasSchedulestations) {
		this.trainHasSchedulestations = trainHasSchedulestations;
	}

}
