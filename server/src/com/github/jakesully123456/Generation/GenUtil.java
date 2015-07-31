package com.github.jakesully123456.Generation;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;

public class GenUtil {
	
	/*
	 * 
	 * This is simply used to convert lat to the grid and long to the grid. It is also used for the absolute path which is given on run.
	 * 
	 */
	
	public static String absolutePath;
	public static String absolutePathWeb = "C:/wamp/www/";
	
    public static final double data_ax_v = 51.723685;
    public static final double data_ay_v = 0.426118;
    public static final double data_bx_v = 51.238917;
    public static final double data_by_v = -0.59728;
    ///
    public static final double data_xd_v = data_ax_v - data_bx_v;
    public static final double data_yd_v = data_ay_v - data_by_v;
    //
    public static final double data_x_unit = data_xd_v / 50000;
    public static final double data_y_unit = data_yd_v / 50000;

    public static double sixdp(double v) {
        return Math.round(v * 1000000) / 1000000;
    }

    public static double latTOgr(double v) {
        return sixdp((v - data_bx_v) / data_x_unit);
    }
    public static double longTOgr(double v) {
        return sixdp((v - data_by_v) / data_y_unit);
    }
    public static double grTOlat(double v) {
        return data_bx_v + ( sixdp(v) * data_x_unit);
    }
    public static double grTOlong(double v) {
        return data_by_v + ( sixdp(v) * data_y_unit);
    }

    
    public static void setAbsolutePath(String absolutePath) {
    	GenUtil.absolutePath = absolutePath;
    }
    
    public static BufferedImage imageToBufferedImage(Image image) {

    	BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
    	Graphics2D g2 = bufferedImage.createGraphics();
    	g2.drawImage(image, 0, 0, null);
    	g2.dispose();

    	return bufferedImage;

    }

    public static Image makeColorTransparent(BufferedImage im, final Color color) {
    	ImageFilter filter = new RGBImageFilter() {

    		// the color we are looking for... Alpha bits are set to opaque
    		public int markerRGB = color.getRGB() | 0xFF000000;

    		public final int filterRGB(int x, int y, int rgb) {
    			if ((rgb | 0xFF000000) == markerRGB) {
    				// Mark the alpha bits as zero - transparent
    				return 0x00FFFFFF & rgb;
    			} else {
    				// nothing to do
    				return rgb;
    			}
    		}
    	};

    	ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
    	return Toolkit.getDefaultToolkit().createImage(ip);
    }
}
