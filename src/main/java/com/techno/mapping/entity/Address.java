package com.techno.mapping.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PreRemove;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_DEFAULT)
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long addressId;
	private String empAddress;

	@ManyToMany(mappedBy = "address")
	@JsonBackReference
	private List<Employee> employee;

	@PreRemove
	public void name() {

		this.employee.stream().map(emp -> {
			emp.setAddress(emp.getAddress().stream().filter(add -> add.getAddressId() != this.addressId).toList());
			return emp;
		}).toList();

	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", empAddress=" + empAddress + "]";
	}

}
