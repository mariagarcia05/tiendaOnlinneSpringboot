package org.example.spring.AppTiendaOnlinne;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class AppTienda {
    public static void main(String[]args){
        SpringApplication.run(AppTienda.class,args);
    }

}
