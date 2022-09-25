package code.microsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import code.microsystem.entity.Employee;
import code.microsystem.service.EmployeeService;

@RestController
@RequestMapping("/api/v1")
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
	public Employee getEmpByFname(@RequestParam("fname") String name) {
		Optional<Employee> employee = employeeService.findByName(name);
		if (employee.isPresent()) {
			System.out.println(employee.get());
			
		}else {
			System.out.println("No employee found with name"+ name);
		}
		
		
		return employee.get();
		
	}
	
//	update Employee Details
	@PutMapping("/editEmployee/{id}")
	public ResponseEntity<Employee> ediEmployee(@PathVariable int id,@RequestBody Employee employee ){
		Employee employee2= employeeService.editEmp(id,employee);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(employee);
		
	}
	

}
