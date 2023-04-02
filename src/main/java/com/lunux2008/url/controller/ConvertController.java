package com.lunux2008.url.controller;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lunux2008.url.domain.Counter;
import com.lunux2008.url.service.CounterSerivce;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RequestMapping("/convert")
@RestController
public class ConvertController {

	@Autowired
	private CounterSerivce counterSerivce;
	
	@Autowired JedisPool pool; 

	@GetMapping("/shorten")
	public Counter shorten(@RequestParam("url") String url) {
		if (url == null) {
			return null;
		}

		url = StringEscapeUtils.unescapeHtml4(url);
		
		Counter counter = new Counter();
		try {
			// 获得结果
			counter = counterSerivce.shorten(url);

			// 数据同步redis
			if (counter != null) {
				try (Jedis jedis = pool.getResource()) {
				  jedis.set(counter.getCode(), counter.getUrl());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return counter;
	}
}
