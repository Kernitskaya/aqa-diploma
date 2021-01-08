Для запуска автотестов на Windows необходимо:
1) Выбрать на какой СУБД будет проходить тестирование, исходя из этого в директории проекта выполить:

    а) cd services
    
    b) docker-compose up -f docker_compose_postgre.yml up для СУБД Postgres 
       или docker-compose up -f docker_compose_mysql.yml up для СУБД MySql

2) Запустить приложение:

    a) cd artifacts
    
    б) java -jar .\aqa-shop.jar

3) Запустить тесты командой:
    gradle test --tests <Имя класса>, например gradle test --tests  TravelOfDayPageTest.
    Более подробно про запуск тестов можно прочитать здесь https://docs.gradle.org/current/userguide/java_testing.html

4) При необходимости сгенировать отчет, выполнив команду:
    gradlew allureReport. Отчет будет находиться в директории проекта aqa-diploma\build\reports\allure-report.
    Открывается через браузер