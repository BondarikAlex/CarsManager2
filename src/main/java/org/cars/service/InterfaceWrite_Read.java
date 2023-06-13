package org.cars.service;

import org.cars.model.Car;

import java.io.IOException;
import java.util.ArrayList;

public interface InterfaceWrite_Read {
    ArrayList<Car> writeFile(ArrayList<Car> list, String nameFile);

    //чтение из джейсон
    ArrayList<Car> readJsonFile(String nameFile) throws IOException;
}
