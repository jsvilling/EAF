# Woche 5: JPA: Spring Repositories und DTOs
In dieser Woche werden wir uns die von Spring Boot bereitgestellten Spring Repositories anschauen und auch 
einen Blick auf Architekturfragen werfen.


## Vorbereitung
Als Vorbereitung auf den Unterricht von Woche 05 empfehlen wir Ihnen folgende Schritte:

1.  [Video 1: Spring Data JPA](https://fhnw.zoom.us/rec/share/Wx1xSuHw9IqCMcxDnLxp6rtkMXonGVe77NIa0im-HaisMVhqD1dIpkB3I0d_Uv-0.Ef2z-sLHcUXNBu-6) (54 Min)
    erklärt wie die Repositories von Spring Data erzeugt werden können.
	
	Auf Folie 21 (44:40) wird das Query
	```java
	      @Query("SELECT u FROM User u JOIN u.rentals r WHERE r.movie = :m")
	      List<User> query(@Param("m") Movie movie);

	```
	definiert. Da in unserer Applikation ein Film _höchstens_ an eine Person ausgeliehen werden kann könnte man diese Methode auch mit einem Resultat
	vom Typ `User` oder vom Typ `Optional<User>` definieren.
	
	Falls mit dieser Definition dann _kein_  Resultat zurückgelieft wird dann ist das Resultat entweder `null` oder das `Optional` ist leer.
	
	Falls mit so einem Resultatparameter _mehr_ als ein Resultat zurückgeliefert würde (kann in diesem speziellen Fall nicht passieren) dann würde eine `NonUniqueResultException` geworfen.


2.  [Video 2: Open Session In View](https://fhnw.zoom.us/rec/share/Y2UlabasTu7MX6Z3mMdcevQCToGxGFwsC7fCJd0nB7iV0-P_6CQmKZA8xEOb4MoR.zSyhFPpubsm4dpxs) (23 Min)
    geht nochmals auf das Thema Open Session In View (OSIV) ein und erklärt anhand des Movierental-Beispiels die Konsequenzen wenn OSIV aktiviert oder deaktiviert ist.

3.  [Video 3: DTOs](https://fhnw.zoom.us/rec/share/EGqxdu4F53mURPmV3qAmuqqImH3UhcPI-TU_dvxADb8sNU8SgIQwYiJvsislp6sg.S_oOu19zaYWgbKI0) (20 Min)
    geht auf das im letzten Video aufgeworfene Problem ein und stellt eine mögliche Lösung mit Data Transfer Objects (DTOs) vor.




## Ressourcen
Folgende Unterlagen finden Sie im Repository:

- [Folien](https://gitlab.fhnw.ch/eaf/hs21/05/-/raw/master/resources/01_JPA4_Slides.pdf) zu den Videos.
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Data JPA: Reference Documentation](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation)
  Query Definition mit Spring Data JPA
- [Folien](https://gitlab.fhnw.ch/eaf/hs21/05/-/raw/master/assignment/Uebung_Loesungen.pdf) zur Übungsbesprechung
- [Folien](https://gitlab.fhnw.ch/eaf/hs21/04/-/raw/master/resources/JPA2_Arbeitsblatt_Besprechung.pdf)
  zur Besprechung des Arbeitsblattes JPA
- [Arbeitsblatt Pollack](https://gitlab.fhnw.ch/eaf/hs21/05/-/raw/master/resources/02_AB_JPA-Pollack.pdf)
  um das Thema Assoziationsannotationen und Spring-Data repositories zu vertiefen.
- [Arbeitsblatt Mapstruct](https://gitlab.fhnw.ch/eaf/hs21/05/-/raw/master/resources/03_AB_Mapper.pdf)
  um das Thema Mapping zwischen Entitäten und DTOs zu vertiefen.
- [Übung W05](https://gitlab.fhnw.ch/eaf/hs21/05/-/raw/master/assignment/Uebung05_Facade.pdf) Übung Woche 05 zu JPA


<!--
## Recording
Von den drei Lektionen in Woche 04 steht eine [Zoom-Aufnahme](https://fhnw.zoom.us/rec/share/htd8GT7aS1GFk_Rilrplul20rkD7vyUyUP4Wgv_qs6yPeqnG2gFYuuW0XbcsN49D.aR-NMBoJ6TEoTe8_) zur Verfügung (Access Passcode: eaf@2021). Leider fehlt der erste Teil der Besprechung des JPA Arbeitsblattes.
-->