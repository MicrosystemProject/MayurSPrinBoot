package code.microsystem;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import code.microsystem.entity.Employee;
import code.microsystem.repository.EmployeeRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class SpringBootEmployeeCrudApllicationApplicationTests {
	
	@MockBean
	EmployeeRepository employeeRepository;
	
	@Test
	public void testaddNewEMp(Employee employee) {
	Employee actual=new Employee(101, "Mayur", "mayur@gmail.com", "1234");
	
	Employee found=employeeRepository.save(actual);
	assertEquals(actual.getId(), found.getId());	
	}

}
