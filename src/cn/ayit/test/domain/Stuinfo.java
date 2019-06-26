package cn.ayit.test.domain;

/**
 * Stuinfo entity. @author MyEclipse Persistence Tools
 */
public class Stuinfo extends AbstractStuinfo implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Stuinfo() {
	}

	/** minimal constructor */
	public Stuinfo(Integer id) {
		super(id);
	}

	/** full constructor */
	public Stuinfo(Integer id, String name, String sex, Integer age) {
		super(id, name, sex, age);
	}

	@Override
	public String toString() {
		return "Stuinfo [getId()=" + getId() + ", getName()=" + getName()
				+ ", getSex()=" + getSex() + ", getAge()=" + getAge()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
