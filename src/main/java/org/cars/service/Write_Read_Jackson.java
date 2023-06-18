package org.cars.service;

import com.fasterxml.jackson.core.type.TypeReference;
import org.cars.model.Car;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Write_Read_Jackson implements Interface_Write_Read {
    public static File fileJSON=new File("Cars.json");
    @Override//запись в джейсон
    public ArrayList<Car> write(ArrayList<Car> list) {
        ObjectMapper objectMapper = new ObjectMapper();
        list.stream().forEach(i -> {
            try {
                objectMapper.writeValue(fileJSON, list);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return list;
    }
    @Override
    //чтение из джейсон
    public ArrayList<Car> read() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(fileJSON, new TypeReference<>() {

        });
    }


public static void deleteFile(){
    if(Write_Read_Jackson.fileJSON.exists()){if(Write_Read_Jackson.fileJSON.delete()){
        System.out.println("Файл удален");}
    }else
        System.out.println("По неизвестной причине файл не удалился! Возможно его там нет!");}

public static void writeJson(ArrayList<Car> list){
     new Write_Read_Jackson().write(list);
}
public static ArrayList<Car> readJson() throws IOException {
   return new Write_Read_Jackson().read();

}



}



