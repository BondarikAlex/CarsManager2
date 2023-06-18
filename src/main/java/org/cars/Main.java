package org.cars;

import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import org.cars.model.ListCars;
import org.cars.service.Write_Read_Jackson;
import org.cars.util.AvtoManager;

import java.io.IOException;
import java.sql.*;
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




