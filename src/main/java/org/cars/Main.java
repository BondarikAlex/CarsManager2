package org.cars;

import org.cars.util.AvtoManager;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Чтение из Json-"+Write_Read_Jackson.methodWriteReadJson());
        try {
            AvtoManager.avtoManager() ;
        }catch (InputMismatchException exception){
            System.out.println(exception.getMessage());
        }

    }
}




