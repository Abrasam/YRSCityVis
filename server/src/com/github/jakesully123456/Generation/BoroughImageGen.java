package com.github.jakesully123456.Generation;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BoroughImageGen {

	public BoroughImageGen(boolean fire) {
		if (fire) {
			BoroughGen gen = new BoroughGen();
			FireGen fireGen = new FireGen(gen);
			BufferedImage image = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
			int average = -1;
			for (int i : fireGen.fires.values()) {
				average += i;
			}
			average = Math.round(average/(float)(fireGen.fires.values().size() + 1));
			for (int x = 0; x < 500; x ++) {
				for (int y = 0; y < 500; y ++) {
					Color col = getFireRGB(fireGen, gen, average, x, y);
					image.setRGB(col.getRed(), col.getGreen(), col.getBlue());
				}
			}
			try {
				ImageIO.write(image, "png", new File(GenUtil.absolutePath + "fires.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private Color getFireRGB(FireGen fg, BoroughGen bg, int avg, int x, int y) {
		return (fg.fires.get(bg.getBorough(x, y)) < avg ? new Color(0, 255, 0) :  (avg == fg.fires.get(bg.getBorough(x, y)) ? new Color(255, 165, 0) : new Color(255, 0, 0)));
	}
}
