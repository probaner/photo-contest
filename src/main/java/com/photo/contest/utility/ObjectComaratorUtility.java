package com.photo.contest.utility;

import java.util.Comparator;

import org.springframework.stereotype.Component;

import com.photo.contest.dto.DisplayReatingImageDTO;

@Component
public class ObjectComaratorUtility implements Comparator<DisplayReatingImageDTO> {

	
	@Override
	public int compare(DisplayReatingImageDTO o1, DisplayReatingImageDTO o2) {
		// TODO Auto-generated method stub
		return new Integer(o1.getReating()).compareTo(o2.getReating());
	}

	
	

}
