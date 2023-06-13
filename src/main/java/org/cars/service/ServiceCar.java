package org.cars.service;

import org.cars.model.Car;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ServiceCar implements IntefaceServiceCar {
    // сортировка по цене
@Override
    public ArrayList<Car> sortPrice(ArrayList<Car> list) {

        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).getPrice() > list.get(i + 1).getPrice()) {
                    Car buf;
                    buf = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, buf);
                    isSorted = false;
                }
            }
        }
        return list;
    }

    //сортировка по бренду
    @Override
    public ArrayList<Car> sortBrand(ArrayList<Car> list){

        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).getBrand().toLowerCase().compareTo(list.get(i + 1).getBrand().toLowerCase())>0) {
                    Car buf;
                    buf = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, buf);
                    isSorted = false;
                }
            }
        }
        return list;
    }

    //максимальная цена
    @Override
    public double findMaxPrice(ArrayList<Car> list) {
        double max = 0;
        for (Car car : list) {
            if (car.getPrice() > max) {
                max = car.getPrice();
            }
        }
        return max;
    }

    //минимальная цена
    @Override
    public double findMinPrice(ArrayList<Car> list) {
        double min = list.get(0).getPrice();
        for (Car car : list) {
            if (car.getPrice() < min) {
                min = car.getPrice();
            }
        }
        return min;
    }

    //авто с самой большой ценой
    @Override
    public ArrayList<Car> findCarMaxPrice(ArrayList<Car> list) {
        double max = 0;
        for (Car car : list) {
            if (car.getPrice() > max) {
                max = car.getPrice();
            }
        }
        double finalMax = max;
        return (ArrayList<Car>) list.stream()
                .filter(i -> i.getPrice() == finalMax)
                .collect(Collectors.toList());
    }

    //авто с минимальной ценой
    @Override
    public  ArrayList<Car> findCarMinPrice(ArrayList<Car> list) {
        double min = list.get(0).getPrice();
        for (Car car : list) {
            if (car.getPrice() < min) {
                min = car.getPrice();
            }
        }
        double finalMin = min;
        return (ArrayList<Car>) list.stream()
                .filter(i -> i.getPrice() == finalMin)
                .collect(Collectors.toList());
    }

    //список по бренду
    @Override
    public ArrayList<Car> createCarListByBrand(ArrayList<Car> list, String brand) {
        return (ArrayList<Car>) list.stream()
                .filter(i -> i.getBrand().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

    //список по модели
    @Override
    public ArrayList<Car> createCarListByModel(ArrayList<Car> list, String model) {
        return (ArrayList<Car>) list.stream()
                .filter(i -> i.getModel().equalsIgnoreCase(model))
                .collect(Collectors.toList());
    }


    //список по диапазону цен
    @Override
    public ArrayList<Car> createCarListInPriceDiapason(ArrayList<Car> list, double min, double max) {
        return (ArrayList<Car>) list.stream()
                .filter(i -> i.getPrice() >= min && i.getPrice() <= max)
                .collect(Collectors.toList());
    }
}
