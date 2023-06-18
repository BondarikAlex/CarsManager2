package org.cars.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessDocker {
   // String comandDockerPs="docker ps";
  //  String comandDockerCompose_f="docker compose -f /home/sania/Postgres/docker-compose.yml   up -d";
   // String comandDockerDown="docker compose -f /home/sania/Postgres/docker-compose.yml  down --remove-orphans ";
public static void dockerPS()throws IOException,InterruptedException {
    System.out.println("Провека на существование подтянутых контейнеров! ");
    Process p=Runtime.getRuntime().exec("docker ps");
    p.waitFor();
    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(p.getInputStream()));
    String line = "";
    while ((line=bufferedReader.readLine())!=null){
        System.out.println(line);
    }
}
    public static void dockerCompose_f()throws IOException,InterruptedException {
        System.out.println("Подтягиваю образ!! ");

        Process p=Runtime.getRuntime().exec("docker compose -f /home/sania/Postgres/docker-compose.yml   up -d");
        p.waitFor();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
    }
    public static void dockerDown()throws IOException,InterruptedException {
        System.out.println("Убираю образ из контейнера! ");

        Process p=Runtime.getRuntime().exec("docker compose -f /home/sania/Postgres/docker-compose.yml  down --remove-orphans ");
        p.waitFor();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line = "";
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
    }
}
