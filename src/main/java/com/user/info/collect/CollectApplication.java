package com.user.info.collect;

import org.apache.catalina.core.ApplicationContextFacade;
import org.apache.naming.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.beans.beancontext.BeanContext;
import java.util.Arrays;
import java.util.List;
@SpringBootApplication
public class CollectApplication {



	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = null;
		try {
			applicationContext= SpringApplication.run(CollectApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}

RestTemplate restTemplate= applicationContext.getBean(RestTemplate.class);
		MapResponse response=null;
		try {

			response = restTemplate.getForEntity(Config.MAP_API, MapResponse.class).getBody();
		}catch(Exception e){
			e.printStackTrace();
		}
		List<Boss> bossList = response.getContent();

		for(Boss b : bossList){
			System.out.println(b.getName());
		}
	}



//
//	@Bean("restTemplate")
//	public RestTemplate restTemplate(){
//		restTemplate = new RestTemplate();
//		MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//		mappingJackson2HttpMessageConverter.setSupportedMediaTypes(Arrays.asList(
//				MediaType.TEXT_HTML,
//				MediaType.TEXT_PLAIN));
//		restTemplate.getMessageConverters().add(mappingJackson2HttpMessageConverter);
//
//		return restTemplate;
//	}

}
