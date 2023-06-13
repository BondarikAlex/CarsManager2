package org.cars.service;

import com.fasterxml.jackson.core.type.TypeReference;
import org.cars.model.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.cars.model.ListCars;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class Write_Read_Jackson implements InterfaceWrite_Read {
    @Override//запись в джейсон
    public ArrayList<Car> writeFile(ArrayList<Car> list, String nameFile) {
        ObjectMapper objectMapper = new ObjectMapper();
        list.stream().forEach(i -> {
            try {
                objectMapper.writeValue(new File(nameFile + ".json"), list);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });return list;
    }
@Override
    //чтение из джейсон
    public  ArrayList<Car> readJsonFile(String nameFile) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(nameFile + ".json"), new TypeReference<ArrayList<Car>>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
    }
    public static ArrayList<Car> methodWriteReadJson()throws IOException{
        System.out.println("Создание Json- "+new Write_Read_Jackson().writeFile(ListCars.getListCars(),"Cars"));
        return new Write_Read_Jackson().readJsonFile("Cars");
    }
}



