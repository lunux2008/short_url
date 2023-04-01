package com.lunux2008.url.domain;

import lombok.Data;

@Data
public class Counter {
	private long    id;
	private String md5;
	private String code;
	private String url;
	private int current;
}
