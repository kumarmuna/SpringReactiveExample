package manas.muna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import manas.muna.entity.Employee;
import manas.muna.service.EmployeeService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/allEmp")
	public Flux<Employee> getAll() {
		return employeeService.getAllEmp();
	}
	
	
	@GetMapping("/{id}")
	public Mono<Employee> getById(@PathVariable String id) {
		System.out.println(id);
		return employeeService.getById(Integer.parseInt(id));
	}
	
}
