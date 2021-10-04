package ch.fhnw.eaf.jpa.test5;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EntityScan(basePackageClasses = Test5.class)
public class Test5 implements CommandLineRunner {

	@PersistenceContext
	EntityManager em;

	public static void main(String[] args) {
		new SpringApplicationBuilder(Test5.class).run(args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		Customer c = em.find(Customer.class, 1);

		c.setAge(55);
		c.getAddress().setStreet("Bahnhofstrasse 5");

		long start = System.currentTimeMillis();
		for (int i = 0; i < 1_000_000; i++) {
			c.getAddress().getStreet();
		}
		System.out.println(System.currentTimeMillis() - start);

		System.out.println("done");
		System.exit(0);
	}
}
