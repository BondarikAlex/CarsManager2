package org.cars.model;

import java.util.ArrayList;
import java.util.Arrays;

public class ListCars {
    private static ArrayList<Car> list = new ArrayList<>();

    public static ArrayList<Car> getListCars() {
        getList().add(new Car("BMW", "e34", 1996, 5000));
        getList().add(new Car("BMW", "i8", 2014, 140000));
        getList().add(new Car("BMW", "x5 f15", 2015, 70000));
        getList().add(new Car("Volvo", "xc60", 2019, 90000));
        getList().add(new Car("Volvo", "xc90", 2019, 80000));
        getList().add(new Car("Volvo", "v70", 1998, 7000));
        getList().add(new Car("Ford", "f250", 2012, 40000));
        getList().add(new Car("Ford", "Puma", 1998, 6000));
        getList().add(new Car("Geely", "Okavango", 2022, 70000));
        getList().add(new Car("Audi", "100", 1992, 5000));
        getList().add(new Car("Bentley", "Bentayga 1", 2019, 320000));
        return getList();
    }

    public static ArrayList<Car> getList() {
        return list;
    }


}
