package ch.fhnw.eaf.jpa.test1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EntityScan(basePackageClasses = Test1.class)
public class Test1 implements CommandLineRunner {

	@PersistenceUnit
	EntityManagerFactory emf;

	public static void main(String[] args) {
		new SpringApplicationBuilder(Test1.class).run(args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		EntityManager em = emf.createEntityManager();

		Customer c1 = em.find(Customer.class, 1);
		Customer c2 = em.find(Customer.class, 1);

		System.out.println(c1);
		System.out.println(c2);

		System.out.println(c1 == c2);

		em.close();
		System.out.println("done");
		System.exit(0);
	}
}
