package com.ranga.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "units")
public class Units implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private Float pergramms;
	private String shortname;
	private Set<Meals> mealses = new HashSet<Meals>(0);

	public Units() {
	}

	public Units(String name) {
		this.name = name;
	}

	public Units(String name, Float pergramms, String shortname, Set<Meals> mealses) {
		this.name = name;
		this.pergramms = pergramms;
		this.shortname = shortname;
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

	@Column(name = "name", nullable = false, length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "pergramms", precision = 12, scale = 0)
	public Float getPergramms() {
		return this.pergramms;
	}

	public void setPergramms(Float pergramms) {
		this.pergramms = pergramms;
	}

	@Column(name = "shortname", length = 20)
	public String getShortname() {
		return this.shortname;
	}

	public void setShortname(String shortname) {
		this.shortname = shortname;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "units")
	public Set<Meals> getMealses() {
		return this.mealses;
	}

	public void setMealses(Set<Meals> mealses) {
		this.mealses = mealses;
	}

}
