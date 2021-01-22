
#Dspre
Proiectare Orientata pe Obiecte, Seriile CA, CD 2020-2021

https://ocw.cs.pub.ro/courses/poo-ca-cd/teme/proiect/etapa2

Student: Luta Iulia Andreea, 325 CD

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
    - ClientContract: acelasi lucru de mai sus doar ca este folosita de
    consumatori;
    -Constants: clasa in care am trecut toate constantele folosite de-a lungul
    programului;

    (Design pattern: Factory & Singleton)

    Pentru a implementa primul design pattern de mai sus am ales sa creez doua
factories, una pentru fiecare tip de identitate, avand in vedere ca acestea
au metode foarte diferite in mare. Acestea sunt:
    - DistributorFactory;
    - ConsumerFactory;

    - AbstractFactory: clasa abstracta mostenita de cele doua clase de mai sus.
    Contine metodele pentru creearea tipului de entitate dorit de user;
    - FactoryCreator: implementeaza o metoda ce returneaza tipul de factory
    care trebuie creat, bazat pe alegerea userului. Aceasta clasa implementeaza
    de asemenea si singleton, astfel fiind creata o singura instanta a sa;

    (Implementarea entitatilor principale)

    - ConsumerInterface: contine functiile folosite de consumatori, descrise
    in interiorul codului;
    - DistributorInterface: contine functiile folosite de consumatori, descrise
    in interiorul codului;
    - Entity: clasa este abstracta deoarece aceasta nu va trebui
    instantiata pe parcursul programului. Pur si simplu reprezinta baza pentru
    clasele Distributor si Consumer, clase care o si extind. Entity contine
    elementele comune dintre cele doua entitati ale jocului adica id-ul,
    bugetul si daca a intrat sau nu in faliment;
    -Consumer: defineste campurile si metodele folosite de consumatori.
    Mosteneste Entity si implementeaza functii din ConsumerInterface.
    Pe langa campurile mostenite, aceasta contine si monthlyIncome,
    remainingPayment, care se activeaza in cazul in care consumatorul nu poate
    plati factura o luna si retine valoarea acestria pentru calculul
    penalizarii, si penalty, care devine 1 in momentul in care se activeaza
    remainingPayment. De asemenea aceasta clasa se foloseste si o functie
    private, decreaseNoOfMonths, care scade numarul de luni ramase atat din
    contractul clientului, cat si din cel al consumatorului ales de acest
    client;
    - Distributor: defineste campurile si metodele folosite de distribuitori.
    Mosteneste Entity si implementeaza functiile din DistributorInterface. Pe
    langa campurile mostenite, aceasta contine si contractLength, profit,
    noOfClients, infrastructure/ production Cost, and contracts, care este un
    array ce contine toate contractele distribuitorului cu consumatorii.

    Flow-ul simularii este urmatorul:
    1. Noile costuri de infrastructura si productie sunt actualizate pentru
distribuitori;
    2. Se calculeaza profitul distribuitorilor si preturile pentru contracte;
    3. Pentru fiecare distribuitor se sterg toti consumatorii cu 0 luni ramase
de plata si se scade numarul de clienti ai acestora.
    4. Consumatorii primesc venitul lunar. Daca au 0 luni ramase in contract,
isi cauta alt distribuitor si isi actualizeaza datele din contract.
Distribuitorii adauga contractul in lista lor si isi maresc numarul de clienti.
    5. Consumatorii platesc ratele si distribuitorii le primesc.
    6. Distribuitorii isi calculeaza si platesc costurile lunare.
    7. Daca unul dintre consumatori intra in faliment, distribuitorul ii
sterge contractul din lista sa.
    8. Daca unul dintre distribuitori intra in faliment, toate contractele sale
sunt sterse, numarul de clienti este setat pe 0 si tuturor consumatorilor care
aveau contract cu el li se actualizeaza la 0 numarul de luni ramase din
contract.

    Pentru output, am facut clase separate, pentru a organiza mai bine
rezultatele simularii. Astfel folosesc clasele ConsumerOutput si
DistributorOutput pentru a putea mapa datele in fisierele .json.
    Dupa terminarea simularii, se creeaza si completeaza doua liste de astfel
de obiecte cu rezultatele, apoi se scriu in fisierele de output cu ajutorul
unui obiect de tip ObjectMapper.









