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
@Table(name = "mealtypes")
public class Mealtypes implements java.io.Serializable {

	private static final long serialVersionUID = 6973121019051487972L;
	private Long id;
	private String name;
	private Set<Meals> mealses = new HashSet<Meals>(0);

	public Mealtypes() {
	}

	public Mealtypes(String name) {
		this.name = name;
	}

	public Mealtypes(String name, Set<Meals> mealses) {
		this.name = name;
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

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mealtypes")
	public Set<Meals> getMealses() {
		return this.mealses;
	}

	public void setMealses(Set<Meals> mealses) {
		this.mealses = mealses;
	}

}
