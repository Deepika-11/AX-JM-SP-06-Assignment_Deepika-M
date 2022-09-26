package com.employemanagementsystem.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.employemanagementsystem.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepoTest {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private TestEntityManager testEntityManager;

	@BeforeEach

	void setUp(){
		Employee employee = new Employee(11,"Auto","KCE");
		employeeRepo.save(employee);
	}

	@Test
	@Rollback(value = false)
	public void testFindById(){
		Employee employee = employeeRepo.findById(11).get();
		assertEquals("KCE", employee.getEmployeeFirstName().toUpperCase());
	}


}
