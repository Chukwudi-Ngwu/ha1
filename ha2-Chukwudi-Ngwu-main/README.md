[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/jQ2dtj7q)
# Hausaufgabe Nr. 2

## Abgabe

Nehmen Sie das Assignment auf Github Classroom an und wählen Sie Ihren Namen aus der Liste aus.
Dadurch wird ein (dieses) Repository für Sie erstellt. 
Klonen Sie das Repo und pushen Sie Ihre Lösungen in mehreren sinnvoll zusammengefassten Commits (z.B. einer pro Teilaufgabe, es können aber auch gerne mehr sein).
Die Erstellung eines Pull Requests ist bei diesem Setup nicht notwendig.
Sie müssen Ihre Lösung bis zum 09. November um 23:59 Uhr gepusht haben, alle Tests müssen grün sein, und Sie müssen spätestens in der darauf folgenden von Ihnen belegten Übungsgruppe Ihre Lösung kurz demonstrieren.

## Aufgabenstellung

1. Betrachten Sie die Klasse `BurgerBuilder` im Paket `service`, das Interface `Burger` und die Klasse `DummyBurgerImpl` im Unterpaket `domain`, sowie den dazugehörigen Test `BurgerBuilderTest`, der das Soll-Verhalten dieser Klassen in Kombination spezifiziert. 
   Betrachten Sie außerdem die Klasse `Ingredient`, sowie die statische Klasse `Menu` im Paket `data`, die bereits eine Reihe von Zutaten definiert.
2. Erstellen Sie zwei Klassen `PrecomputedBurger` und `DynamicallyComputedBurger`, die jeweils das Interface `Burger` implementieren. 
   Beide Klassen sollen sich nach außen gleich verhalten. 
   Ein `PrecomputedBurger`-Objekt soll jedoch schon bei seiner Erstellung den fertig berechneten Gesamtpreis, die Gesamtkalorienzahl, sowie die Namen der Zutaten übergeben bekommen, während ein `DynamicallyComputedBurger`-Objekt bei seiner Erstellung nur eine Liste von `Ingredient`-Objekten übergeben bekommt und die jeweiligen Preis-, Kalorien- und Zutatenangaben erst zu dem Zeitpunkt berechnet, wenn die entsprechende Methode aufgerufen wird. 
   Erstellen Sie, wenn es Ihnen hilft, einfache neue Unit-Tests, die testen, ob Ihre Burger-Implementierungen so funktionieren, wie sie sollen.
3. Implementieren Sie nun in der `BurgerBuilder`-Klasse die drei Methoden `add`, `buildPrecomputed` und `buildDynamically` so, dass sie die jeweilige Burger-Implementierung nutzen (statt der `DummyBurgerImpl`), um die Testfälle im `BurgerBuilderTest` grün zu machen (ohne die Tests zu verändern!).
4. Erstellen Sie mindestens einen neuen Testfall, der beschreibt, dass ein Burger nur mit mindestens zwei Zutaten gebaut werden kann und ansonsten (also bei weniger als zwei Zutaten) eine `IllegalBurgerException` beim Aufruf der jeweiligen build-Methode geworfen wird.
5. Betrachten Sie die Klasse `SimpleInputParser` und extrahieren Sie daraus ein neues Interface namens `InputParser` und lassen dieses vom `SimpleInputParser` implementieren. Ändern Sie dann überall im Code, wo bisher der Typ `SimpleInputParser` in Variablendeklarationen verwendet wurde, die Deklaration so, dass stattdessen der Interface-Typ `InputParser` verwendet wird.

## Hinweise

- Allgemein: Sie können die Anwendung über die Klasse `BurgerBotApp` starten, um das aktuelle Verhalten des Gesamtprogramms auszuprobieren.
- Zu Teilaufgabe 2: Beachten Sie bei beiden Burger-Implementierungen die Grundsätze der Datenkapselung.
- Zu Teilaufgabe 3: Bedenken Sie, dass es einen Unterschied macht, ob Sie eine Referenz einer Liste übergeben oder eine Kopie einer Liste erstellen und diese übergeben.
- Zu Teilaufgabe 4: Die JUnit-Methode zum Prüfen, ob eine erwartete Exception geworfen wird, heißt `assertThrows` und wird mit der erwarteten Exception-Klasse (`ErwarteterTyp.class`) sowie einer Lambda-Funktion nach dem Schema `() -> AufrufInDemDieExceptionFliegenSoll` parametrisiert. 
