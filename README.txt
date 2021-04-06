OPIS:

Urządzenia o znanych identyfikatorach przysyłają do systemu zadania które trafiają do kolejki.
Urządzenie nadaje każdemu wysyłanemu zadaniu kolejny numer sekwencji. Zadania każdego urządzenia trafiają do kolejki zgodnie z tą kolejnością.
Wszystkie zadania trzeba obsłużyć z wykorzystaniem dostepnego serwisu aż do opróżnienia kolejki. Obsługa zadania jest czasochłonna.
Zadania dla danego urządzenia trzeba obsłużyć zgodnie z kolejnością numeru sekwencji,
czyli nie można zacząć zadania o seq = x dla tego urządzenia, jeżeli nie skończyła sie jeszcze obsługa zadania o seq = x - 1.
Zadania dla różnych urządzeń nie mają wymagań co do wzajemnej kolejności obsługi

Obecna implementacja znajdująca się w pliku Invoker.scala wykonuje to zadanie w najprostszy sposób z możliwych:
kolejno pobiera zadania i je obsługuje (po jednym na raz), póki są dostępne zadania.
W oczywisty sposób, zachowuje to kolejność obsługi dla każdego urządzenia

ZADANIE:

Niestety ta implementacja jest za wolna.
Należy zmodyfikować obsługę tak żeby przechodziły testy znajdujące się w InvokerTest.scala
Testy te sprawdzają
1) To czy przetwarza on wszystkie zadania i to w dobrej kolejnosci dla każdego z urządzeń.
2) To czy jest w stanie przetworzyć wszystkie zadania w zadanym czasie
Test dotyczący 2) w tej chwili nie przechodzi. Po wykonaniu zadania powinno to się zmienić.

Dla lepszego zamodelowania rozwiązania można zmieniać dowolne pliki
(również źródła testowe o ile tylko nie zmienia się istoty tego co sprawdzają testy)