package com.linyk3.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.linyk3.bean.Line;

@Repository("lineMapper")
public interface LineMapper {
	public List<Line> queryLine(String line);
}
