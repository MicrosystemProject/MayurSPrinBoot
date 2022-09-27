package code.microsystem.service;

import java.util.List;
import java.util.Optional;

import code.microsystem.entity.Employee;

public interface EmployeeService {

	public Employee addNewEMp(Employee employee);

	public List<Employee> getAllEmployee();

	public Optional<Employee> findById(int id);

	public Optional<Employee> findByName(String name);

	public Employee editEmp(int id, Employee employee);

	public void deleteEmp(Employee emp);

	public Optional<Employee> findByEmail(String femail);

}
