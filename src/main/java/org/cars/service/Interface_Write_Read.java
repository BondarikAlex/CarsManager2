package org.cars.service;

import org.cars.model.Car;

import java.io.IOException;
import java.util.ArrayList;

public interface Interface_Write_Read {

    //запись в джейсон
    ArrayList<Car> write(ArrayList<Car> list);

    //чтение из джейсон
    ArrayList<Car> read() throws IOException;


}
