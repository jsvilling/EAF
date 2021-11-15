# Lektion 9: Transactions & Transaction Strategy
In dieser Lektion werden wir mit den *Transactions* eine konkrete Umsetzung von AOP im Spring Framework nutzen (siehe Abbildung 1). 

<img src="tx.png"/>

Abbildung 1: Implementation des Transaction-Supports mit Spring AOP

Wir werden
- Transactions
- Transaction Strategy

vertieft behandeln. Diese beiden Themen wurden bereits in der JPA Lektion kurz angesprochen.

Es geht in dieser Lektion um folgende Fragen:
- Wo sind sinnvolle Transaktionsgrenzen?
- Welche Möglichkeiten bietet Spring, um die Transaktion zu kontrollieren?
- Muss jede Operation in einer Transaktion laufen?
- Gibt es eine sinnvolle Transaktionsstrategie für Enterprise Applikationen?

## Arbeitsauftrag
Zur Vorbereitung und Erarbeitung der Theorie lesen sie sich in das aktuelle Thema ein, mit der  Einführung und den Folien:
- [druckbare Version](https://fhnw365.sharepoint.com/teams/eaf_M365/Freigegebene%20Dokumente/hs21/09/Transactions.pdf?CT=1636707225958&OR=ItemsView)
- [vertonte Version](https://fhnw365.sharepoint.com/teams/eaf_M365/Freigegebene%20Dokumente/hs21/09/Transactions-audio.mp4)

Die notwendigen Theorie-Grundlagen sind in den Slides abgedeckt.
Wichtig ist:
- *Transaction Strategy* verstehen, erklären und einsetzen können

Hier aber dennoch ein Link auf einen interessanten [Blog-Post](https://codete.com/blog/5-common-spring-transactional-pitfalls/).

Die Theorie vertiefen sie mit folgenden Arbeitsblättern:
- [Arbeitsblatt AB9.1](https://fhnw365.sharepoint.com/teams/eaf_M365/Freigegebene%20Dokumente/hs21/09/AB9.1.pdf?CT=1636707194117&OR=ItemsView)<br/>
  Mit diesem Arbeitsblatt sollen sie verschiedene Aspekte der Spring Transaktionen implementieren und erfahren, wie diese *Transaktionen* in einer Spring Enterprise Applikation funktionieren.

  Beachten sie, dass in diesem Arbeitsblatt nicht mit der `movierental.jpa` Applikation gearbeitet wird. In `ab9.1/initial` steht ihnen eine kleinere, einfachere Applikation mit entsprechenden Unit-Tests zur Verfügung. Wie mit diesen Tests werden soll, wird im Video `ab9.1-intro.mov` erklärt. Dieses Video finden sie im Ordner [solutions-hs20](https://teams.microsoft.com/_#/school/files/hs21?threadId=19%3Af6ad2749540a4162bc625a66e14bc9b9%40thread.tacv2&ctx=channel&context=solutions-hs20&rootfolder=%252Fteams%252Feaf_M365%252FFreigegebene%2520Dokumente%252Fhs21%252F09%252Fsolutions-hs20). Das Video stammt aus dem Herbstsemester 2020. Hier wurde das Arbeitsblatt noch unter dem Namen Arbeitsblatt 5 geführt. Das ist der einzige Unterschied gegenüber dem aktuellen Semester.

- [Arbeitsblatt AB9.2](https://fhnw365.sharepoint.com/teams/eaf_M365/Freigegebene%20Dokumente/hs21/09/AB9.2.pdf?CT=1636707209036&OR=ItemsView)<br/>
  Zum Abschluss sollen sie mit dieser Übung die Transaktionsstrategie aus den Slides, mit den Erfahrungen aus AB9.1, in der Enterprise Applikation `movierental.jpa` umsetzen.

  In `ab9.2/complete` werden sie eine Lösung für die Gesamtapplikation `movierental` finden. Hinweis: Stoppen sie die Server-Applikation im Docker, sonst werden sie einen Port-Konflikt auf Port `8080` haben.

**Hinweis**: Auf MS Teams finden sie zu den beiden Arbeitsblättern im Ordner [solutions-hs20](https://teams.microsoft.com/_#/school/files/hs21?threadId=19%3Af6ad2749540a4162bc625a66e14bc9b9%40thread.tacv2&ctx=channel&context=solutions-hs20&rootfolder=%252Fteams%252Feaf_M365%252FFreigegebene%2520Dokumente%252Fhs21%252F09%252Fsolutions-hs20) Videos aus dem Herbstsemester 2020, in welchen sie Erklärungen zu den Lösungen finden können. Im Gegensatz zum aktuellen Herbstsemester hat sich lediglich die Benennung der Arbeitsblätter geändert!

## Einführung
Um das Transaktionshandling in einer Spring Enterprise Applikation einzuführen, gibt es im Spring-Umfeld mehrere Möglichkeiten. Die meistverwendete Variante nutzt die Annotation `@Transactional`. Das Transaktionshandling basiert auf AOP.

**Reminder**: In JPA werden die Entitäten im `PersistenceContext` verwaltet. Die Manipulationen an diesen JPA-Entitäten müssen in einer Transaktion eingehüllt werden. Das betrifft alle "schreibenden" Methoden (persist, remove, merge, refresh, flush, refresh). 

Der deklarative Ansatz über die Annotation `@Transactional` macht das Transaktionshandling in Spring relativ einfach. Es genügt die entsprechende Methode mit dieser Annotation zu kennzeichnen und das Transaktionshandling wird automatisch durchgeführt, d.h. eine Transaktion wird beim Aufruf der Methode gestartet und beim Verlassen der Methode wird die Transaktion mit `commit` beendet - oder es wird ein `rollback` ausgelöst.

Voraussetzungen für das korrekte Verhalten sind:
1.	Die mit `@Transactional` annotierten Methoden müssen "public" sein.
2.	Das Transaction Management muss aktiviert sein. Dies wird mit der Annotatiopn `@EnableTransactionManagement` erreicht. Falls Spring Boot im CLASSPATH eine Abhängigkeit von `spring-data-*` oder `spring-tx` findet, wird das Transaction Management per Konvention aktiviert.
3. Die Aufruf muss von ausserhalb der Instanz (=Target) kommen (Hinweis AOP).

**Hinweis**: Obwohl `@Transactional` sowohl in Spring als auch in JavaEE (Package `javax.transaction`) vorhanden ist, werden wir die Annotation von Spring Framework verwenden. Es ist im Allgemeinen eine bessere Praxis, da es für Spring-Applikationen natürlicher ist und gleichzeitig mehr Optionen wie Timeout, Isolierung usw. bietet.