package com.photo.contest.utility;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Component;

@Component
public class ImageResizeUtility {
	
	public void imazeResize(String sourceFile, String destinationFile, int with)  {
		
		
		Image img = null;
		BufferedImage tempJPG = null;
		File newFileJPG = null;
		
		
		if(new File(sourceFile).exists()) {
	
		   try {
			img = ImageIO.read(new File(sourceFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 //tempJPG = resizeImage(img, 100, 100);
		 double aspectRatio = (double) img.getWidth(null)/(double) img.getHeight(null);
		 tempJPG = resizeImage(img, with, (int) (with/aspectRatio));
		 newFileJPG = new File(destinationFile);
		 try {
			ImageIO.write(tempJPG, "jpg", newFileJPG);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	    }
	}
	
	public BufferedImage resizeImage(final Image image, int width, int height) {
        final BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        final Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setComposite(AlphaComposite.Src);
        //below three lines are for RenderingHints for better image quality at cost of higher processing time
        graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2D.setRenderingHint(RenderingHints.KEY_RENDERING,RenderingHints.VALUE_RENDER_QUALITY);
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        graphics2D.drawImage(image, 0, 0, width, height, null);
        graphics2D.dispose();
        return bufferedImage;
    }
	

}
