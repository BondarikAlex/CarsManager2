package org.cars.util;

import java.sql.*;

public class SQLMethods {
    public String createTable() {
        return "CREATE TABLE IF NOT EXISTS Car (\n" +
                "             Id SERIAL PRIMARY KEY,\n" +
                "        brand TEXT not null check(trim(brand)!= ''),\n" +
                "                model TEXT not null check(trim(model)!= ''),\n" +
                "                year\tINTEGER,\n" +
                "                price INTEGER);";
    }

    public String writeTable() {//
        return "INSERT INTO Cars (brand,model,year,price) VALUES('BMW', 'e34',1999,2000);\n" +
                "INSERT INTO Cars (brand,model,year,price) VALUES('Opel', 'Зафира',1943,2600);\n" +
                "INSERT INTO Cars (brand,model,year,price) VALUES('Oka', 'пионер',1959,1050);\n" +
                "INSERT INTO Cars (brand,model,year,price) VALUES('Mers', '600',1929,3000);\n" +
                "INSERT INTO Cars (brand,model,year,price) VALUES('Жигули', '2002',1989,4000);\n" +
                "INSERT INTO Cars (brand,model,year,price) VALUES('Вольва', 'rx',1997,5000);\n" +
                "INSERT INTO Cars (brand,model,year,price) VALUES('Белаз', 'вездеход',1996,2045);\n" +
                "INSERT INTO Cars (brand,model,year,price) VALUES('ТанкТиранозавр', 'e34',1995,2000);\n" +
                "INSERT INTO Cars (brand,model,year,price) VALUES('Москвичь', '412',1985,2232);\n" +
                "INSERT INTO Cars (brand,model,year,price) VALUES('Краз', 'e3ва',1980,2034);";
    }

    public String readTable() {
        return "SELECT * FROM Cars;" +
                "SELECT brand FROM Cars;" +
                "SELECT model FROM Cars;" +
                "SELECT year FROM Cars;" +
                "SELECT year FROM Cars;";
    }


}
