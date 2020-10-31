<head>
    <meta charset="UTF-8"/>
    <link href="css/index.css" rel = "stylesheet"/>
</head>

<body style="color: black; background-color: lightgray">
    <div class = "headers">
        Предварительно:
    </div>
    <div>
        1. Ставим докер.
		<br/>
        2. Запускаем в cmd в папке с проектом "docker-compose up --build"
		<br/>
        3. БД поднимется на http://localhost:5435 (логин root, пароль root), рест сервер на  http://localhost:8085/myapp
    </div>
    <div class = "headers">
        Тестовые запросы:
    </div>
    <table border="1">
        <tr>
            <td class = "head">Метод</td>
            <td class = "head">Назначение</td>
            <td class = "head">Маппинг</td>
            <td class = "head">Параметры</td>
            <td class = "head">Пример (ссылка)</td>
        </tr>
        <tr>
            <td>GET</td>
            <td>Получить весь список машин</td>
            <td>auto/listAuto</td>
            <td>без параметров</td>
            <td>
                <a href = "http://localhost:8085/myapp/auto/listAuto" target="_blank">http://localhost:8085/myapp/auto/listAuto</a>
            </td>
        </tr>
        <tr>
            <td>GET</td>
            <td>Получить машину по id</td>
            <td>auto/{ID}</td>
            <td>без параметров</td>
            <td>
                <a href = "http://localhost:8085/myapp/auto/1" target="_blank">http://localhost:8085/myapp/auto/1</a>
            </td>
        </tr>
        <tr>
            <td>GET</td>
            <td>Получить машину по id</td>
            <td>auto/getAuto</td>
            <td>id</td>
            <td>
                <a href = "http://localhost:8085/myapp/auto/getAuto?id=1" target="_blank">http://localhost:8085/myapp/auto/getAuto?id=1</a>
            </td>
        </tr>
        <tr>
            <td>GET</td>
            <td>Удалить машину по id</td>
            <td>auto/remove</td>
            <td>id</td>
            <td>
                <a href = "http://localhost:8085/myapp/auto/remove?id=50" target="_blank">http://localhost:8085/myapp/auto/remove?id=50</a>
            </td>
        </tr>
    <!--
        <tr>
            <td>GET</td>
            <td>Получить машины по модели</td>
            <td>auto/listAutoByModel</td>
            <td>model</td>
            <td> 
                <a href = "http://localhost:8085/myapp/auto/listAutoByModel?model=Jaguar" target="_blank">http://localhost:8085/myapp/auto/listAutoByModel?model=Jaguar</a>
            </td>
        </tr>
    -->
        <tr>
            <td>POST</td>
            <td>Добавить машину</td>
            <td>auto/add</td>
            <td>без параметров</td>
            <td>
                <form name = "addcar" method="POST" action="http://localhost:8085/myapp/auto/add">
                    <input name="model" placeholder = "Модель">
                    <input name="maxspeed" placeholder = "Макс.скорость" type="number"> 
                    <input name="mileage" placeholder = "Пробег" type = "number"> 
                    <input type="submit">
                </form>   
            </td>
        </tr>
        <tr>
            <td>POST</td>
            <td>Обновить машину</td>
            <td>auto/update</td>
            <td>без параметров</td>
            <td>
                <form name = "addcar" method="POST" action="http://localhost:8085/myapp/auto/update">
                    <input name="id" placeholder = "id" id = "id">
                    <input name="model" placeholder = "Модель" >
                    <input name="maxspeed" placeholder = "Макс.скорость" type="number"> 
                    <input name="mileage" placeholder = "Пробег" type = "number"> 
                    <input type="submit">
                </form>   
            </td>
        </tr>
        <tr>
            <td>GET</td>
            <td>Поиск по параметрам</td>
            <td>auto/listAutoByParams</td>
            <td>model<br/>minSpeed<br/>maxSpeed<br/>minMileAge<br/>maxMileAge</td>
            <td>
                <a href = "http://localhost:8085/myapp/auto/listAutoByParams?model=Rover&maxSpeed=300&minSpeed=200&maxMileAge=300000" target="_blank">http://localhost:8085/myapp/auto/listAutoByParams?model=Rover&maxSpeed=300&minSpeed=200&maxMileAge=300000</a>
            </td>
        </tr>   
    </table>

    <div class = "headers">
        Пагинация
    </div>        
    <div>
            <table border = 1>
                <tr>
                    <td>
                        <form name = "addcar" method="GET" action="http://localhost:8085/myapp/auto/listAutoByParams">
                            <input name="model" placeholder = "Модель" id = "model">
                            <input name="minSpeed" placeholder = "Макс.скорость от" type="number"> 
                            <input name="maxSpeed" placeholder = "Макс.скорость до" type="number"> 
                            <input name="minMileAge" placeholder = "Пробег от" type = "number"> 
                            <input name="maxMileAge" placeholder = "Пробег до" type = "number"> 
                            <input name="page" placeholder = "Страница" type = "number"> 
                            <input name="countPage" placeholder = "Кол-во на странице" type = "number"> 
                            <input type="submit" onClick="btnClick()">
                        </form>   
                    </td>
                </tr>

    </div>
    <script src="js/index.js"></script>
</body>
