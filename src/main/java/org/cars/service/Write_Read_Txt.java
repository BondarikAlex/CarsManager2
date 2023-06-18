package org.cars.service;

import org.cars.model.Car;
import org.cars.model.ListCars;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Write_Read_Txt implements Interface_Write_Read {
    public static File fileTXT = new File("Cars.txt");

    public static void deleteFile() {
        if(fileTXT.exists()){
            fileTXT.delete();
            System.out.println("Файл TXT удален");
        }else {
            System.out.println("Возможно его не существует!");
        }
    }

    @Override
    public ArrayList<Car> write(ArrayList<Car> list) {
        try (FileWriter writer = new FileWriter(fileTXT, false)) {
            for (Car car : list) {
                writer.write(car.getBrand() + " " + car.getModel() + " " + car.getYear() + " " + car.getPrice());
                writer.append('\n').flush();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }


    @Override
    public ArrayList<Car> read() throws IOException,NumberFormatException {
        ArrayList<Car> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("Cars.txt"))) {
            while (scanner.hasNextLine()) {
                String[] cars = scanner.nextLine().split(" ");
                list.add(new Car(cars[0], cars[1], Integer.parseInt(cars[2]), Double.parseDouble(cars[3])));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public static ArrayList<Car> writeTXT(){
        return new Write_Read_Txt().write(ListCars.getListCars());
    }
    public static ArrayList<Car> readTXT() throws IOException {
        return new Write_Read_Txt().read();

    }
}
