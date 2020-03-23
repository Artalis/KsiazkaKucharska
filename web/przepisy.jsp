<%@ page import="ale.kod.model.Przepis" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: okodr
  Date: 27.06.2018
  Time: 02:02
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="przepisy" value= "${requestScope.przepisy}"> </c:set>
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
            width: 60em;  height: 30em;

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

    <%
        List<Przepis> przepisy = (List<Przepis>)request.getAttribute("przepisy");
        String str= (String) request.getAttribute("akcja");

    %>
    <form method="post" action="/Filtr" ><label>Filtruj po nazwie: </label>
        <input  type="radio" name="action" value="ASC" checked> Alfabetycznie
        <input  type="radio" name="action" value="DESC"> Odwrotnie<br>
        <input  type="submit" value="Filtruj">
        <input  type="text" name="rodzaj" readonly="readonly"  value=<% out.print(str);%>>
    </form>

<form method="post" action="/wyswietl">



<table border="4"  style="background-color:darkslategray;" width="400" >
    <tr style="color:white;" align="center">
        <th>#</th>
        <th>Nazwa</th>
        <th>Rodzaj</th>
        <th>Czas przygotowania [min]</th>
        <th>Strona z przepisem</th>

    </tr>



        <c:forEach items="${przepisy}" var="przepis">
            <tr style="color:white;" align="center" >
                <td>${loop.index+1}</td>
                <td>${przepis.getName()}</td>
                <td>${przepis.getRodzaj()}</td>
                <td>${przepis.getCzas()}</td>
                <td><input class="th" type="submit" name="btn"  value="${przepis.getID()}" style="background:transparent; border:none; color:transparent;" /></td>
            </tr>
        </c:forEach>




</table> <br>
    </form>

</center>
</body>
</html>
