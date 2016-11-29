# rnatest2
Тестовое Задание

1. Web UI interface 
Cтраница для аплоада данных (XML файл) в программу.
Cтраница для отображения данных (таблица данных должна быть разбита по страницам).
Cтраница с ссылкой для доунлоада объединенного XML файла (см. ниже).

2. Серверная сторона
Отображать данные из существующего XML файла.
Принимать новые данные и объединять их с уже существующими.
Прим.1: на сервере должен быть только один объединеный файл.
Прим.2: ключевое поле TITLE. 
Прим.3: записи с существующими ключевыми словами должны полностью обновляться новыми данными.

3. Технологии
Обязательно использование Spring MVC  или Struts последних версий;
Tomcat 5.5 +,
JDK 1.5.х  +,
HTML/CSS,
прочие на выбор.


4. Формат данных

<CATALOG> 
   <CD> 
<TITLE>Empire Burlesque</TITLE> 
<ARTIST>Bob Dylan</ARTIST> 
<COUNTRY>USA</COUNTRY> 
<COMPANY>Columbia</COMPANY> 
<PRICE>10.90</PRICE> 
<YEAR>1985</YEAR> 
</CD> 
   <CD> 
<TITLE>Hide your heart</TITLE> 
<ARTIST>Bonnie Tyler</ARTIST> 
<COUNTRY>UK</COUNTRY> 
<COMPANY>CBS Records</COMPANY> 
<PRICE>9.90</PRICE> 
<YEAR>1988</YEAR> 
</CD> 
   <CD> 
<TITLE>Greatest Hits</TITLE> 
<ARTIST>Dolly Parton</ARTIST> 
<COUNTRY>USA</COUNTRY> 
<COMPANY>RCA</COMPANY> 
<PRICE>9.90</PRICE> 
<YEAR>1982</YEAR> 
</CD> 
   <CD> 
<TITLE>Still got the blues</TITLE> 
<ARTIST>Gary Moore</ARTIST> 
<COUNTRY>UK</COUNTRY> 
<COMPANY>Virgin records</COMPANY> 
<PRICE>10.20</PRICE> 
<YEAR>1990</YEAR> 
</CD> 
   <CD> 
<TITLE>Eros</TITLE> 
<ARTIST>Eros Ramazzotti</ARTIST> 
<COUNTRY>EU</COUNTRY> 
<COMPANY>BMG</COMPANY> 
<PRICE>9.90</PRICE> 
<YEAR>1997</YEAR> 
</CD> 
   <CD> 
<TITLE>One night only</TITLE> 
<ARTIST>Bee Gees</ARTIST> 
<COUNTRY>UK</COUNTRY> 
<COMPANY>Polydor</COMPANY> 
<PRICE>10.90</PRICE> 
<YEAR>1998</YEAR> 
</CD> 
   <CD> 
<TITLE>Sylvias Mother</TITLE> 
<ARTIST>Dr.Hook</ARTIST> 
<COUNTRY>UK</COUNTRY> 
<COMPANY>CBS</COMPANY> 
<PRICE>8.10</PRICE> 
<YEAR>1973</YEAR> 
</CD> 
   <CD> 
<TITLE>Maggie May</TITLE> 
<ARTIST>Rod Stewart</ARTIST> 
<COUNTRY>UK</COUNTRY> 
<COMPANY>Pickwick</COMPANY> 
<PRICE>8.50</PRICE> 
<YEAR>1990</YEAR> 
</CD> 
   <CD> 
<TITLE>Romanza</TITLE> 
<ARTIST>Andrea Bocelli</ARTIST> 
<COUNTRY>EU</COUNTRY> 
<COMPANY>Polydor</COMPANY> 
<PRICE>10.80</PRICE> 
<YEAR>1996</YEAR> 
</CD> 
   <CD> 
<TITLE>When a man loves a woman</TITLE> 
<ARTIST>Percy Sledge</ARTIST> 
<COUNTRY>USA</COUNTRY> 
<COMPANY>Atlantic</COMPANY> 
<PRICE>8.70</PRICE> 
<YEAR>1987</YEAR> 
</CD> 
   <CD> 
<TITLE>Black angel</TITLE> 
<ARTIST>Savage Rose</ARTIST> 
<COUNTRY>EU</COUNTRY> 
<COMPANY>Mega</COMPANY> 
<PRICE>10.90</PRICE> 
<YEAR>1995</YEAR> 
</CD> 
   <CD> 
<TITLE>1999 Grammy Nominees</TITLE> 
<ARTIST>Many</ARTIST> 
<COUNTRY>USA</COUNTRY> 
<COMPANY>Grammy</COMPANY> 
<PRICE>10.20</PRICE> 
<YEAR>1999</YEAR> 
</CD> 
</CATALOG>



P.S.

Это действительно тестовое задание, а не задание к реальному проекту.
Все спорные моменты и вопросы, которые могут у Вас возникнуть в ходе выполнения задания, мы оставляем на Ваш выбор, то есть постарайтесь выбрать тот вариант, который наиболее достойно представит ваши знания и умения, но при этом позволит Вам вложиться в указанные сроки.
Будет плюсом если такие вопросы и принятые по ним решения Вы опишете в сопроводительном письме, когда будете высылать код выполненного задания.


demo - https://tranquil-waters-1581.herokuapp.com

файлы для теста в rnatest2/src/test/resources/

запуск на локальной машине:
mvn clean package, из корневой папки проекта - target/bin/webapp.bat
либо запустить me.rnatest.starter.Starter
