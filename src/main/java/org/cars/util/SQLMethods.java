package org.cars.util;

public class SQLMethods {
    public static void createTable(){
        String query = "CREATE TABLE if not exists 'Car' ("+
                "'ID' 	INTEGER  NOT NULL,"+
        "'bran' TEXT not null check(trim(brand)!= ''),"+
                "'model' TEXT not null check(trim(model)!= ''),"+
                "'year'	INTEGER,"+
                "'price' INTEGER,"+
                "PRIMARY KEY('ID' AUTOINCREMENT)";
    }

}
