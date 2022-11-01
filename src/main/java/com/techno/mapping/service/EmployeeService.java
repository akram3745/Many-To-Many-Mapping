package com.techno.mapping.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.techno.mapping.entity.Address;
import com.techno.mapping.entity.Author;
import com.techno.mapping.entity.Capability;
import com.techno.mapping.entity.Employee;
import com.techno.mapping.exception.EmployeeNotFound;
import com.techno.mapping.pojo.AddressPojo;
import com.techno.mapping.pojo.AuthorPojo;
import com.techno.mapping.pojo.CapabilityPojo;
import com.techno.mapping.pojo.EmployeePojo;
import com.techno.mapping.repo.AddressRepo;
import com.techno.mapping.repo.AuthorRepo;
import com.techno.mapping.repo.BookRepo;
import com.techno.mapping.repo.CapabilityRepo;
import com.techno.mapping.repo.EmployeeRepo;
import com.techno.mapping.util.BeanCopy;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {
	
	private static ObjectMapper mapper = new ObjectMapper();
	
	static {
		mapper.registerModule(new JavaTimeModule());
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	}

	private final EmployeeRepo employeeRepo;
	private final AddressRepo addressRepo;
	private final CapabilityRepo capabilityRepo;
	private final AuthorRepo authorRepo;
	private final BookRepo bookRepo;

	public EmployeePojo saveEmployee(EmployeePojo employeePojo) {
		return BeanCopy.objectProperties(employeeRepo.save(BeanCopy.objectProperties(employeePojo, Employee.class)),
				EmployeePojo.class);

	}
	public EmployeePojo saveEmp(String employeePojo) throws IOException {
//		EmployeePojo readValue = mapper.readValue(employeePojo, EmployeePojo.class);
//		System.out.println("readValue "+readValue);
//		System.out.println("LocalDateTime.now() "+LocalDateTime.now());
//		System.out.println("employeePojo "+employeePojo);
//		Employee jsonProperties = BeanCopy.jsonProperties(employeePojo, Employee.class);
//		System.out.println("jsonProperties "+jsonProperties);
		System.out.println(employeePojo);
		Employee objectProperties = BeanCopy.jsonProperties(employeePojo, Employee.class);
		EmployeePojo EmployeePojo = BeanCopy.jsonProperties(employeePojo, EmployeePojo.class);
		System.out.println("objectProperties "+objectProperties);
		System.out.println("objectProperties "+EmployeePojo);
//		return BeanCopy.objectProperties(employeeRepo.save(),
//				EmployeePojo.class);
		return null;

	}


	public EmployeePojo getEmployee(long empId) {
		return BeanCopy.objectProperties(
				employeeRepo.findById(empId).orElseThrow(() -> new EmployeeNotFound("Invalid id")), EmployeePojo.class);

	}

	public EmployeePojo updateEmployee(EmployeePojo employeePojo) {
		employeeRepo.findById(employeePojo.getEmployeeId()).orElseThrow(() -> new EmployeeNotFound("Invalid id"));
		return BeanCopy.objectProperties(employeeRepo.save(BeanCopy.objectProperties(employeePojo, Employee.class)),
				EmployeePojo.class);

	}

	public String deleteEmployee(long empId) {
		employeeRepo.deleteById(empId);
		return "Employee Deleted Successfully";

	}

	public EmployeePojo saveEmpAddress(AddressPojo addressPojo) {
		List<Employee> employees = new ArrayList<>();
		Employee employee = employeeRepo.findById(addressPojo.getEmpId())
				.orElseThrow(() -> new EmployeeNotFound("Invalid id"));
		Address address = BeanCopy.objectProperties(addressPojo, Address.class);
		employees.add(employee);
		employee.getAddress().add(address);
		address.setEmployee(employees);

		addressRepo.save(address);

		return BeanCopy.objectProperties(employee, EmployeePojo.class);
	}

	public List<Address> copyAddress(List<AddressPojo> addresses) {
		return BeanCopy.objectProperties(addresses, new TypeReference<List<Address>>() {
		});
	}

	public AddressPojo getEmpAddress(long addId) {
		Address address = addressRepo.findById(addId).orElseThrow(() -> new EmployeeNotFound("Invalid id"));
		List<Employee> list = address.getEmployee().stream().map(emp -> {
			emp.setAddress(null);
			emp.setCapabilities(null);
			return emp;
		}).toList();

		List<EmployeePojo> objectProperties = BeanCopy.objectProperties(list, new TypeReference<List<EmployeePojo>>() {
		});
		AddressPojo addressPojo = BeanCopy.objectProperties(address, AddressPojo.class);
		addressPojo.setEmployee(objectProperties);
		return addressPojo;

	}

	public AddressPojo updateEmployeeAddress(AddressPojo addressPojo) {
		addressPojo.setAddressId(addressRepo.findById(addressPojo.getAddressId())
				.orElseThrow(() -> new EmployeeNotFound("Invalid id")).getAddressId());
		return BeanCopy.objectProperties(addressRepo.save(BeanCopy.objectProperties(addressPojo, Address.class)),
				AddressPojo.class);

	}

	public String deleteEmpAddress(long addId) {
		Address address = addressRepo.findById(addId).get();
		System.out.println(address);
		addressRepo.delete(addressRepo.findById(addId).orElseThrow(() -> new EmployeeNotFound("Invalid id")));

		return " Address deleted successfully";

	}

	public EmployeePojo saveEmpCapability(CapabilityPojo capabilityPojo) {
		List<Employee> employees = new ArrayList<>();
		Employee employee = employeeRepo.findById(capabilityPojo.getEmpId())
				.orElseThrow(() -> new EmployeeNotFound("Invalid id"));
		Capability capability = BeanCopy.objectProperties(capabilityPojo, Capability.class);
		employees.add(employee);
		employee.getCapabilities().add(capability);
		capability.setEmployee(employees);

		capabilityRepo.save(capability);

		return BeanCopy.objectProperties(employee, EmployeePojo.class);

	}

	public CapabilityPojo getEmpCapability(long capId) {
		Capability capability = capabilityRepo.findById(capId).orElseThrow(() -> new EmployeeNotFound("Invalid id"));
		List<Employee> collect = capability.getEmployee().stream().map(cap -> {
			cap.setAddress(null);
			cap.setCapabilities(null);
			return cap;
		}).toList();
		List<EmployeePojo> objectProperties2 = BeanCopy.objectProperties(collect,
				new TypeReference<List<EmployeePojo>>() {
				});
		CapabilityPojo objectProperties = BeanCopy.objectProperties(capability, CapabilityPojo.class);
		objectProperties.setEmployee(objectProperties2);
		return objectProperties;

	}

	public CapabilityPojo updateEmpCapability(CapabilityPojo capabilityPojo) {
		Capability capability = capabilityRepo.findById(capabilityPojo.getCapId())
				.orElseThrow(() -> new EmployeeNotFound("Invalid id"));
		capabilityPojo.setCapId(capability.getCapId());

		return BeanCopy.objectProperties(
				capabilityRepo.save(BeanCopy.objectProperties(capabilityPojo, Capability.class)), CapabilityPojo.class);

	}

	public String deleteEmpCapability(long capId) {

		capabilityRepo.delete(capabilityRepo.findById(capId).orElseThrow(() -> new EmployeeNotFound("Invalid id")));

		return " Capability deleted successfully";

	}

	public AuthorPojo addAuhtor(AuthorPojo author) {
		return BeanCopy.objectProperties(authorRepo.save(BeanCopy.objectProperties(author, Author.class)),
				AuthorPojo.class);

	}

	public AuthorPojo getAuthor(long auId) {
		return BeanCopy.objectProperties(
				authorRepo.findById(auId).orElseThrow(() -> new EmployeeNotFound("Invalid id")), AuthorPojo.class);
	}

	public String addAddressEmpployee(EmployeePojo employeePojo) {
		List<Address> addresses = new ArrayList<>();
		Address address = addressRepo.findById(employeePojo.getEmployeeId())
				.orElseThrow(() -> new EmployeeNotFound("Invalid id"));
		addresses.add(address);
		Employee objectProperties = BeanCopy.objectProperties(employeePojo, Employee.class);
		address.getEmployee().add(objectProperties);
		objectProperties.setAddress(addresses);
		employeeRepo.save(objectProperties);
		return "save successfully";

	}

	public String deleteBook(long capId) {
		bookRepo.deleteById(capId);

		return " book deleted successfully";

	}
	public String deleteAuthor(long capId) {
		authorRepo.deleteById(capId);

		return " Author deleted successfully";

	}

}
