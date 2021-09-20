package ch.fhnw.eaf.springioc;

import ch.fhnw.eaf.springioc.api.MessageRenderer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringIocApplication implements CommandLineRunner {

    @Autowired
    MessageRenderer messageRenderer;

	public static void main(String[] args) {
		SpringApplication.run(SpringIocApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        messageRenderer.render();
    }
}
