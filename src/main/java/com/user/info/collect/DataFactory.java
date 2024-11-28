package com.user.info.collect;

import com.user.info.collect.entity.City;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataFactory {



    public static List<String> keyword() {
        List<String> keywords = new ArrayList<>();
        List<City> citys = citys();
        for (City city : citys) {
            for (String key : Config.keys) {
                keywords.add("&c=" + city.getId() + "&wd=" + key);
            }
        }
        return keywords;
    }

    public static List<City> citys(){
        List<City> citys = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(DataFactory.class.getClassLoader().getResource("city_data").getFile()));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] strs = line.split(",");
                System.out.println(line);
                System.out.println(strs[0]);
                citys.add(new City(strs[0], strs[1]));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return citys;
    }
}
