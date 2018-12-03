package com.rizaldi.steam.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SteamWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SteamWebApplication.class, args);
    }
}
