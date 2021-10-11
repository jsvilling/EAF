# Woche 4: JPA: Vererbung und JPQL
In dieser Woche werden wir unser Wissen zum Jakarta Persistence API (JPA) vertiefen und uns auf die beiden Themen
- Abbildung von Vererbungsbeziehungend
- JPQL

fokussieren.


## Vorbereitung
Als Vorbereitung auf den Unterricht von Woche 04 empfehlen wir Ihnen folgende Schritte.

1.  [Video 1: Inheritance](https://fhnw.zoom.us/rec/share/7IpdTY75JwNVRAide-34-4LNgdRWTVLWqD0E9igHUJV8k6v54RsBYsoHuSFZdY3f.K1s6Yle_sg9y_7fB) (33 Min)
    erklärt, wie Vererbungsbeziehungen auf Datenbanktabellen abgebildet werden können.
    Wir werden dieses Thema dann am Montag an Hand eines Beispiels vertiefen.

2.  [Video 2: JPQL](https://fhnw.zoom.us/rec/share/HxBGtxmCSrUZdtmUw_sdLiWAGf9UIrqgEGzu3OuJNrlq5-qFLKSaES96o0_zuQEX.yzQrhrEshQju6D8H) (34 Min)
    erklärt die Abfragesprache JPQL. Es gab dazu ja bereits einige Fragen, insbesondere was denn der Unerschied zu SQL ist.
    Auch dieses Thema werden wir am Montag in einem kleinen Beispiel anwenden und damit festigen.

3.  [Video 3: Joins](https://fhnw.zoom.us/rec/share/Gb2Gt42VNQ9HjgRudecOTtKP3ZZ-1L1_M3t85ugtTh7cseXSi2lO6GeTd3A0eKNc.5mMqq1g91uEbr5Cu) (28 Min)
    erklärt wie man JOINs in JPQL Queries definieren kann um über `OneToMany` oder `ManyToMany`-Assoziationen hinweg zu navigieren.

4.  Im Video 3 werden zwei Codebeispiele gezeigt, die Sie gerne wiederholen können. Das Projekt das ich verwendet habe steht als Projekt
    [lab-jpa-jpql](lab-jpa-jpql) zur Verfügung. Für das Beispiel mit den Inner- und Outer-Joins habe ich folgende Methode verwendet (die
    aus der `run`-Methode aufgerufen werden kann):
    
    ```java
        private void testJoin() {
            Query q = em.createQuery("SELECT u.lastName, r FROM User u      JOIN u.rentals r");
        //  Query q = em.createQuery("SELECT u.lastName, r FROM User u LEFT JOIN u.rentals r");
            List<?> result = q.getResultList();
            for (Object x : result) {
                Object[] res = (Object[]) x;
                String name = (String) res[0];
                Rental r = (Rental) res[1];
                System.out.println(name + ": " + (r == null ? null : r.getMovie().getTitle()));
            }
        }
    ```
    
    Um das Fetch-Join zu demonstrieren habe ich folgende Methode verwendet: 
    
    ```java
        private void testFetchJoin() {
            TypedQuery<User> q = em.createQuery("SELECT u          FROM User u", User.class);
        //  TypedQuery<User> q = em.createQuery("SELECT u          FROM User u LEFT JOIN FETCH u.rentals", User.class);
        //  TypedQuery<User> q = em.createQuery("SELECT u          FROM User u      JOIN FETCH u.rentals", User.class);
        //  TypedQuery<User> q = em.createQuery("SELECT DISTINCT u FROM User u      JOIN FETCH u.rentals", User.class);
        //  TypedQuery<User> q = em.createQuery("SELECT u FROM User u LEFT JOIN FETCH u.rentals r LEFT JOIN FETCH r.movie", User.class);
            List<User> result = q.getResultList();
            for (User u : result) {
                System.out.printf("%s: has %d rentals%n", u.getLastName(), u.getRentals().size());
            }
        }
    ```

5.  [Video 4: Criteria API](https://fhnw.zoom.us/rec/share/LbYKdwrKfNLCj72zHZSBFpnZt0HOpQZCG6crIccduz9SmEeF1Qyh2G33TQXodfZ8.Qx_5MHt_WMkcog7z) (15 Min)
    erklärt das Criteria-API das von JPA angeboten wird. Über dieses API können Queries im Code formuliert werden.
    Die dazu nötige Metainformation über das Modell kann generiert werden.



## Ressourcen
Folgende Unterlagen finden Sie im Repository:

- [Folien](https://gitlab.fhnw.ch/eaf/hs21/04/-/raw/master/resources/JPA3_Slides-Inheritance-JPQL.pdf) zu den Videos.
- [JPQL Specification](https://jakarta.ee/specifications/persistence/3.0/jakarta-persistence-spec-3.0.html#a4665) 
  JPQL ist im Kapitel 4 der JPA Specification definiert.
- [Arbeitsblatt Inheritance](https://gitlab.fhnw.ch/eaf/hs21/04/-/raw/master/resources/JPA3_AB_Inheritance.pdf) um das Thema Inheritance zu vertiefen.
- [Arbeitsblatt JPQL](https://gitlab.fhnw.ch/eaf/hs21/04/-/raw/master/resources/JPA3_AB_JPQL.pdf) um das Thema JPQL Joins zu vertiefen.
- [Übung W04](https://gitlab.fhnw.ch/eaf/hs21/04/-/raw/master/assignment/Uebung04_Jpa.pdf) Übung Woche 04 zu JPA


<!--
## Recording
Von den drei Lektionen in Woche 04 steht eine [Zoom-Aufnahme](https://fhnw.zoom.us/rec/share/ptGaYeQzrQo9nPSkqh320P6wCfVTnb4HnPDe9A4RuxqOgbPH9_vHYMeHoymzHA.fGI2M8XbjK_4YM7-) zur Verfügung (Access Passcode: eaf@2021)
-->
