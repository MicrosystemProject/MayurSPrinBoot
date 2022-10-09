package code.microsystem.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import code.microsystem.entity.Employee;
import code.microsystem.exception.ResourceNotFoundException;
import code.microsystem.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Employee SErvice",description = "Service for Employee")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addNewEmployee(@RequestBody Employee employee){
		Employee employee2=employeeService.addNewEMp(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
		
	}
	@GetMapping("/getEmployee")
	public List<Employee> getAllEmployee(){
		List<Employee> emplist=employeeService.getAllEmployee();
		return emplist;
		
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmpById(@PathVariable int id) {
		Optional<Employee> employee=employeeService.findById(id);
		if (employee.isPresent()) {
			System.out.println(employee.get());
			
		}else {
			System.out.println("No employee found with id"+id);
		}
		
		return employee.get();
		
	}
	
	
	@GetMapping("/getEmployeeByName")
	public Employee getEmpByFname1(@RequestParam("fname") String name) {
		Optional<Employee> employee = employeeService.findByName(name);
		if (employee.isPresent()) {
			System.out.println(employee.get());
			
		}else {
			System.out.println("No employee found with name"+ name);
		}
		
		
		return employee.get();
		
	}
	
	@GetMapping("/getEmployeeByEmail")
	public Employee getEmpByFemail(@RequestParam("email") String femail) {
		Optional<Employee> employee = employeeService.findByEmail(femail);
		if (employee.isPresent()) {
			System.out.println(employee.get());
			
		}else {
			System.out.println("No employee found with email"+ femail);
		}
		
		
		return employee.get();
		
	}
	
	@GetMapping("/getEmployeeByName&Email")
	public Employee getEmpByNameAndemail(@RequestParam("fname")String name, @RequestParam("email")String femail) {
		Optional<Employee> employee=employeeService.findByNameAndEmail(name,femail);
		if (employee.isPresent()) {
			System.out.println(employee.get());
			
		}else {
			System.out.println("No employee found with name"+ name);
			System.out.println("No employee found with email"+ femail);
			
		}
		return employee.get();
		
	}

	
//	update Employee Details
	@PutMapping("/editEmployee/{id}")
	public ResponseEntity<Employee> ediEmployee(@PathVariable int id,@RequestBody Employee employee ){
		Employee employee2= employeeService.editEmp(id,employee);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
		
	}
	
	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int id){
		Map<String, Boolean> response=new HashMap<>();
		
		Employee emp=employeeService.findById(id)
				.orElseThrow(()->new ResourceNotFoundException("Employee doenot exits"+id));
		
		employeeService.deleteEmp(emp);
		response.put("Record is deleted", true);
				
				
				
		return ResponseEntity.ok(response);
		
	}
	

}
