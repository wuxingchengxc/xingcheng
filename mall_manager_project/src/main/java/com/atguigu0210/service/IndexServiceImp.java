package com.atguigu0210.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu0210.mapper.IndexMapper;

@Service
public class IndexServiceImp implements IndexServiceInf {

	@Autowired
	IndexMapper indexMapper;

	@Override
	public int test() {
		int select_test = indexMapper.select_test();
		return select_test;
	}

}
