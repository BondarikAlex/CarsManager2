package org.cars.model;

public class Car {
    private String brand;
    private String model;
    private int year;
    private double price;
    private long id;

    public Car() {

    }

    public Car(String brand, String model, int year, double price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
    }

    public Car(String brand, String model, int year, double price, long id) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.id = id;
    }



    public String getBrand() {
        return brand;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", price=" + price +
                ", id=" + id +
                '}';
    }
}
