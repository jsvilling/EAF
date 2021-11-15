# Lektion 8: AOP
In dieser Lektion wollen wir die Möglichkeiten kennenlernen *nicht-funktionale Anforderungen* als Komponenten zu implementieren und in die Enterprise Applikation einzubinden. Die *aspektorientierte Programmierung (AOP)* stellt uns dafür die geeigneten Ansatz bereit und *Spring AOP* eine geeignete Infrastruktur. In nicht-funktionale Anforderung wirdin diesem Kontext als Aspekt bezeichnet.

Es geht in dieser Lektion um folgende Fragen:
- Wie können Aspekte als Komponenten implementiert werden?
- Wo kann man einen Aspekt in den Programmablauf einbinden?
- Welche Möglichkeiten bietet Spring AOP?
- Wie setzt das Spring Framework AOP um?
- Wo sind die Grenzen von AOP bzw. von Spring AOP?
- Wie kann OOP und AOP kombiniert werden?



## Arbeitsauftrag
Zur Vorbereitung und Erarbeitung der Theorie lesen sie sich in das aktuelle Thema ein, mit der  Einführung und den Folien:

* [druckbare Version](https://fhnw365.sharepoint.com/teams/eaf_M365/Freigegebene%20Dokumente/hs21/08/AOP.pdf?CT=1635872260777&OR=ItemsView)
* [vertonte Version](https://fhnw365.sharepoint.com/teams/eaf_M365/Freigegebene%20Dokumente/hs21/08/AOP-audio.mp4)

Die Theorie vertiefen sie mit folgenden Arbeitsblättern:

* [Arbeitsblatt AB8.1](https://fhnw365.sharepoint.com/teams/eaf_M365/Freigegebene%20Dokumente/hs21/08/AB8.1.pdf?CT=1635845020865&OR=ItemsView)<br/>
  Mit diesem Arbeitsblatt üben sie die verschiedenen Möglichkeiten von Spring AOP: *Advice Type*, *Pointcut Expression*, *Access Input Parameter*, *Access Response* und *Using Annotations*. 
  Ausgangspunkt ist das Projekt im Order `ab8.1/initial/movierental.jpa`.

* [Arbeitsblatt AB8.2](https://fhnw365.sharepoint.com/teams/eaf_M365/Freigegebene%20Dokumente/hs21/08/AB8.2.pdf?CT=1635845048777&OR=ItemsView)<br/>
  In diesem Arbeitsblatt werden sie eine neue nicht-funktionale Anforderung mit AOP umsetzen. Das Ziel ist wie folgt:

  Sie wollen ihren Webservice "movierental" besser schützen. Deshalb muss jeder HTTP-Request ein Security Token enthalten. Sie legen fest, dass dieses Token im Request-Parameter *token* gesetzt werden muss, z.B. wie im folgenden Befehl:
  ```
  curl "localhost:8090/movierental/movies/1?token=xyz123"
  ```
  Das Token soll konfiguriert werden können.


## Einführung
Da AOP ein Kernkonzept des Spring Framework und im *Core* enthalten ist, findet man die relevanten Informationen in der entsprechenden [Spring Reference Documentation](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/index.html). Insbesonders das Kapitel [5. Aspect Oriented Programming with Spring](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#aop) beschreibt AOP und die Umsetzung in Spring detailliert.

Die Theorie-Grundlagen sind in den Slides abgedeckt. Wichtig sind:
- AOP Begriffe kennen und verstehen
- AOP vs. OOP erklären können
- Umsetzung von AOP in Spring erklären können: Proxy!


