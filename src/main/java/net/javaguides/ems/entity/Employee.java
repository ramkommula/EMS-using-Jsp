package net.javaguides.ems.entity;

//import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // Here, The values of this id field will be automatically generated by database
						// on browser.

	// @Column(name = "first_name", nullable = false)
	// @Size(min=3, max=50)
	// @NotNull
	// @NotEmpty(message = "Field can't be empty!")
	private String firstName;

	// @Column(name = "last_name")
	// @NotNull
	// @NotEmpty
	// @Size(min=2, max=50)
	private String lastName;

	// @Column(name = "email")
	// @NotNull
	// @NotBlank
	// @Email
	private String email;

	// @Column(name = "gender")
	// @NotBlank
	private String gender;

	// @Column(name = "marriage")
	// @NotNull
	// @NotBlank
	private String marriage;

	// @Column(name = "birthday")
	 @DateTimeFormat(pattern = "dd-mm-yyyy")
	 @NotNull(message = "Please give a date of birth.")
	// @Temporal(TemporalType.TIMESTAMP)
	// private Date birthday;
	private String birthday;

	// @Column(name = "workat")
	// @NotNull
	// @NotBlank
	private String workat;

	// @NotBlank
	private String department;
//Whenever you create Parameterized constructor, make sure that u will also create default constructor because
//Hibernate internally uses properties to create our objects dynamically & it needs default constructor in JPA Entity.	
	/*
	 * public Employee() {
	 * 
	 * }
	 * 
	 * public Employee(@Size(min = 3, max = 50) String firstName, @Size(min = 2, max
	 * = 50) String lastName,
	 * 
	 * @NotBlank @Email String email, @NotBlank String gender, @NotBlank String
	 * marriage,
	 * 
	 * @NotNull(message = "Please give a date of birth.") Date birthday, @NotBlank
	 * String workat,
	 * 
	 * @NotBlank String department) { super(); this.firstName = firstName;
	 * this.lastName = lastName; this.email = email; this.gender = gender;
	 * this.marriage = marriage; this.birthday = birthday; this.workat = workat;
	 * this.department = department; }
	 */

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	/*
	 * public Date getBirthday() { return birthday; } public void setBirthday(Date
	 * birthday) { this.birthday = birthday; }
	 */

	public String getWorkat() {
		return workat;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setWorkat(String workat) {
		this.workat = workat;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

}
