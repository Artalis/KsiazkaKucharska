<%--
  Created by IntelliJ IDEA.
  User: okodr
  Date: 18.06.2018
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Dziel się swoją kuchnią</title>
      <style>
          #style1 {
              padding: 25px;
              background-color: honeydew;
              background-size: auto;
              background-position: right;

          }

          #style2 {
              border: 2px solid black ;
              background: darkslategray;
          }
          #sub {
              width: 15em;  height: 5em;
              background-color: dimgrey;
              position: center;
              color: white;

          }
          #sub2 {
              width: 60em;  height: 5em;

          }
          #tekst{
              padding: 40px;
              font-size: 30px;
          }
      </style>
  </head>
  <body id="style1">
  <center><font size="8">
  <i>"Wybitny kucharz nie wie, co to strach. Musicie mieć wyobraźnię i serce do walki.<br>
    Czasem żądać niemożliwego i nigdy nie pozwólcie, aby ograniczało was to, kim jesteście.<br>
      Duch nie zna granic.(...) Gotować każdy może, lecz tylko nieustraszeni będą mistrzami."</i><br>
  </font>
  <h1 id="style2">
  <form method="post" action="/Meals" ><input id="sub" type="submit" value="Wszystkie dania" name="action" size="35">
      <input id="sub" type="submit" value="Zupy" size="35" name="action">
      <input id="sub" type="submit" value="Dania Główne" size="35" name="action">
      <input id="sub" type="submit" value="Przystawki" size="35" name="action">
      <input id="sub" type="submit" value="Desery" size="35" name="action"></form>
  </h1>
  </center>

  <h1 id="tekst">Podziel się z nami swoim przepisem!</h1>

  <form id="tekst" method="post" action="/Adding">
      <label>Nazwa dania:   </label><input type="text"  name="nazwa" size="41"><br>
      <label>Rodzaj dania:  </label><input type="text" name="rodzaj" size="40"><br>
      <label>Czas przygotowania: </label><input type="text" name="czas" size="25"><br>
      <label>Adres zdjęcia: </label><input type="url" name="zdjecie" size="39"><br>
      <label>Treść przepisu (max. 700 słów):</label><br>
      <input id="sub2" type="text" name="tresc"><br>
      <input id="sub" type="submit" value="Dodaj swój przepis">

  </form>
  </body>
</html>
