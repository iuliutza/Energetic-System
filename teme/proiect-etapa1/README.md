# Proiect Energy System Etapa 2

## Despre

Proiectare Orientata pe Obiecte, Seriile CA, CD
2020-2021

<https://ocw.cs.pub.ro/courses/poo-ca-cd/teme/proiect/etapa2>

Student: Luta Iulia Andreea, 325 CD

## Rulare teste

Clasa Test#main
  * ruleaza solutia pe testele din checker/, comparand rezultatele cu cele de referinta
  * ruleaza checkstyle

Detalii despre teste: checker/README

Biblioteci necesare pentru implementare:
* Jackson Core 
* Jackson Databind 
* Jackson Annotations


## Implementare
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

### Entitati

  - Contract: obiectele de acest tip sunt folosite de catre distribuitori
    pentru a retine contractele lor cu consumatorii;
  - ClientContract: acelasi lucru de mai sus doar ca este folosita de
    consumatori;
  -Constants: clasa in care am trecut toate constantele folosite de-a lungul
    programului;

    (Implementarea entitatilor principale)

  - ConsumerInterface: contine functiile folosite de consumatori, descrise
    in interiorul codului;
  - DistributorInterface: contine functiile folosite de distributori, descrise
    in interiorul codului;
  - ProducerInterface: contine functiile folosite de producatori, descrise
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
    Distribuitorul are rol de "observer" si cauta din nou producatori atunci
    cand acestia primesc update-uri.
  - Producer: defineste campurile si metodele folosite de producatori.
    Implementeaza ProducerInterface. Rolul acestei clase este de a retine 
    datele despre producator, statistici lunare, si lista de distribuitori 
    care iau electricitate de la el. Aceasta clasa reprezinta "the observable"
    din design pattern-ul Observer si isi notifica distribuitorii de cate ori
    primeste un update.
  

### Flow

  Flow-ul simularii este urmatorul:
 * In prima runda se aleg producatori.
 * Noile costuri de infrastructura sunt actualizate pentru
distribuitori;
 * Sunt adaugati noii clienti.
 * Sunt incarcate noile update-uri pentru producatori. Daca primesc update
 se anunta distribuitorii si acestia isi cauta din nou producatori.
 * Se calculeaza costul de productie. 
 * Se calculeaza profitul distribuitorilor si preturile pentru contracte;
 * Pentru fiecare distribuitor se sterg toti consumatorii cu 0 luni ramase
de plata si se scade numarul de clienti ai acestora.
 * Consumatorii primesc venitul lunar. Daca au 0 luni ramase in contract,
isi cauta alt distribuitor si isi actualizeaza datele din contract.
Distribuitorii adauga contractul in lista lor si isi maresc numarul de clienti.
 * Consumatorii platesc ratele si distribuitorii le primesc.
 * Distribuitorii isi calculeaza si platesc costurile lunare.
 * Daca unul dintre consumatori intra in faliment, distribuitorul ii
sterge contractul din lista sa.
 * Daca unul dintre distribuitori intra in faliment, toate contractele sale
sunt sterse, numarul de clienti este setat pe 0 si tuturor consumatorilor care
aveau contract cu el li se actualizeaza la 0 numarul de luni ramase din
contract.
* Se inregistreaza statisticile lunare si se salveaza de catre producatori.


### Design patterns

  Design pattern: Factory & Singleton

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

 Design pattern: Strategy & Observer
 
 - Design pattern-ul Observer a fost folosit pentru o parte din interactiunea 
 dintre producatori si distribuitori. Asa cum am explicat mai sus, producatorii
 sunt "observable", iar distribuitorii "the observers". De cate ori producatorii
 primesc un update isi notifica distribuitorii care isi selecteaza din nou
 producatorii.
 -   In ceea ce priveste design pattern-ul Strategy, acesta a fost folosit pentru
 selectarea producatorilor in functie de strategia fiecarui dstribuitor. 
Astfel, au fost create clasele GreenStrategy, PriceStrategy si QuantityStrategy.
Toate implementeaza interfata Strategy, adica functia chooseProducer. In
functie de strategie, distribuitorii isi aleg producatorii in functie de 
tipul de energie produs, pret, cantitate sau toate. Clasa StrategyContext
este clasa prin care se apeleaza aceste strategii.

   


