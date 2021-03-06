# WeatherApp
Weather application

</br>

## Table of contents
- [Descriere](#descriere)
- [Utilizare](#utilizare)
- [Diagramele realizate](#diagramele-realizate)
- [Realizator](#realizator)

## Descriere
Este o aplicate de monitorizare meteorologica dezvoltata in limbajul de programare **Java**. Pornind de la un fisier de intrare cu diferite date despre localitati, aplicatia va realiza cereri prin intermediului API-ului [OpenWeatherAPI](https://openweathermap.org/api) pentru a putea primi ca si raspuns datele meteorologice necesare. Parsarea raspunsului primit de la server, fiind in format JSON, este realizata cu ajutorului bibliotecii [minimal-json](https://github.com/ralfstx/minimal-json). De asemenea, aplicatia foloseste **Maven** pentru rezolvarea dependentilor necesare si [JavaFX](https://openjfx.io/) pentru realizarea aplicatiei cu interfata grafica.
</br>
Pentru rularea aplicatiei, creati o noua configurație de build, adăugați **Maven**, iar la **command line** completati cu **clean compile javafx:run**.

## Utilizare
Aplicatia permite selectarea locatiei dorite prin intermediul a 2 liste prezente in interfata grafica, o lista cu tari si o lista cu orase. In functie de tara selectata, se va actualiza automat si cea de-a doua lista cu orasele specifice din cadrul tarii respective. In cadrul interfetei grafice, vor fi afisate diferite detalii la fiecare selectie:
- **o imagine specifica cu vremea la momentul curent din localitatea respectiva**
- **numele localitatii selectate**
- **data curenta pentru localitatea respectiva**, tinand cont si de aspectele de timp si timezone specifice pentru localitatea respectiva
- **o descriere pentru vremea la momentul curent din localitate**
- **temperatura**
- **presiunea inregistrata**
- **umiditatea**
- **viteza vantului**

Aplicatie pentru rulare are nevoie de un fisier de intrare cu date specifice (**id-ul**, **denumirea**, **latitudinea**, **longitudinea** si **codul tarii**) pentru fiecare localitate dorita pentru procesare. Exemplu fisier de intrare:
```
ID		nm		lat		lon		countryCode
2973393	        Tarascon	43.805828       4.6603		FR
2986678	        Ploufragan	48.491409       -2.7946		FR
819827	        Razvilka	55.591667       37.740833	RU
524901	        Moscow	        55.752220       37.615555	RU
683506		Bucharest	44.4323		26.1063		RO
683123		Buzau		45.15		28.8333		RO
3117735		Madrid		40.4165		-3.7026		ES
3128026		Bilbao		43.2627		-2.9253		ES
2950159		Berlin		52.5244		13.4105		DE
2935517		Dortmund	51.5167		7.45		DE
3169070		Rome		41.8947		12.4839		IT
6542283		Milano		45.4642		9.192		IT
1816670		Beijing		39.9075		116.3972	CN
1796236		Shanghai	31.2222		121.4581	CN
6325494		Quebec		46.8123		-71.2145	CA
6167865		Toronto		43.7001		-79.4163	CA
2766824		Salzburg	47.7994		13.044		AT
2772400		Linz		48.3064		14.2861		AT
3646738		Caracas		10.488		-66.8792	VE
3633009		Maracaibo	10.6317		-71.6406	VE
3054643		Budapest	47.498		19.0399		HU
721239		Eger		47.9026		20.3733		HU
2314302		Kinshasa	-4.3246		15.3215		CD
217831		Bukavu		-2.5083		28.8608		CD
1857910		Kyoto		35.0211		135.7538	JP
1859171		Kobe		34.6913		135.183		JP
3143244		Oslo		59.9127		10.7461		NO
3161733		Bergen		60.392		5.328		NO
2800866		Brussels	50.8504		4.3488		BE
2800482		Charleroi	50.413		4.4465		BE	
```
Fisierul de intrare trebuie trebuie sa aiba numele **input.txt** si trebuie sa se regaseasca in directorul **src/main/resources**. Exista un fisier default deja in calea respectiva. Pentru a putea adauga localitati noi in cadrul acestuia, este nevoie pentru o delimitare cu spatiu/spatii/tab/tab-uri intre coloane.
</br>
</br>
In directorul **src/main/resources/ImageResources** se afla imaginile specifice cu tipurile de vreme posibile care pot fi returnate in raspunsurile primite de la server astfel incat, in functie de tipul returnat, sa poate fi afisata imaginea specifica in cadrul interfetei grafice.

De asemenea, in directorul **src/main/resources** se regaseste si fisierul **log.txt**, fisier in care sunt salvate toate detaliile in legatura cu vremea curenta la fiecare noua localitate selectata din interfata grafica.

## Diagramele realizate
Pentru a vizualiza **diagrama cazurilor de utilizare**, aceasta se regaseste in directorul **Diagrams** -> imaginea **DiagramaCazuriUtilizare.png**
</br>
Pentru a vizualiza **diagrama de clase**, aceasta se regaseste in directorul **Diagrams** -> imaginea **DiagramaClase.png**

## Realizator
:man_student: Brînzea Andrei  
