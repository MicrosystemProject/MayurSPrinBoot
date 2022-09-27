package code.microsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import code.microsystem.entity.Employee;
import code.microsystem.exception.ResourceNotFoundException;
import code.microsystem.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee addNewEMp(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployee() {

		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findById(int id) {

		return employeeRepository.findById(id);
	}

	@Override
	public Optional<Employee> findByName(String name) {

		return employeeRepository.findByfname(name);
	}

	@Override
	public Employee editEmp(int id, Employee employee) {
		Employee emp = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee doenot exits" + id));
		emp.setId(id);
		emp.setFname(employee.getFname());
		emp.setEmail(employee.getEmail());
		emp.setPassword(employee.getPassword());

		return employeeRepository.save(emp);
	}

	@Override
	public void deleteEmp(Employee emp) {
		employeeRepository.delete(emp);

	}

	@Override
	public Optional<Employee> findByEmail(String femail) {
		
		return employeeRepository.findByEmail(femail); 
	}

}
