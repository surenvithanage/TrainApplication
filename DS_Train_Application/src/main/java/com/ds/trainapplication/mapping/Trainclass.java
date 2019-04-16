package com.ds.trainapplication.mapping;
// Generated Apr 8, 2019 9:29:15 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.ds.trainapplication.bean.AbstractTimestampEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * Trainclass generated by hbm2java
 */
@Entity
@Table(name = "trainclass", catalog = "trainapplication")
public class Trainclass extends AbstractTimestampEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5898361181179459024L;
	/**
	* 
	*/
	
	private Integer id;
	private String name;
	private Set<Train> trains = new HashSet<Train>(0);

	public Trainclass() {
	}

	public Trainclass(String name, Set<Train> trains) {
		this.name = name;
		this.trains = trains;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "trainclass_has_train", catalog = "trainapplication", joinColumns = {
			@JoinColumn(name = "trainClass_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "train_id", nullable = false, updatable = false) })
	@JsonManagedReference
	public Set<Train> getTrains() {
		return this.trains;
	}

	public void setTrains(Set<Train> trains) {
		this.trains = trains;
	}

}