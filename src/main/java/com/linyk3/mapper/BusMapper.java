package com.linyk3.mapper;

import org.springframework.stereotype.Repository;

import com.linyk3.bean.Bus;

@Repository("busMapper")
public interface BusMapper {

	public Bus queryBus(String line);

	public void updateBus(Bus bustmp);

}
