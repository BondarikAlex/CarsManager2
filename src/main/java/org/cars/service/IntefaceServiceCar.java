package org.cars.service;

import org.cars.model.Car;

import java.util.ArrayList;

public interface IntefaceServiceCar {
    // сортировка по цене
    ArrayList<Car> sortPrice(ArrayList<Car> list);

    //сортировка по бренду
    ArrayList<Car> sortBrand(ArrayList<Car> list);

    //максимальная цена
    double findMaxPrice(ArrayList<Car> list);

    //минимальная цена
    double findMinPrice(ArrayList<Car> list);

    //авто с самой большой ценой
    ArrayList<Car> findCarMaxPrice(ArrayList<Car> list);

    //авто с минимальной ценой
    ArrayList<Car> findCarMinPrice(ArrayList<Car> list);

    //список по бренду
    ArrayList<Car> createCarListByBrand(ArrayList<Car> list, String brand);

    //список по модели
    ArrayList<Car> createCarListByModel(ArrayList<Car> list, String model);

    //список по диапазону цен
    ArrayList<Car> createCarListInPriceDiapason(ArrayList<Car> list, double min, double max);
}
