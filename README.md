# Hotel_RestAPI
It's practice project rest api 


# Table 
Table describes how different operations are assign to resources.
|URI|GET|POST|PUT|PATCH|DELETE|
|:---:|:---:|:---:|:---:|:---:|:---:|
| /guest | Lista gości | Dodaj gościa | X | X | X |
| /guest/{idCardNr}| Info o gosciu | X | Aktualizacja | Zmiana części | Koniec pobytu |
| /room | Lista pokojów | Dodaj pokój | X | X | X |
| /room/{Nr} | Info o pokoju | X | Aktualizacja info o pokoju | X | Usuń pokój |
| /reservation | Lista rezerwacji | Dodaj rezerwacje | X | X | Usun wszystkie rezerwacje |
| /reservation/{UUID} | Info o rezerwacji | X | Aktualizacja | Czesciowa aktualizacja | Koniec rezerwacni + Dodaj arch rezerwacje| 
| /arch | Lista archiwalnych rezerwacji | X | X | X | X | 
| /arch/{UUID} | Info i archiwalnej rezerwacji | X | X | X | X |


# How it works

# Mby smth else