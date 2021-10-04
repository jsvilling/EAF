package ch.fhnw.eaf.jpa.test4;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
@EntityScan(basePackageClasses = Test4.class)
public class Test4 implements CommandLineRunner {

	@PersistenceContext
	EntityManager em;

	public static void main(String[] args) {
		new SpringApplicationBuilder(Test4.class).run(args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Customer c1 = new Customer("Haller", 52);
		Customer c2 = new Customer("Schneider", 66);

		Order o1 = new Order("UE Wonderboom 2", 1);
		Order o2 = new Order("Lenco EPB-015", 1);
		Order o3 = new Order("Google Pixel 5", 1);

		c1.addOrder(o1);
		c1.addOrder(o2);

//		c2.addOrder(o1);
		c2.addOrder(o3);

		em.persist(c1);
		em.persist(c2);
		em.persist(o1);
		em.persist(o2);
		em.persist(o3);

		System.out.println("done");
	}

}
