﻿# **Лабораторная работа №3**
### **Задание на лабораторную работу**
В процессе написания тестовых заданий ознакомиться с концепцией интерфейсов и исключительными ситуациями в Java.
### **Задание**
1. Описать два класса с идентичным внешним контрактом, принадлежащих одной предметной области (функциональная семантика предметной области выбирается самостоятельно). Оба класса должны содержать:

   * поле – массив, поле строкового типа, поле целого типа, возможно добавление других необходимых полей;

   * конструктор по умолчанию, и конструктор с параметрами, позволяющими полностью инициализировать объект;

   * методы доступа к элементам массива и к полям;

   * бизнес-метод, реализующий некоторую функцию от элементов массива и полей объектов классов (арифметическую, логическую, конкатенацию и т.п.).

2. Описать интерфейс, задающий список сигнатур методов доступа к полям объектов и функционального метода, оба класса должны реализовывать интерфейс.

3. В классах корректно переопределить методы класса Object – toString(), equals(), hashCode().

4. Разработать программное приложение, имеющее адекватный интерфейс пользователя, в котором организовать базу (массив) объектов типа интерфейс и заполнить ее объектами описанных типов вперемежку (по желанию пользователя приложения). Выполнить следующие действия:

   * вывести полную информацию обо всех объектах массива;

   * найти в массиве объекты, бизнес-метод которых возвращают одинаковый результат, поместить такие объекты в другие массивы (в новых массивах хранятся объекты из исходной балы, имеющие одинаковый результат выполнения бизнес-метода); 

   * разбить исходный массив на два массива, в которых будут храниться однотипные элементы (проверять реальный тип объекта);

5. При описании классов описать собственные исключения - одно объявляемое (наследное от Exception) и одно необъявляемое (наследное от RuntimeException) исключения, характеризующие ошибки, связанные с выполнением методов классов и учитывающие специфику исключения (объявляемость и необъявляемость). Обычно объявляемое исключение связано с логикой работы метода, поэтому его, видимо, надо выбрасывать из бизнес-метода. Необъявляемое исключение можно связать с некорректными входными данными для методов-сеттеров. В соответствующих методах выбрасывать/при выбросе контролировать описанные исключения.

   *Пример семантики*. Класс «Серия сочинений» (поле – массив хранит количество страниц в каждой книге серии, второе поле – название серии, третье поле – количество страниц в книге, занятых вводной информацией, бизнес-метод – подсчет общего количества страниц серии без учета вводных страниц книг) и класс «Сборник статей» (поле – массив хранит количество страниц каждой статьи, второе поле – название сборника, третье поле – максимально допустимое количество страниц для аннотации статьи, бизнес-метод – подсчет общего количества страниц без учета аннотаций статей). Необъявляемые исключение – невалидные значения в параметрах конструкторов и методов доступа (неположительная длина массива, несуществующий индекс в массиве, недопустимое значение поля, etc.), объявляемое исключение – ошибка бизнес-метода.
### **Контрольные вопросы.**
1. Состав класса
2. Модификаторы доступа
3. Модификаторы полей
4. Модификаторы методов
5. Одномерные массивы, правила обработки
6. Многомерные массивы, правила обработки
7. Класс Object
8. Исключения в java, отлов исключений
9. Объявляемые исключения, работа с ними
10. Необъявляемые исключения, работа с ними
11. Наследование в java
12. Наследование конструкторов, работа с конструкторами
13. Наследование полей, методов
14. Служебное слово super()
15. Операции проверки и преобразования типов
16. Завершенные классы и завершенные методы
17. Абстрактные методы, абстрактные классы
18. Интерфейс, понятие, состав, особенности
19. Реализация интерфейса
20. Наследование для интерфейсов

