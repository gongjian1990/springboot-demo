package com.gongj.springbootrediscache.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

import java.lang.reflect.Method;

@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    //缓存对象集合中，缓存是以key-value的形式保存的,当不指定缓存key是，会使用KeyGenerator生成key
    //定义缓存数据 key 生成策略的bean包名+类名+方法名+所有参数
    @Bean
    public KeyGenerator keyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... objects) {
                StringBuffer buffer = new StringBuffer();
                buffer.append(target.getClass().getName());
                buffer.append(method.getName());
                for (Object object : objects) {
                    buffer.append(object.toString());
                }
                return buffer.toString();
            }
        };
    }

    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        CacheManager cacheManager = new RedisCacheManager(redisTemplate);
        return cacheManager;
    }

    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory factory){
        RedisTemplate redisTemplate = new StringRedisTemplate(factory);

        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(mapper);

        redisTemplate.setValueSerializer(serializer);
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}
