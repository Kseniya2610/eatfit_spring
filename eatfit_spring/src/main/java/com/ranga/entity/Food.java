package com.ranga.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "food")
public class Food implements java.io.Serializable {


	private static final long serialVersionUID = 9108437050046494818L;
	private Long id;
	private Category category;
	private String name;
	private float kkal;
	private Float protein;
	private Float fat;
	private Float carbs;
	private Date updated;
	private Set<Meals> mealses = new HashSet<Meals>(0);

	public Food() {
	}

	public Food(Category category, String name, float kkal) {
		this.category = category;
		this.name = name;
		this.kkal = kkal;
	}

	public Food(Category category, String name, float kkal, Float protein, Float fat, Float carbs, Date updated,
			Set<Meals> mealses) {
		this.category = category;
		this.name = name;
		this.kkal = kkal;
		this.protein = protein;
		this.fat = fat;
		this.carbs = carbs;
		this.updated = updated;
		this.mealses = mealses;
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
	@JoinColumn(name = "id_category", nullable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "kkal", nullable = false, precision = 12, scale = 0)
	public float getKkal() {
		return this.kkal;
	}

	public void setKkal(float kkal) {
		this.kkal = kkal;
	}

	@Column(name = "protein", precision = 12, scale = 0)
	public Float getProtein() {
		return this.protein;
	}

	public void setProtein(Float protein) {
		this.protein = protein;
	}

	@Column(name = "fat", precision = 12, scale = 0)
	public Float getFat() {
		return this.fat;
	}

	public void setFat(Float fat) {
		this.fat = fat;
	}

	@Column(name = "carbs", precision = 12, scale = 0)
	public Float getCarbs() {
		return this.carbs;
	}

	public void setCarbs(Float carbs) {
		this.carbs = carbs;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated", length = 19)
	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "food")
	public Set<Meals> getMealses() {
		return this.mealses;
	}

	public void setMealses(Set<Meals> mealses) {
		this.mealses = mealses;
	}

}
