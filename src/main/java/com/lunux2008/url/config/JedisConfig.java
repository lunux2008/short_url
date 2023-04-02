package com.lunux2008.url.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class JedisConfig {

	@Value("${spring.redis.host}")
	private String host;

	@Value("${spring.redis.port}")
	private int port;

	@Value("${spring.redis.password}")
	private String password;

	@Value("${spring.redis.timeout}")
	private int timeout;

	@Value("${spring.redis.jedis.pool.max-active}")
	private int maxActive;

	@Value("${spring.redis.jedis.pool.max-idle}")
	private int maxIdle;

	@Value("${spring.redis.jedis.pool.min-idle}")
	private int minIdle;

	@Value("${spring.redis.jedis.pool.max-wait}")
	private Duration maxWait;

	
	@Bean
	public JedisPool jedisPoolFactory() {
		JedisPoolConfig conf = new JedisPoolConfig();
		conf.setMaxIdle(maxIdle);
		conf.setMaxWait(maxWait);
		conf.setMaxTotal(maxActive);
		conf.setMinIdle(minIdle);

        JedisPool pool = new JedisPool(conf, host, port, timeout, password);

		return pool;
	}
}
