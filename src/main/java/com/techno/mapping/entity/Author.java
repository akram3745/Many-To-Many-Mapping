package com.techno.mapping.entity;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

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
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long auId;
	private String auNmae;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "autherId")
	private List<Book> book;
	
	@PreRemove
	public void name() {
		this.book=Collections.emptyList();
	}

}
