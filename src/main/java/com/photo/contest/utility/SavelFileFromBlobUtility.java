package com.photo.contest.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;


@Component
public class SavelFileFromBlobUtility {
	
	@SuppressWarnings("resource")
	public void save(String basePath, byte b[]) {
		
		System.out.println("basePath: "+basePath);
		
		try {
			FileOutputStream fos= new FileOutputStream(new File(basePath));
			fos.write(b);
			fos.close();
		    } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
