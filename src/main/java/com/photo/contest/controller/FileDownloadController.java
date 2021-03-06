package com.photo.contest.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.photo.contest.config.ConfigProperty;

@Controller

public class FileDownloadController {
	
	
	@Autowired
	ConfigProperty configProperty;
	
	private static final String EXTERNAL_FILE_PATH="D:\\test\\PAYMENT.pdf";
	//private static final String INTERNAL_FILE="irregular-verbs-list.pdf";
	
	
	
	@RequestMapping("/getDownload")
	public String viewLogin(Map<String, Object> model) throws IOException {
			
		
		model.put("titel",configProperty.getIndexName());
		model.put("titelImage",configProperty.getIndexImage());
		model.put("headerLeft",configProperty.getHeaderLeft());
		model.put("headerMiddle",configProperty.getHeaderMiddle());
		model.put("headerRight",configProperty.getHeaderRight());
		
		return "download";		
	  }
	
	
	
	 @RequestMapping(value="/download/{type}", method = RequestMethod.GET)
	    public void downloadFile(HttpServletResponse response, @PathVariable("type") String type) throws IOException {
		 
		 File file = null;
		 
		 /*if(type.equalsIgnoreCase("internal")){
	            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
	            file = new File(classloader.getResource(INTERNAL_FILE).getFile());
	        }else{*/
	              file = new File(EXTERNAL_FILE_PATH);
	             //}
		 
		 if(!file.exists()){
	            String errorMessage = "Sorry. The file you are looking for does not exist";
	            System.out.println(errorMessage);
	            OutputStream outputStream = response.getOutputStream();
	            outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
	            outputStream.close();
	            return;
	        }
		 
		 String mimeType= URLConnection.guessContentTypeFromName(file.getName());
	        if(mimeType==null){
	            System.out.println("mimetype is not detectable, will take default");
	            mimeType = "application/octet-stream";
	        }
	        
	        response.setContentType(mimeType);
	         
	        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
	            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
	        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));   
		 	        
	        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
	        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
	         
	        response.setContentLength((int)file.length());	 
	        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
	 
	        //Copy bytes from source to destination(outputstream in this example), closes both streams.
	        FileCopyUtils.copy(inputStream, response.getOutputStream());
	 }
	     

}
