# Woche 3: JPA: Assoziationen
In dieser Woche werden wir unser Wissen zum Jakarta Persistence API (JPA) vertiefen und uns auf die beiden Themen
- Entity Manager (PersistenceContext)
- Assoziationen

fokussieren.


## Vorbereitung
Als Vorbereitung auf den Unterricht von Woche 03 empfehlen wir Ihnen folgende Schritte.

1. [Video 1: EntityManager](https://fhnw.zoom.us/rec/share/oeeQVm9AhFSrKAxsB0lVq2dkjqjgW_0vkIOTfnabLNjGeKnu6uxmXif38J4D5T6y.rg2VmrJon0pcop_-) (32 Min) erklärt nochmals die Funktionsweise des Persistenzkontexts der über den EntityManager zugegriffen werden kann.

2. Im Video 1 werden Codebeispiele gezeigt, die Sie gerne wiederholen können. Ich habe dazu im Projekt `movierental-jpa` folgende Ergänzungen vorgenommen:
   
    - Implementierung einer Methode `toString` in der Klasse `User`:
   
        ```java
        public String toString() {
       	    return String.format("User(%d, %s, %s) [%d]", 
                 id, firstName, lastName,
                 System.identityHashCode(this));
        }
        ```

    - Deklaration einer Instanz vom Typ `EntityManager`:
    
   	    ```java
           @PersistenceContext
	       EntityManager em;
        ```

    - Implementierung des Interfaces `CommandLineRunner` in der Klasse `MovieRentalServer` und folgender `run`-Methode:
 
   	    ```java
    		//@Transactional // mit und ohne @Transactional Annotation
        	@Override
        	public void run(String... args) {
        		User u = em.find(User.class, 1L);
        		System.out.println(u.getFirstName());
        		System.out.println(u.getLastName());
        		System.out.println(em.contains(u));
        		System.out.println(u.getRentals().size());
        		System.out.println("done");
        	}
        ```

    - Implementierung des Interfaces `CommandLineRunner` in der Klasse `MovieRentalServer` und folgender `run`-Methode:
 
   	    ```java
        	@Override
        	@Transactional
        	public void run(String... args) {
        		User u1 = em.find(User.class, 1L);
        		System.out.println("u1=" + u1);
        		User u2 = new User("Dominik", "Gruntz");
        		u2.setId(u1.getId());
        		System.out.println("u2=" + u2);
        		System.out.println("em.merge(u2):");
        		User u3 = em.merge(u2);
        		System.out.println("u1=" + u1);
        		System.out.println("u2=" + u2);
        		System.out.println("u3=" + u3);
        		System.out.println("em.refresh(u1):");
        		em.refresh(u1);
        		System.out.println("u1=" + u1);
        		System.out.println("u2=" + u2);
        		System.out.println("u3=" + u3);
        	}
        ```

3. [Video 2: Assoziationen](https://fhnw.zoom.us/rec/share/C0R1PfEzoWzmBark3LXKBCGPDnAdOqixpgvsFredAU0z4Lj_aPi0Kuv1ZJIOgRcz.LpXAtWu6Iw7JY5ng) (50 Min) erklärt welche Attribute auf den Assoziationen angebracht werden können.

4. Ich habe im Video 2 an Position 35:30 erwähnt, dass _ein_ SQL-Statement ausgeführt wird wenn alle Assoziationen EAGER definiert werden. Dieses Statement sieht wie folgt aus:

    ```sql
    select u.user_id, u.user_email, u.user_firstname, u.user_name, 
        r.user_id, r.rental_id, r.movie_id, r.rental_rentaldate, r.rental_rentaldays, r.user_id,
        m.movie_id, m.pricecategory_fk, m.movie_releasedate, m.movie_rented, m.movie_title, 
        pc.pricecategory_id, pc.pricecategory_type 
    from users u 
        left outer join rentals r on u.user_id=r.user_id
        left outer join movies m on r.movie_id=m.movie_id
        left outer join pricecategories pc on m.pricecategory_fk=pc.pricecategory_id
    where u.user_id=?
    ```

5. Ich habe ihnen letzte Woche noch das Buch von [Wolfgang Golubski](https://gitlab.fhnw.ch/eaf/hs21/02/-/raw/master/resources/2019_Book_Golubski.pdf?inline=false) verteilt. Die Themen von dieser Woche sind in den Unterkapiteln 6.3 und 6.4 beschrieben.


## Ressourcen
Folgende Unterlagen finden Sie im Repository:

- [Folien](https://gitlab.fhnw.ch/eaf/hs21/03/-/raw/master/resources/JPA2_Slides.pdf) zu den beiden Videos.
- [Samples](https://gitlab.fhnw.ch/eaf/hs21/03/-/raw/master/resources/JPA2_Samples.pdf) Beispiele zu Assoziationen (1:1, 1:n, n:n)
- [Arbeitsblatt](https://gitlab.fhnw.ch/eaf/hs21/03/-/raw/master/resources/JPA2_Arbeitsblatt.pdf) um Themen rund um JPA zu vertiefen.
- [Übung W03](https://gitlab.fhnw.ch/eaf/hs21/03/-/raw/master/assignment/Uebung03_Jpa.pdf) Übung Woche 03 zu JPA



<!--
## Recording
Von den ersten drei Lektionen steht eine [Zoom-Aufnahme](https://fhnw.zoom.us/rec/share/YMxO1YxcjeUKXuPd-FngVrT36mc3TouvMPUV7rpPvjrjIq1V8Bf8mzljS7q8C3c.whh2SlaIAtxGwTT2) zur Verfügung (Access Passcode: eaf@2021)
-->
