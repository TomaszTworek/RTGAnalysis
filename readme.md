# RTG Analysis

Aplikacja desktopowa do oznaczania punktów na zdjęciach RTG.

## Built With

* [Java 8](https://www.oracle.com/pl/java/)
* [JavaFx](https://openjfx.io/) - Biblioteka graficzna Javy
* [Maven](https://maven.apache.org/) - Budowanie projektów i zarządzanie zależnościami

### Podstawowe warunki:

 * [x] aplikacja składa się z listy punktów oraz czterech paneli prezentujących ten sam
 obraz
 * [x] oznaczenie miejsca ma charakter punktu
 * [x] dodanie punktu odbywa się poprzez kliknięcie na panelu
 * [x] możemy stworzyć nieskończenie wiele oznaczeń
 * [x] dodany punkt zyskuje swoją reprezentację graficzną na wszystkich panelach oraz
 wpis na liście punktów
 * [x] każdy punkt na liście prezentuje swoje współrzędne x, y za pomocą pól tekstowych
 * [x] możemy dokonywać manipulacji położeniem punktu poprzez przeciągnięcie punktu
 na panelu lub edycję pól tekstowych
 * [x] zmiana położenia punktu poprzez przeciągnięcie aktualizuje dane pól tekstowych dla
 punktu, zmiana wartości w polu tekstowym aktualizuje położenie punktu na panelu
 * [x] współrzędne punktu są określane względem panelu
 * [x] wszystkie panele obrazowe mają taki sam rozmiar i prezentują ten sam obraz
 
 #### Opcjonalne warunki:
 
 * [x] określanie współrzędnych punktu względem obrazu
 * [ ] walidacja pól tekstowych
 
 #### Uwagi:
 
 * Przesunięcie oznaczenia jest możliwe tylko dla pierwszego zdjęcia. Spowodowane jest to brakiem 
   zależności pomiędzy granicami zdjęć.
 * Aktualnie zatwierdzanie pól tekstowych odbywa się przy pomocy klawisza ENTER lub TAB. 
   Możliwość rozszerzenia do zatwierdzenia przez opuszczenie pola tekstowego