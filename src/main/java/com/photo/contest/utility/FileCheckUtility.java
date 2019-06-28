package com.photo.contest.utility;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
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
	
	public void deleteDirectory(String destination) {
		try {
			 if(isExist(destination)) {			
			                           FileUtils.deleteDirectory(new File(destination));
			                          }
		    } catch (IOException e) {
			                          // TODO Auto-generated catch block
			                          e.printStackTrace();
		                            }
	}
	
	public String convertBase64String(File file) throws IOException{
	    byte[] fileContent = FileUtils.readFileToByteArray(file);
		String encodedString = Base64.getEncoder().encodeToString(fileContent);
		return encodedString;
		
		
	}
	
	
	public void fileMove(String sourceDir, String destinationDir, String fileName) throws IOException{
		if(isExist(sourceDir) ){
			if(!isExist(destinationDir)){
				createDir(destinationDir);
			  }
			Files.move 
			        (Paths.get(sourceDir+"/"+fileName),  
			        Paths.get(destinationDir+"/"+fileName));
		  }	
	}
	
	
		
	public void fileCopy(String sourceDir, String destinationDir, String fileName){
			
		if(isExist(sourceDir) ){
			if(!isExist(destinationDir)){				
			   createMultilavelDir(destinationDir);
				System.out.println("new dir created"+destinationDir);
			} 
			try {
				Files.copy
				        (new File(sourceDir+"/"+fileName).toPath(),  
				        new File(destinationDir+"/"+fileName).toPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }	
	}
	
	public Integer fileCount(String path){
		if(isExist(path) ){
		 return new File(path).listFiles().length;
		}
		return 0;		
	}
	
	public void createMultilavelDir(String path){
		
		StringBuilder sb = new StringBuilder();
		String[] arr=path.split("/");
		for(int i=0; i<arr.length; i++){
			if(i==0)
			   sb=sb.append(arr[i]);
			else{
				 sb=sb.append("/"+arr[i]);
				 if(!isExist(sb.toString()))
					 createDir(sb.toString());
			    }
			
			//System.out.println(sb);
		
		}
		
	}
	
	public void fileRename(String path, String name, String newName){
		File file = new File(path+"/"+name);
		file.renameTo(new File(path+"/"+newName));
		
	}
	
	
}
