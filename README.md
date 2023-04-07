# Perceptron
W pliku perceptron.data znajdują się dane treningowe: zbiór Iris ograniczony do Iris-versicolor

i Iris-virginica. W pliku perceptron.test.data znajduje się zbiór testowy. Zaimple-
mentuj perceptron i wytrenuj, aby rozróżniał dwa gatunki. Testuj na zbiorze testowym i

wypisz dokładność klasyfikacji.
Program powinien umożliwiać:
 Wczytanie dowolnego zbioru treningowego z pliku w formacie csv, gdzie ostatnia
kolumna to atrybut decyzyjny. Powinien dostosowywać liczbę wag do wczytanego
zbioru. (!!)
 Wybór stałej uczenia.
 Prosty interfejs pozwalający na podanie ręczne wektorów do klasyfikacji.
 Wskazówki:

– Dla najlepszych efektów należy wybrać małą stałą uczenia (np. 0.01) i powta-
rzać przez wiele iteracji (tzw. epok).

– Wagi początkowe można losować np. z zakresu [0, 1].
– Klasy Iris-versicolor i Iris-virginica nie są liniowo separowalne (błąd
iteracji podczas uczenia będzie większy od 0), ale mimo tego możliwe jest
uzyskanie wysokiej dokładności na zbiorze testowym.