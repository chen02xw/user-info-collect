package com.user.info.collect;

import com.user.info.collect.mapper.BossMapper;
import org.springframework.context.ApplicationContext;
import org.springframework.http.client.ClientHttpRequestFactory;

public class BeanFactory {

    public static ApplicationContext applicationContext;

    private static BossMapper bossMapper;

    public static BossMapper bossMapper(){
        if(bossMapper == null){
           bossMapper= BeanFactory.applicationContext.getBean(BossMapper.class);
        }
        return bossMapper;
    }
}
