package com.lunux2008.url;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ShortUrlApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShortUrlApplication.class, args);
    }

    /*
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    	return args -> {
    		String url = "https://www.baidu.com/s?wd=%E5%A4%8%AD%E9%80%9A%E5%AE%9D&rsv_spt=1&rsv_iqid=0x979cfa270003bd79&issp=1&f=8&rsv_bp=1&rsv_idx=2&ie=utf-8&rqlang=cn&tn=baiduhome_pg&rsv_dl=tb&oq=%25E5%25A4%25A7%25E4%25B8%25AD%25E9%2580%259A%25E5%25AE%259D%25E8%2583%258C%25E6%25B5%2599%25E5%2580%25BC%25E5%25A4%259A%25E5%25B0%2591%25E9%2592%25B1&rsv_enter=1&rsv_btype=t&inputT=226&rsv_t=0a27V4lzTd6aweFGrblC6KyspXrCK9x62rfJD7KY21IVbO4Wl605fQ5qrorc2OjskyWC&rsv_pq=82f1d26f00001b7c&rsv_sug3=189&rsv_sug1=76&rsv_sug7=100&rsv_sug2=0&rsv_sug4=1083";

    		Util util = new Util();
    		long n = util.str2long(url);
    		String s = util.trans(n);
			System.out.println(s);
    	};
    }
    */
}
