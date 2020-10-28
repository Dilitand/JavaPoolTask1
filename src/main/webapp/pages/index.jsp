<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Начальная страница из index2</title>
<body>
<h2></h2>
<div class="container">
    <header class="site-header">
        <h1>Симулятор банковских переводов</h1>
    </header>

    <section class="commands">
        <h2>Доступные команды</h2>
        <ul class="commands-list">
            <li>/getAllClients - все клиенты со счетами и остатками <a href="http://localhost:8080/JavaRebootMVC20200430_MVC_war_exploded/getAllClients" target="_blank">Тык</a></li>
            <li>/getclients/{name} - клиент по имени </li>
            <li>/getclient/{id} - клиент по id</li>
            <li>/account/{accountNumber} - все операции по счету <a href="http://localhost:8080/JavaRebootMVC20200430_MVC_war_exploded/account/40702810001" target="_blank">пример с 40702810001</a></li>
            <li>/deposit?account=40702810001&sum=111.2 - положить деньги на счет </li>
            <li>/withdraw?account=40702810001&sum=111.2 - снять деньги со счета</li>
            <li>/transfer?accountFrom=40702810001&accountTo=40702810002&sum=100 - перевести со счета на счет</li>
            <li>..</li>
        </ul>
    </section>

</div>
</body>
</html>
