package manas.muna.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.jvnet.hk2.annotations.Service;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Commit;

import manas.muna.entity.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Component
public class EmployeeService {
	
	private List<Employee> emps = new ArrayList<Employee>();
	
	@PostConstruct
	public void init() {
		System.out.println("hihi");
		emps.add(new Employee("aaa", 11, 100000.00));
		emps.add(new Employee("bbb", 12, 1000123.00));
	}

	public Flux<Employee> getAllEmp() {
		return Flux.fromIterable(emps);
	}
	

	public Mono<Employee> getById(int id) {
		Mono<Employee> e;
		try {
			e = Mono.justOrEmpty(emps.get(id));
		}catch(Exception ex) {
			e = Mono.justOrEmpty(null);
		}
		return e;
	}
	
}
