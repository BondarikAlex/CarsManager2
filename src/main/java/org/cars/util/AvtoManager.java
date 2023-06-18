package org.cars.util;

import org.cars.model.ListCars;
import org.cars.service.Write_Read_Jackson;
import org.cars.service.Write_Read_Txt;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AvtoManager {
    static Scanner scanner=new Scanner(System.in);
    static int num;
    static boolean button = true;
    static boolean menu = true;

    public static void avtoManager() throws InputMismatchException {
        while (menu) {
            mainMenu();
            try {
                num = scanner.nextInt();
            } catch (InputMismatchException mismatchException) {
                System.out.println("Вводите возможные значения из меню!");
                System.exit(0);
            }catch (IllegalStateException exception){
                System.out.println(exception.getMessage());
                new Scanner(System.in);
            }
            switch (num) {
                case 1 -> menuJSON();
                case 2 -> menuTXT();
                case 3 -> menuPostgrase();
            }
        }
    }
    public static void mainMenu() {
        System.out.println("*************************************************");
        System.out.println("Прога для просмотра функционала нашего проекта!" +
                "Меню:\n" +
                "1 - Json.\n" +
                "2 - Txt.\n" +
                "3 - Postgres.\n" +
                "Ваш выбор!");
    }




    ////////////////////////////////////////////////////
    public static void menuJSON() {

        System.out.println("***** Меню JSON *****\n" +
                "1 - Generated Objects Cars & Write Json File(convert in Json)\n" +
                "2 - Read Json File(return in Object Cars)\n" +
                "3 - Remove Json File!");
       // scanner.nextLine();
        num = scanner.nextInt();
        if (num < 1 | num > 3) {
            System.out.println("Невозможный выбор! Ошибка!");
        } else {
            switch (num) {
                case 1 -> {
                    System.out.println("Генерация листа Cars" + ListCars.getListCars());
                    System.out.println("Произошла запись, в файл Json"); Write_Read_Jackson.writeJson(ListCars.getList());
                }
                case 2 -> {try {
                    System.out.println("Читаю Json и возвращаю лист Car");
                        Write_Read_Jackson.readJson();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 3 -> {
                    Write_Read_Jackson.deleteFile();
                }
            }
        }}
////////////////////////////////////////////////////////
        public static void menuTXT () {
            System.out.println("***** Меню TXT *****\n" +
                    "1 - Write Txt File!\n" +
                    "2 - Read Txt File!\n" +
                    "3 - Remove Txt File!\n");
            num = scanner.nextInt();
            if (num < 1 | num > 3) {
                avtoManager();
                System.out.println("Невозможный выбор! Ошибка!");
            } else {
                switch (num) {
                    case 1 -> {
                        Write_Read_Txt.writeTXT();
                    }
                    case 2 -> {
                        try {
                            Write_Read_Txt.readTXT();
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    case 3 -> {Write_Read_Txt.deleteFile();
                    }

                }
            }
        }
///////////////////////////////////////////////////////2
        public static void menuPostgrase () {
            System.out.println("***** Меню POSTGRES *****\n" +
                    "0 - Проверить подтянут ли образ\n"+
                    "1 - Подтянуть образ в контейнер\n"+
                    "2 - Вытолкнуть  образ из контейнера\n"+
                    "3 - Запустить запрос по созданию (либо замене) БД с добавлением таблицы а также ее заполнением! \n" +
                    "4 - Запустить запросы по получению разных обьектов таблицы, с информацией о каждом запросе и его результе!\n" +
                    "5 - Запустить запрос по фильтрации БД, с информацией о каждом запросе и его результе!\n" +
                    "6 - Запустить запрос по сортировки БД, с информацией о каждом запросе и его результе! ");
            num = scanner.nextInt();
            switch (num) {
                case 0 -> {
                    try {
                       ProcessDocker.dockerPS();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }case 1 -> {
                    try {
                        ProcessDocker.dockerCompose_f();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 2 -> {
                    try {
                        ProcessDocker.dockerDown();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                case 3 -> {
                    JDBCServis jdbcServis=new JDBCServis();
                    jdbcServis.runConnection();
                    jdbcServis.jdbcQuery(new SQLMethods().createTable());
                    jdbcServis.jdbcQuery(new SQLMethods().writeTable());
                    jdbcServis.conClose();
                }

            }

        }
    }