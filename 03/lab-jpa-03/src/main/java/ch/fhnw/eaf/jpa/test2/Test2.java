package ch.fhnw.eaf.jpa.test2;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EntityScan(basePackageClasses = Test2.class)
public class Test2 implements CommandLineRunner {

	@PersistenceContext
	EntityManager em;

	public static void main(String[] args) {
		new SpringApplicationBuilder(Test2.class).run(args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Customer c2 = em.find(Customer.class, 2);
		Address a1 = em.find(Address.class, 1);
		a1.setCustomer(c2);

		System.out.println(">> inspect now the generated schema using the h2 console");
	}
}
