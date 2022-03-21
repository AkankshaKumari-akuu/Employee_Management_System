package com.employeeManagementSystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name="Employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	
	private int id;
	@Column(name="Name")
	private String name;
	
	@Column(name="DateOfJoining")
	private String dateOfJoining;
	
	@Column(name="BasicPay")
	private double basicpay;
	
	@Column(name="DA")

	private double da;
	@Column(name="HRA")

	private double hra;
	@Column(name="GROSS")

	private double gross;
	@Column(name="TAX")
	private double tax;
	@Column(name="NET")
	private double net;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	public double getBasicpay() {
		return basicpay;
	}
	public void setBasicpay(double basicpay) {
		this.basicpay = basicpay;
	}
	public double getDa() {
		return da;
	}
	public void setDa(double da) {
		this.da = da;
	}
	public double getHra() {
		return hra;
	}
	public void setHra(double hra) {
		this.hra = hra;
	}
	public double getGross() {
		return gross;
	}
	public void setGross(double gross) {
		this.gross = gross;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public double getNet() {
		return net;
	}
	public void setNet(double net) {
		this.net = net;
	}
	public Employee(String name, String dateOfJoining, double basicpay, double da, double hra, double gross,
			double tax, double net) {
		//this.id=id;
		super();
		this.name = name;
		this.dateOfJoining = dateOfJoining;
		this.basicpay = basicpay;
		this.da = da;
		this.hra = hra;
		this.gross = gross;
		this.tax = tax;
		this.net = net;
	}
	
	public Employee() {}
	public Employee(int id, String name, String dateOfJoining, double basicpay, double da, double hra, double gross,
			double tax, double net) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfJoining = dateOfJoining;
		this.basicpay = basicpay;
		this.da = da;
		this.hra = hra;
		this.gross = gross;
		this.tax = tax;
		this.net = net;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", dateOfJoining=" + dateOfJoining + ", basicpay=" + basicpay
				+ ", da=" + da + ", hra=" + hra + ", gross=" + gross + ", tax=" + tax + ", net=" + net + "]";
	}
	
	
}
