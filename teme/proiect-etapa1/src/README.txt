Luta Iulia Andreea
325 CD

    Pentru inceput am decis sa impart proiectul in trei parti mari : citire,
scriere si rezolvarea jocului in sine. Pentru fiecare dintre ele am ales sa
fac clase separate pentru a lucra cat de "curat" si organizat posibil.
    In ceea ce priveste inputul, clasele reflecta exact organizarea datelor
din fisierele .json. Incarcarea datelor intr-o instanta a clasei Input a fost
facuta cu ajutorul functiei readData din clasa InputLoader. Aceasta primeste
un path catre fisierul din care citeste, si foloseste ObjectMapper pentru
a parsa datele.
    Trecand la implementarea jocului propriu-zis, acesta se foloseste de
urmatoarele clase:
    - Contract: obiectele de acest tip sunt folosite de catre distribuitori
    pentru a retine contractele lor cu consumatorii;
    -Constants: clasa in care am rtecut toate constantele folosite de-a lungul
    programului
    - ClientContract: acelasi lucru de mai sus doar ca este folosita de
    consumatori;
    - Entity: am ales sa fie clasa abstracta deoarece aceasta nu va trebui
    instantiata pe parcursul programului. Pur si simplu reprezinta baza pentru
    clasele Distributor si Consumer, clase care o si extind. Entity contine
    elementele comune dintre cele doua entitati ale jocului adica id-ul,
    bugetul si daca a intrat sau nu in faliment.

    (Design pattern: Factory)
    Pentru a implementa design pattern-ul de mai sus am ales sa creez doua
factories, una pentru fiecare tip de identitate, avand in vedere ca acestea
au metode foarte diferite in mare. Aceste factories, sunt la randul lor create
cu ajutorul altui factory.


