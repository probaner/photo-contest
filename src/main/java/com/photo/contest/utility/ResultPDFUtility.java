package com.photo.contest.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.photo.contest.config.ConfigProperty;

@Component
public class ResultPDFUtility {
	
	@Autowired
	ConfigProperty configProperty;
	
	
	
	//public  String DEST = ;
	
	 public void mainC(String id, String name) throws IOException, DocumentException {		  
		    System.out.println(configProperty.getResultDest());
	        File file = new File(configProperty.getResultDest()+id+".pdf");
	        file.getParentFile().mkdirs();
	        Rectangle pagesize = PageSize.A4;
	        createPdf(configProperty.getResultDest()+id+".pdf", pagesize, id, name);		        
         }
	 
	 
	 public void createPdf(String filename, Rectangle pagesize,String id, String name) throws IOException, DocumentException {
	        Document document = new Document(pagesize);
	        PdfWriter writer =  PdfWriter.getInstance(document, new FileOutputStream(filename));
	        document.open();
	        
	        //add border
	        Rectangle rect= new Rectangle(577,825,18,15);
	        rect.enableBorderSide(1);
	        rect.enableBorderSide(2);
	        rect.enableBorderSide(4);
	        rect.enableBorderSide(8);
	        rect.setBorderColor(BaseColor.BLACK);
	        rect.setBorderWidth(1);
	        
	        Paragraph header = new Paragraph(configProperty.getSalonName(), fontFactory(16, "bold"));
	        header.setAlignment(Element.ALIGN_CENTER);
	        Paragraph patronage = new Paragraph(configProperty.getSalonPatronage(), fontFactory(8, "bold"));
	        patronage.setAlignment(Element.ALIGN_RIGHT);
	        patronage.setSpacingBefore(2f);
	        patronage.setSpacingAfter(6f);
	        
	        
	        document.add(rect);
	        document.add(header);
	        document.add(patronage);	
	        document.add(new LineSeparator());
	        document.add(authorDetails(name, id));
	        //document.add(clubDetails());
	       // document.add(new DottedLineSeparator());
	        
	        document.close();
	 }
	

	 public Font fontFactory( int size, String fontStyle) {
		 Font font =null;
		 if(fontStyle.equals("bold"))
		    font  = FontFactory.getFont(FontFactory.HELVETICA, size, Font.BOLD);
		 else if(fontStyle.equals("normal")) 
			 font  = FontFactory.getFont(FontFactory.HELVETICA, size, Font.NORMAL);
		 
		 return font;
		 
	 }
	 
	 public Paragraph authorDetails(String name, String id) {		 		 
		 Paragraph authorName = new Paragraph("Author ID: "+id+"\n Author Name : "+name.toUpperCase()+"\n Result Date: "+configProperty.getResultDate(), fontFactory(10, "normal"));		 
		 authorName.setSpacingBefore(2f);
		 authorName.setSpacingAfter(2f);
		 return authorName;
	 }
	 
	 
}
