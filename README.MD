# Используемые приложения
1. Intelij IDEA (Community Edition)
2. Docker Desktop
3. Chromedriver Version: 118.0.5993.70
4. Браузер Google Chrome
5. DBeaver
# Процедура запуска тестов
1. Запускаем Docker Desktop
2. Запускаем IDEA Intelij
3. В терминале вводим команду `docker compose up`
4. Во втором терминале вводим команду `java -jar ./artifacts/aqa-shop.jar`
5. В третьем терминале используем команду `./gradlew clean test --info` 
6. Отчеты Allure генерируем командой `./gradlew allureserve`
