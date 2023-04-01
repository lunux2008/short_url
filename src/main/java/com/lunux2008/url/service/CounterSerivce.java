package com.lunux2008.url.service;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lunux2008.url.domain.Counter;
import com.lunux2008.url.mapper.CounterMapper;
import com.lunux2008.url.util.Convertor;

@Service
public class CounterSerivce {
	
	@Autowired
	private Convertor convertor;

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	public Counter shorten(String url) {
		String  md5 = convertor.generateMd5(url);
		long  digit = convertor.str2long(md5);
		String code = convertor.generateCode(digit);

		try (SqlSession session = sqlSessionFactory.openSession()) {
			CounterMapper mapper = session.getMapper(CounterMapper.class);

			Counter counter = mapper.selectByCounterMd5(md5);
			// 相同URL直接返回结果
			if (counter != null) {
				return counter;
			}

			// 查找code相同的counter
			counter = mapper.selectByCounterCode(code);

			// 没有相同code的counter直接保存
			if (counter == null) {
				counter = new Counter();
				counter.setMd5(md5);
				counter.setCode(code);
				counter.setUrl(url);
				mapper.insertCounter(counter);
			} else {
				// 如果有相同code的counter,原counter的current+1后更新
				int current = counter.getCurrent();
				counter.setCurrent(current + 1);
				mapper.updateCounter(counter);

				// 保存新的counter
				String supplement = convertor.generateCode(current);
				String fillCode   = counter.getCode() + supplement;
				counter = new Counter();
				counter.setMd5(md5);
				counter.setCode(fillCode);
				counter.setUrl(url);
				mapper.insertCounter(counter);
			}

			session.commit(true);

			return counter;
		}
	}
}