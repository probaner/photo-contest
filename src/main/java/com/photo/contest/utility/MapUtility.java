package com.photo.contest.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MapUtility {

	public List<Integer> getKey(Map<Integer, Integer> map, Integer value) {
		List<Integer> list = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (value.equals(entry.getValue())) {
				list.add(entry.getKey());				
			}
		}
		return list;
	}
	
}
