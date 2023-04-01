package com.lunux2008.url.util;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

@Component
public class Convertor {

	private char[] alpha;
	private final int size = 52;

	public Convertor() {
		alpha = new char[size];
		for (int i = 0; i < 26; i++) {
			// A 65, a 97
			alpha[i] = (char)(i+65);
			alpha[i+26] = (char)(i+97);
		}
	}

	public String generateMd5(String str) {
		return DigestUtils.md5DigestAsHex(str.getBytes());
	}

	public long str2long(String str) {
		String digitStr = str.replace("a", "0").replace("b", "1")
						.replace("c", "2").replace("d", "3")
						.replace("e", "4").replace("f", "5");

		return Long.valueOf(digitStr.substring(0, 14));
	}

	public String generateCode(long n) {
		StringBuffer sb = new StringBuffer();
		while (true) {
			long remainder = n % size;
			sb.append(alpha[(int)remainder]);

			n = n / size;
			if (n == 0) {
				break;
			}
		}

		return sb.toString();
	}
}