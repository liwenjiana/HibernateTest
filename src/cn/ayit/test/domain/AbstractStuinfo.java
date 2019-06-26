package cn.ayit.test.domain;

/**
 * AbstractStuinfo entity provides the base persistence definition of the
 * Stuinfo entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStuinfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String sex;
	private Integer age;

	// Constructors

	/** default constructor */
	public AbstractStuinfo() {
	}

	/** minimal constructor */
	public AbstractStuinfo(Integer id) {
		this.id = id;
	}

	/** full constructor */
	public AbstractStuinfo(Integer id, String name, String sex, Integer age) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.age = age;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}