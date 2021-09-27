# Lektion 2: Jakarta Persistence API (JPA)
In dieser Woche werden wir einen ersten Blick auf das Jakarta Persistence API (JPA) werfen. 
JPA ist eine Schnittstelle für den Zugriff auf Datenbanken, welche das automatische Mapping
von Objekten auf Tabellen unterstützt (Object-Relational-Mapping, kurz ORM). Als Implementierung werden wir Hibernate verwenden, welches standardmässig in Spring Boot konfiguriert ist.


## Vorbereitung
Als Vorbereitung auf den Unterricht von Woche 02 empfehlen wir Ihnen folgende Schritte.

1. [Video 1](https://fhnw.zoom.us/rec/share/KPIy6oIdAHF75lHmP_Qf2Q2XZ4EDTwcQ8BVoZwKOhjmML2bxkMSLjl4c6GF8ILe8.C8kDwJ6FUt-M8yYa) als Einführung in Persistence Design Patterns
2. Starten Sie nach dem Anschauen des Videos die Applikation [movierental-memory](movierental-memory) und greifen Sie über ihren Browser auf die REST-Schnittstelle http://localhost:8080/movierental/movies zu.
3. Starten Sie danach auch das JavaFX-GUI in der Spring Boot Applikation [movierenatal-client](movierenatal-client) welche auf die REST-Schnittstelle zugreift.
4. [Video 2](https://fhnw.zoom.us/rec/share/i_awDwpAF-5GUiuvucWR6_4_gO-e_iKbqKMbBI64_J45jewa-yXSJ0tkaEMtMyqI.JLoOWzk8JgxoSWWL) gibt Ihnen eine Einführung in JPA.
5. Im Video habe ich ihnen das Beispiel [demo-jpa](demo-jpa) gezeigt das sie nun selber bei Ihnen starten können.
6. [Video 3](https://fhnw.zoom.us/rec/share/nMOm33odEj-XOV3J4rnthRIvNdAQ5NQcOtNIGIpsoI431UnLVsLc6jL_5P-O7PdF.D8R-8jvFYIFUlanV) erklärt die wichtigsten Annotationen mit denen die Entitäten definiert werden können.
7. [Video 4](https://fhnw.zoom.us/rec/share/nbDMrR9EmFshaZUvtkumjKJG_cfrGPnqdrmAaNwLg9MO3iuuukfJrXkdVvjgBKQI.0RhWJlfSsAdDDuzf) schlusendlich erklärt den Entity-Manager mit Entitäten gelesen und gespeichert werden können.


## Ressourcen
Folgende Unterlagen finden Sie im Repository:

- [JPA Spezifikation](https://gitlab.fhnw.ch/eaf/hs21/02/-/raw/master/resources/jakarta-persistence-spec-3.0.pdf)
- [Pro JPA 2 in Java EE8](https://gitlab.fhnw.ch/eaf/hs21/02/-/raw/master/resources/2018_Book_ProJPA2InJavaEE8.pdf?inline=false) Buch zu JPA 2.2 (englisch)
- [Entwicklung verteilter Anwendungen mit Spring Boot](https://gitlab.fhnw.ch/eaf/hs21/02/-/raw/master/resources/2019_Book_Golubski.pdf?inline=false) Buch zu Spring Boot (deutsch) das mir einen guten Eindruck macht.
- [Übung W02](https://gitlab.fhnw.ch/eaf/hs21/02/-/raw/master/assignment/Uebung02_Jpa.pdf) Übung zu JPA
- [Projekt movierental-client](movierental-client) MovieRental: JavaFX GUI
- [Projekt movierental-memory](movierental-memory) MovieRental: in-memory Backend
- [Configuring Spring Data JPA with Spring Boot](https://thorben-janssen.com/configuring-spring-data-jpa-with-spring-boot/)

<!--
## Recording
Von den ersten drei Lektionen steht eine [Zoom-Aufnahme](https://fhnw.zoom.us/rec/share/YMxO1YxcjeUKXuPd-FngVrT36mc3TouvMPUV7rpPvjrjIq1V8Bf8mzljS7q8C3c.whh2SlaIAtxGwTT2) zur Verfügung (Access Passcode: eaf@2021)
-->
