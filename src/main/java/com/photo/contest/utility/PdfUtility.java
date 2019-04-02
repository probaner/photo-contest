package com.photo.contest.utility;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;

@Component
public class PdfUtility {
	
	
	
	public void createpdf(TreeMap<String, String> userDataMap, TreeMap<String , TreeMap<String, TreeMap<String , String>>> resultMap) throws DocumentException {
		
    Rectangle pageSize = new Rectangle(PageSize.A4);
    Document document = new Document( pageSize );

	      try
	      {
	    	  System.out.println(userDataMap.get("fileName"));
	          PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(userDataMap.get("fileName")));
	         document.open();
	        	         
	         //add border
		       /* Rectangle rect= new Rectangle(577,825,18,15);
		        rect.enableBorderSide(1);
		        rect.enableBorderSide(2);
		        rect.enableBorderSide(4);
		        rect.enableBorderSide(8);
		        rect.setBorderColor(BaseColor.BLACK);
		        rect.setBorderWidth(1);
		        document.add(rect);*/
		        
		        Paragraph header = new Paragraph(userDataMap.get("saloneName"), fontFactory(16, "bold"));
		        header.setAlignment(Element.ALIGN_CENTER);
		        document.add(header);
		        
		        Paragraph patronage = new Paragraph(userDataMap.get("patronage"), fontFactory(8, "bold"));
		        patronage.setAlignment(Element.ALIGN_RIGHT);
		        patronage.setSpacingBefore(2f);
		        patronage.setSpacingAfter(6f);
		        document.add(patronage);
		        
		        document.add(new LineSeparator());
		        Paragraph authorName = new Paragraph("Author ID: "+userDataMap.get("userId")+
		        		                              "\n Author Name : "+userDataMap.get("name")+
		        		                              "\n Result Date: "+userDataMap.get("resultDate"), fontFactory(8, "normal"));		 
				authorName.setSpacingBefore(2f);
				authorName.setSpacingAfter(2f);			
				document.add(authorName);
				
				
				for (Entry<String , TreeMap<String, TreeMap<String , String>>> entry : resultMap.entrySet()) {
					
					 Paragraph club = new Paragraph(entry.getKey().toUpperCase(), fontFactory(12,"bold")); // add club name
					 club.setAlignment(Element.ALIGN_CENTER);
					 club.setSpacingAfter(6f);                     					
					 document.add(club);
		             //document.add(new DottedLineSeparator());
		             
		             for(Entry<String, TreeMap<String , String>> categoryMap : entry.getValue().entrySet()) {
		            	 
		            	 PdfPTable table = new PdfPTable(4);
		         		 table.setSpacingBefore(20f);
		         		 table.setTotalWidth(200);
		         		
		         		 PdfPCell cell;
		         	        Paragraph section =new Paragraph(categoryMap.getKey(),fontFactory(8,"bold"));
		         	        cell = new PdfPCell(section);
		         	        cell.setVerticalAlignment(Element.ALIGN_CENTER);
		         	        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		         	        
		         	        table.getDefaultCell().setPadding(2);
		         	        table.getDefaultCell().setPaddingLeft(34);
		         	        cell.setColspan(4);
		         	        cell.setPaddingLeft(40);
		         	        cell.setFixedHeight(25);
		         	        table.addCell(cell);
		         	        
		         	       table.addCell(getParagraph("Title",8,"normal"));
		       	           table.addCell(getParagraph("Score",8,"normal"));
		       	           table.addCell(getParagraph("Accept",8,"normal"));
		       	           table.addCell(getParagraph("Not Accept",8,"normal"));
		         	        
		         	    for(Entry<String , String> imageMap : categoryMap.getValue().entrySet()) {
		         	    	 
		         	    	   table.addCell(getParagraph(imageMap.getKey(),8,"normal"));
		         	    	   if(imageMap.getValue()!=null) {
			       	               table.addCell(getParagraph(imageMap.getValue().substring(imageMap.getValue().indexOf("|")+1,imageMap.getValue().length()),8,"normal"));
			       	               if(imageMap.getValue().startsWith("Accept")) {
			       	                  table.addCell(getParagraph("*",8,"normal"));
			       	                  table.addCell(getParagraph("",8,"normal"));
			       	                 }
			       	               else {
			       	            	     table.addCell(getParagraph("",8,"normal"));
			       	                     table.addCell(getParagraph("*",8,"normal"));
			       	                    }
		         	    	     }
		         	    	   else {
		         	    		      table.addCell(getParagraph("Cancel",8,"normal"));  	   
			       	                  table.addCell(getParagraph("NA",8,"normal"));
			       	                  table.addCell(getParagraph("NA",8,"normal"));
		         	    	        }
		         	    	//System.out.println(imageMap);   
		         	       }
		         	        
		         	       if(categoryMap.getValue().entrySet().size()< 4) {
		         	    	   for(int i=0; i <4-categoryMap.getValue().entrySet().size(); i++) {
		         	    		    table.addCell(getParagraph("-",8,"normal"));
		         	    		    table.addCell(getParagraph("-",8,"normal"));
		         	    		    table.addCell(getParagraph("-",8,"normal"));
		         	    		    table.addCell(getParagraph("-",8,"normal"));
		         	    	      }
		         	         }
		         	    
		         	          document.add(table);
		            	 
		                }
		             
		             document.add( Chunk.NEWLINE );
		             document.add( Chunk.NEWLINE );
					
				    }
		      
		     
	         document.close();
	         writer.close();
	      } catch (DocumentException e)
	      {
	         e.printStackTrace();
	      } catch (FileNotFoundException e)
	      {
	         e.printStackTrace();
	      }
	      
	      
	      
