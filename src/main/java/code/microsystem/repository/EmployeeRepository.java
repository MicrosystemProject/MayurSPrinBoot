
package code.microsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import code.microsystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	@Query("from Employee e where e.fname=:name")
	Optional<Employee> findByfname(String name);
	
	@Query("from Employee e where e.email=:femail")
	Optional<Employee> findByEmail(String femail);

}
