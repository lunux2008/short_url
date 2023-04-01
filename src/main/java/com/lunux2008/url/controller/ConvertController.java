package com.lunux2008.url.controller;

import org.apache.commons.text.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lunux2008.url.domain.Counter;
import com.lunux2008.url.service.CounterSerivce;

@RequestMapping("/convert")
@RestController
public class ConvertController {

	@Autowired
	private CounterSerivce counterSerivce;

	@GetMapping("/shorten")
	public Counter shorten(@RequestParam("url") String url) {
		if (url == null) {
			return null;
		}

		url = StringEscapeUtils.unescapeHtml4(url);
		
		Counter counter = new Counter();
		try {
			counter = counterSerivce.shorten(url);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return counter;
	}
}
