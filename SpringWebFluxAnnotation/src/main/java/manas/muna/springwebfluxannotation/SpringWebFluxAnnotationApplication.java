package manas.muna.springwebfluxannotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("manas.muna")
public class SpringWebFluxAnnotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebFluxAnnotationApplication.class, args);
	}

}

