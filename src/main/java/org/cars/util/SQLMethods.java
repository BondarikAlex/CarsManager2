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
    public static void writeTable(){
        String query = " INSERT INTO Car (brand,model,year,price) VALUES('BMW', 'e34','1999','2000')"+
                " INSERT INTO Car (brand,model,year,price) VALUES('Opel', 'Зафира','1943','2600')"+
                " INSERT INTO Car (brand,model,year,price) VALUES('Oka', 'пионер','1959','1050')"+
                " INSERT INTO Car (brand,model,year,price) VALUES('Mers', '600','1929','3000')"+
                " INSERT INTO Car (brand,model,year,price) VALUES('Жигули', '2002','1989','4000')"+
                " INSERT INTO Car (brand,model,year,price) VALUES('Вольва', 'rx','1997','5000')"+
                " INSERT INTO Car (brand,model,year,price) VALUES('Белаз', 'вездеход','1996','2045')"+
                " INSERT INTO Car (brand,model,year,price) VALUES('ТанкТиранозавр', 'e34','1995','2000')"+
                " INSERT INTO Car (brand,model,year,price) VALUES('Москвичь', '412','1985','2232')"+
                " INSERT INTO Car (brand,model,year,price) VALUES('Краз', 'e3ва','1980','2034')";
             }
public static void readTable(){
    String query="SELECT * FROM Car" +
            "SELECT brand FROM Car"+
            "SELECT model FROM Car"+
            "SELECT year FROM Car"+
            "SELECT year FROM Car";
}

}
