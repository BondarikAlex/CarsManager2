package org.cars;

import org.cars.model.ListCars;
import org.cars.service.Write_Read_Jackson;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Чтение из Json-"+Write_Read_Jackson.methodWriteReadJson());
    }
}
