package com.roncoo.eshop.dataaggr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Author linjingcheng
 * @data 2020/10/17
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class EshopDataAggrServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EshopDataAggrServiceApplication.class);
    }

    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(100);
        config.setMaxIdle(5);
        config.setMaxWaitMillis(1000 * 10);
        config.setTestOnBorrow(true);
//        return new JedisPool(config, "localhost", 6379);
        return new JedisPool(config, "192.168.1.16", 1111);

    }
}
