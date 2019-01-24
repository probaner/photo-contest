package com.photo.contest.utility;

import java.io.File;
import java.io.FilenameFilter;

import org.springframework.stereotype.Component;

@Component
public class FileCheckUtility {
	
	private static String fileType=null;
	
	public static void setFileType(String fileType) {
		FileCheckUtility.fileType = fileType;
	}

	public String  getOs() {
		return System.getProperty("os.name");
	}
	
	public boolean  isExist(String path) {
		
		if(new File(path).exists())
		   return true;
		else
			return false;		
	}
	
	public boolean  isDir(String path) {
		if(new File(path).isDirectory())
			   return true;
			else
				return false;
	}
	
	public boolean  isFile(String path) {
		if(new File(path).isFile())
			   return true;
			else
				return false;
	}
	
	
	public boolean createDir(String path) {
		
		try{
			 return new File(path).mkdir(); 			
	       } 
	    catch(SecurityException se){
	           return false;
	         } 
	}
	
	public File[] getFileArrayOfaDirectory(String path, String type){		
		
		File dir = new File(path);
		setFileType(type);
		File[] files = dir.listFiles(typeFilter);
		return files;
		
	}
	
	FilenameFilter typeFilter = new FilenameFilter() {
	    public boolean accept(File file, String name) {
	    
	        if (name.endsWith(fileType)) {	            
	            return true;
	           } else {
	                   return false;
	                  }
	    }
	};
	
	
}
