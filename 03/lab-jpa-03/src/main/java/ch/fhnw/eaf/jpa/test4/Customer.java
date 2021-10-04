package ch.fhnw.eaf.jpa.test4;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;

	@OneToMany
	private List<Order> orders = new ArrayList<>();

	protected Customer() {
	}

	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void addOrder(Order order) {
		orders.add(order);
	}

	@Override
	public String toString() {
		return String.format("%-10s [%d]", name, age);
	}

}
