package com.techno.mapping.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonInclude(value = Include.NON_DEFAULT)
public class Capability {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long capId;
	@Convert(converter = JpaConverterJson.class)
	@Column(columnDefinition = "TEXT")
	private Object capabilities;
	@ManyToMany(mappedBy = "capabilities")
	@JsonBackReference
	private List<Employee> employee;

	@PreRemove
	public void name() {
		this.employee.stream().map(cap -> {
			cap.setCapabilities(cap.getCapabilities().stream().filter(capa -> capa.getCapId() != this.capId).toList());
			return cap;
		}).toList();
	}

	@Override
	public String toString() {
		return "Capability [capId=" + capId + ", capabilities=" + capabilities + "]";
	}

}
