package com.techno.mapping.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PreRemove;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(value = Include.NON_DEFAULT)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeId;
	private String employeeName;
	private String mobileNo;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime startDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime endDate;

	@JsonManagedReference
	@ManyToMany
	@JoinTable(name = "employee_address", joinColumns = @JoinColumn(referencedColumnName = "employeeId", name = "employeeId"), inverseJoinColumns = @JoinColumn(referencedColumnName = "addressId", name = "addressId"))
	private List<Address> address;

	@JsonManagedReference
	@ManyToMany
	@JoinTable(name = "employee_capability", joinColumns = @JoinColumn(referencedColumnName = "employeeId", name = "employeeId"), inverseJoinColumns = @JoinColumn(referencedColumnName = "capId", name = "capId"))
	private List<Capability> capabilities;

	@PreRemove
	public void removeAddress() {
		this.address.stream().map(add -> {
			add.setEmployee(add.getEmployee().stream().filter(emp -> emp.getEmployeeId() != this.employeeId).toList());
			return add;
		}).toList();
		this.capabilities.stream().map(cap -> {
			cap.setCapabilities(
					cap.getEmployee().stream().filter(capa -> capa.getEmployeeId() != this.employeeId).toList());
			return cap;
		}).toList();
	}

//	@Override
//	public String toString() {
//		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", mobileNo=" + mobileNo
//				+ ", category=" + category + "]";
//	}
	
	

}
