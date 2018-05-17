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
@Table(name = "user")
public class User implements java.io.Serializable {


	private static final long serialVersionUID = -4537022956724009381L;
	private Long id;
	
	private String login;
	private String password;
	private String name;
	private Byte gender;
	private Date birthdate;
	private Float weight;
	private Float height;
	private String goal;
	private String activity;
	private Date created;
	private Date updated;
	
	private Roles roles;
	private Statuses statuses;
	private Set<Meals> mealses = new HashSet<Meals>(0);

	public User() {
	}

	public User(Roles roles, Statuses statuses, String login, String password, Date created) {
		this.roles = roles;
		this.statuses = statuses;
		this.login = login;
		this.password = password;
		this.created = created;
	}

	public User(Roles roles, Statuses statuses, String login, String password, String name, Byte gender, Date birthdate,
			Float weight, Float height, String goal, String activity, Date created, Date updated,  Set<Meals> mealses) {
		this.roles = roles;
		this.statuses = statuses;
		this.login = login;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birthdate = birthdate;
		this.weight = weight;
		this.height = height;
		this.goal = goal;
		this.activity = activity;
		this.created = created;
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
	@JoinColumn(name = "id_role", nullable = false)
	public Roles getRoles() {
		return this.roles;
	}

	public void setRoles(Roles roles) {
		this.roles = roles;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_status", nullable = false)
	public Statuses getStatuses() {
		return this.statuses;
	}

	public void setStatuses(Statuses statuses) {
		this.statuses = statuses;
	}
	@Column(name = "login", nullable = false, length = 20)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
	@Column(name = "password", nullable = false, length = 20)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "gender")
	public Byte getGender() {
		return this.gender;
	}

	public void setGender(Byte gender) {
		this.gender = gender;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "birthdate", length = 10)
	public Date getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	@Column(name = "weight", precision = 12, scale = 0)
	public Float getWeight() {
		return this.weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}
	@Column(name = "height", precision = 12, scale = 0)
	public Float getHeight() {
		return this.height;
	}

	public void setHeight(Float height) {
		this.height = height;
	}
	@Column(name = "goal", length = 255)
	public String getGoal() {
		return this.goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
	}
	@Column(name = "activity", length = 255)
	public String getActivity() {
		return this.activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false, length = 19)
	public Date getCreated() {
		return this.created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated", length = 19)
	public Date getUpdated() {
		return this.updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	public  Set<Meals> getMealses() {
		return this.mealses;
	}

	public void setMealses( Set<Meals> mealses) {
		this.mealses = mealses;
	}

}
