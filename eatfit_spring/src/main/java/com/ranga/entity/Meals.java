package com.ranga.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "meals")
public class Meals implements java.io.Serializable {


	private static final long serialVersionUID = 6097930258595834221L;
	private Long id;
	private Food food;
	private Mealtypes mealtypes;
	private Units units;
	private User user;
	private Date dtmeal;
	private float amount;
	private float kkal;

	public Meals() {
	}

	public Meals(Food food, Mealtypes mealtypes, Units units, User user, Date dtmeal, float amount, float kkal) {
		this.food = food;
		this.mealtypes = mealtypes;
		this.units = units;
		this.user = user;
		this.dtmeal = dtmeal;
		this.amount = amount;
		this.kkal = kkal;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_food", nullable = false)
	public Food getFood() {
		return this.food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_mealtype", nullable = false)
	public Mealtypes getMealtypes() {
		return this.mealtypes;
	}

	public void setMealtypes(Mealtypes mealtypes) {
		this.mealtypes = mealtypes;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_units", nullable = false)
	public Units getUnits() {
		return this.units;
	}

	public void setUnits(Units units) {
		this.units = units;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "dtmeal", nullable = false, length = 19)
	public Date getDtmeal() {
		return this.dtmeal;
	}

	public void setDtmeal(Date dtmeal) {
		this.dtmeal = dtmeal;
	}

	@Column(name = "amount", nullable = false, precision = 12, scale = 0)
	public float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	@Column(name = "kkal", nullable = false, precision = 12, scale = 0)
	public float getKkal() {
		return this.kkal;
	}

	public void setKkal(float kkal) {
		this.kkal = kkal;
	}

}
