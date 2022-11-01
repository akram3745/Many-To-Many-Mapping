package com.techno.mapping.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techno.mapping.pojo.AddressPojo;
import com.techno.mapping.pojo.AuthorPojo;
import com.techno.mapping.pojo.CapabilityPojo;
import com.techno.mapping.pojo.EmployeePojo;
import com.techno.mapping.response.ResponseMessage;
import com.techno.mapping.service.EmployeeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService employeeService;

	@PostMapping("employee")
	public ResponseEntity<EmployeePojo> saveEmployee(@RequestBody EmployeePojo employeePojo) {
		return ResponseEntity.ok().body(employeeService.saveEmployee(employeePojo));
	}
	@PostMapping("copy-employee")
	public ResponseEntity<EmployeePojo> copyEmployee(@RequestParam("data") String data) throws IOException {
		return ResponseEntity.ok().body(employeeService.saveEmp(data));
	}
	@GetMapping("employee/{empId}")
	public ResponseEntity<EmployeePojo> getEmployee(@PathVariable long empId) {

		return ResponseEntity.ok().body(employeeService.getEmployee(empId));
	}

	@PutMapping("update-employee")
	public ResponseEntity<EmployeePojo> updateEmployee(@RequestBody EmployeePojo employeePojo) {
		return ResponseEntity.ok().body(employeeService.updateEmployee(employeePojo));
	}

	@PostMapping("employee-address")
	public ResponseEntity<ResponseMessage> saveEmpAddress(@RequestBody AddressPojo employeePojo) {
		return ResponseEntity.ok().body(
				new ResponseMessage(false, "Address save successfully", employeeService.saveEmpAddress(employeePojo)));
	}

	@PostMapping("copy-employee-address")
	public ResponseEntity<ResponseMessage> listAddress(@RequestBody List<AddressPojo> employeePojo) {
		return ResponseEntity.ok()
				.body(new ResponseMessage(false, "copy list successfully", employeeService.copyAddress(employeePojo)));
	}

	@GetMapping("employee-address/{addId}")
	public ResponseEntity<ResponseMessage> getEmployeeAddress(@PathVariable long addId) {

		return ResponseEntity.ok()
				.body(new ResponseMessage(false, "fetch successfully", employeeService.getEmpAddress(addId)));
	}

	@PutMapping("update-employee-address")
	public ResponseEntity<ResponseMessage> updateEmployeeAddress(@RequestBody AddressPojo employeePojo) {
		return ResponseEntity.ok().body(new ResponseMessage(false, "Address save successfully",
				employeeService.updateEmployeeAddress(employeePojo)));
	}

	@DeleteMapping("employee/{empId}")
	public ResponseEntity<ResponseMessage> deleteEmployee(@PathVariable long empId) {
		return ResponseEntity.ok().body(new ResponseMessage(false, employeeService.deleteEmployee(empId), null));
	}

	@DeleteMapping("employee-address/{addId}")
	public ResponseEntity<ResponseMessage> deleteEmployeeAddress(@PathVariable long addId) {
		return ResponseEntity.ok().body(new ResponseMessage(false, employeeService.deleteEmpAddress(addId), null));
	}

	@PostMapping("copy-author")
	public ResponseEntity<ResponseMessage> copyAuthor(@RequestBody AuthorPojo employeePojo) {
		return ResponseEntity.ok()
				.body(new ResponseMessage(false, "Author save successfully", employeeService.addAuhtor(employeePojo)));
	}

	@GetMapping("author/{addId}")
	public ResponseEntity<ResponseMessage> getAuthor(@PathVariable long addId) {

		return ResponseEntity.ok()
				.body(new ResponseMessage(false, "fetch successfully", employeeService.getAuthor(addId)));
	}

	@PostMapping("employee-capability")
	public ResponseEntity<ResponseMessage> savecapability(@RequestBody CapabilityPojo employeePojo) {
		return ResponseEntity.ok().body(new ResponseMessage(false, "capability save successfully",
				employeeService.saveEmpCapability(employeePojo)));
	}

	@GetMapping("employee-capability/{capId}")
	public ResponseEntity<ResponseMessage> getEmpCapability(@PathVariable long capId) {
		return ResponseEntity.ok()
				.body(new ResponseMessage(false, "fetch successfully", employeeService.getEmpCapability(capId)));
	}

	@PutMapping("employee-capability")
	public ResponseEntity<ResponseMessage> updatecapability(@RequestBody CapabilityPojo employeePojo) {
		return ResponseEntity.ok().body(new ResponseMessage(false, "capability updated successfully",
				employeeService.updateEmpCapability(employeePojo)));
	}

	@DeleteMapping("employee-capability/{capId}")
	public ResponseEntity<ResponseMessage> deleteEmployeeCapabilty(@PathVariable long capId) {
		return ResponseEntity.ok().body(new ResponseMessage(false, employeeService.deleteEmpCapability(capId), null));
	}

	@PostMapping("address-employee")
	public ResponseEntity<ResponseMessage> saveAddressEmployee(@RequestBody EmployeePojo employeePojo) {
		return ResponseEntity.ok()
				.body(new ResponseMessage(false, employeeService.addAddressEmpployee(employeePojo), null));
	}
	@DeleteMapping("book/{capId}")
	public ResponseEntity<ResponseMessage> deleteBook(@PathVariable long capId) {
		return ResponseEntity.ok().body(new ResponseMessage(false, employeeService.deleteBook(capId), null));
	}
	@DeleteMapping("author/{capId}")
	public ResponseEntity<ResponseMessage> deleteAuthor(@PathVariable long capId) {
		return ResponseEntity.ok().body(new ResponseMessage(false, employeeService.deleteAuthor(capId), null));
	}

}
