package com.ranga.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "dynamics")
public class Dynamics implements java.io.Serializable {

	
	private static final long serialVersionUID = 1L;
	private Long id;
	private long idUser;
	private float weight;
	private Date dtweight;

	public Dynamics() {
	}

	public Dynamics(long idUser, float weight, Date dtweight) {
		this.idUser = idUser;
		this.weight = weight;
		this.dtweight = dtweight;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "id_user", nullable = false)
	public long getIdUser() {
		return this.idUser;
	}

	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}

	@Column(name = "weight", nullable = false, precision = 12, scale = 0)
	public float getWeight() {
		return this.weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dtweight", nullable = false, length = 19)
	public Date getDtweight() {
		return this.dtweight;
	}

	public void setDtweight(Date dtweight) {
		this.dtweight = dtweight;
	}

}