	      // add water mark
	       /* try {
	        	  PdfReader pdfReader = new PdfReader("C:/Users/143741/Desktop/test image/pdf/Result.pdf");
	        	  int number_of_pages = pdfReader.getNumberOfPages();
	        	  int i = 0;
				
	        	  PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream("C:/Users/143741/Desktop/test image/pdf/NEWResult.pdf"));
					Image watermark_image = Image.getInstance("C:/Users/143741/Desktop/test image/pdf/japanese.jpeg");
		            watermark_image.setAbsolutePosition(10, 250);
		            PdfContentByte add_watermark;            
		            while (i < number_of_pages) {
		              i++;
		              add_watermark = pdfStamper.getUnderContent(i);
		              add_watermark.addImage(watermark_image);
		            }
		            pdfStamper.close();
				
	        
	              pdfStamper.close();
	        	  
			    } catch (MalformedURLException e) {
				                                    // TODO Auto-generated catch block
				                                    e.printStackTrace();
			     } catch (IOException e) {
				                            // TODO Auto-generated catch block
				                            e.printStackTrace();
			                             }*/
	        
		
	}
	
	
	public Font fontFactory( int size, String fontStyle) {
		 Font font =null;
		 if(fontStyle.equals("bold"))
		    font  = FontFactory.getFont(FontFactory.COURIER, size, Font.BOLD);
		 else if(fontStyle.equals("normal")) 
			 font  = FontFactory.getFont(FontFactory.COURIER, size, Font.NORMAL);
		 
		 return font;
		 
	 }
	
	public Paragraph getParagraph(String s, int fontSize, String type) {
		Paragraph paragraph = new Paragraph(s, fontFactory(fontSize,type));
		paragraph.setAlignment(Element.ALIGN_CENTER);
		return paragraph;
		
	}
	
	/*public PdfPTable  pdfTable(String category) throws DocumentException {
		
		PdfPTable table = new PdfPTable(4);
		table.setSpacingBefore(20f);
		table.setTotalWidth(200);
		
		 PdfPCell cell;
	        Paragraph section =new Paragraph(category.toUpperCase(),fontFactory(8,"bold"));
	        cell = new PdfPCell(section);
	        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
	        cell.setHorizontalAlignment(Element.ALIGN_MIDDLE);
	        
	        table.getDefaultCell().setPadding(2);
	        table.getDefaultCell().setPaddingLeft(24);
	        cell.setColspan(4);
	        cell.setPaddingLeft(170);
	        cell.setFixedHeight(25);
	        table.addCell(cell);
	        
		
	        return table;
		
	}*/
	

}
