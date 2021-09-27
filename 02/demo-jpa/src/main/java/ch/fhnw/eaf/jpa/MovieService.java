package ch.fhnw.eaf.jpa;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class MovieService {
	
	@PersistenceContext
	private EntityManager em;

	public Long saveNewMovie(String title, LocalDate date) {
		Movie m = new Movie(title, date);
		em.persist(m);
		return m.getId();
	}

	public void rentMovie(Long id) {
		Movie m = em.find(Movie.class, id);
		m.setRented(true); // will be persisted at the end of the TX
	}

}
