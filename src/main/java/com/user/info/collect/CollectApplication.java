package com.user.info.collect;

import com.user.info.collect.entity.Boss;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@SpringBootApplication
@MapperScan("com.user.info.collect.mapper")
public class CollectApplication {

    public static void main(String[] args) {

        try {
            BeanFactory.applicationContext = SpringApplication.run(CollectApplication.class, args);


            RestTemplate restTemplate = RestTemplateConfig.getRestTemplate();

            MapResponse response = null;
            String url = null;
            List<String> keywords = DataFactory.keyword();
            for (String keyword : keywords) {
                url = Config.MAP_API_BEF + keyword + Config.MAP_API_AFT;

                response = restTemplate.getForEntity(url, MapResponse.class).getBody();

                List<Boss> bossList = response.getContent();

                if (bossList != null) {

                    for (Boss b : bossList) {
                        if (Objects.nonNull(b.getTel())) {
                            System.out.println(b.getName() + ":" + b.getTel());
                            BeanFactory.bossMapper().save(b);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}