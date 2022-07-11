package com.example.testinggroudweb;

import com.example.testinggroudweb.patrick.model.slipspremium.SlipPremium;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@SpringBootApplication
public class TestingGroudWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestingGroudWebApplication.class, args);
    }
}