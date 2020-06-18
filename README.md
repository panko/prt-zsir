# Zsír kártyajáték

A közismert Zsír kártyajáték Java megvalósítása, MAVEN-el, JavaFX-el, Hibernate-el, HSQLDB-vel JDBC-sen. A "Programtervezési technológiák" nevū tárgyam feléves gyakorlati munkája.

### A játékról
A zsírozás (más néven hetes) egyszerű kártyajáték, ketten vagy négyen játszhatják magyar kártyával. A játék célja, hogy minél több „zsír” kártyát (ászt vagy tízest) gyűjtsünk össze az ütéseinkkel a játék során. A játékban nincs aduszín, és a lapoknak sincs pontértékére, rangsora.

### Funkciók
  - Regisztráció 
  - Csak regisztrált felhasználók léphetnek be

#### Zsírozás menete
Az osztásnál minden játékos négy-négy lapot kap, a többi kártyát középre helyezik, ahonnan minden kör után húznak egy vagy több új lapot (annak megfelelően, hogy hány kártya ment ki az adott körben). Az osztótól jobbra lévő játékos kezdi a játékot bármelyik kártyával. A kihívott lapot csak azonos értékű kártyával lehet ütni. Kiemelt lap a hetes (VII), mert ezt a lapot bármely kihívottal egyezőként használhatjuk. Például: amennyiben az első játékos nyolcassal (VIII) kezd, viszont a következő erre szintén nyolcast (VIII) tesz. Ebben a körben a második játékos viheti a lapokat, hiszen tudott azonos értékű kártyát tenni.

Egy kihívott lapot többször is meg lehet ütni. Ha például a kezdő játékos egy tízessel nyit és megütik, a hívó folytathatja egy következő körrel és a letett lapokat másodszor, akár többször is megütheti, a végén pedig az összegyűlt kupac azé lesz, aki a kihívó lappal megegyező utolsó lapot vagy hetest tette le.

Aki az ütést vitte, az hívhat újra.

A győztes az lesz, aki a legtöbb ászt és tízest nyerte el a játszma során. Két játékos esetén ez minimum öt lapot jelent. Egyenlőség esetén az nyer, aki utoljára ütött. Aki a játék során egyszer sem tudott ütni, az „kopasz” marad. 

### Képernyõfotók
<img width="800" alt="Screenshot 2020-06-18 at 13 39 02" src="https://user-images.githubusercontent.com/1569515/85016960-fe573800-b16a-11ea-938c-e59f42c9cdde.png">
<img width="829" alt="Screenshot 2020-06-18 at 13 38 04" src="https://user-images.githubusercontent.com/1569515/85016967-00b99200-b16b-11ea-85b0-b00f16e27c23.png">

Licenc
----

MIT
