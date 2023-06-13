package org.cars.service;

import org.cars.model.Car;

import java.io.IOException;
import java.util.ArrayList;

public class Write_Read_Txt implements InterfaceWrite_Read{
    @Override
    public ArrayList<Car> writeFile(ArrayList<Car> list, String nameFile) {
        return null;
    }

    @Override
    public ArrayList<Car> readJsonFile(String nameFile) throws IOException {
        return null;
    }
}
