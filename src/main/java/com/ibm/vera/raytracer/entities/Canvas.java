package com.ibm.vera.raytracer.entities;

import java.util.Arrays;

import com.ibm.vera.raytracer.helpers.Helper;

public class Canvas {
	
	private int width, height;
	private Colour[][] pixels;
	
	public Canvas(int width, int height) {
		this.width = width;
		this.height = height;
		this.pixels = new Colour[height][width];
		
		for (Colour[] p : pixels) {
	        Arrays.fill(p, new Colour(0, 0, 0));
	    }
	}

	public Colour[][] getPixels() {
		return pixels;
	}

	public void setPixels(Colour[][] pixels) {
		this.pixels = pixels;
	}

	public void writePixel(int col, int row, Colour colour) {
		pixels[row][col] = colour;		
	}
	
	public Colour pixelAt (int col, int row) {
		return pixels[row][col];
	}
	
	public String toPPM() {
		
		StringBuilder builder = new StringBuilder();
		builder.append("P3\n");
		builder.append(width).append(" ").append(height).append("\n");
		builder.append("255\n");
		
		for (Colour[] row : pixels) {
			String line = "";
			for (Colour col : row) {
				if(line.length() + Integer.toString(Helper.clamp((int) Math.round(col.getX() * 255), 0, 255)).length() > 70) {
					builder.append(line.trim()).append('\n');
					line = "";
				}
				line += Helper.clamp((int) Math.round(col.getX() * 255), 0, 255);
				line += " ";
				if(line.length() + Integer.toString(Helper.clamp((int) Math.round(col.getY() * 255), 0, 255)).length() > 70) {
					builder.append(line.trim()).append('\n');
					line = "";
				}
				line += Helper.clamp((int) Math.round(col.getY() * 255), 0, 255);
				line += " ";
				if(line.length() + Integer.toString(Helper.clamp((int) Math.round(col.getZ() * 255), 0, 255)).length() > 70) {
					builder.append(line.trim()).append('\n');
					line = "";
				}
				line += Helper.clamp((int) Math.round(col.getZ() * 255), 0, 255);
				line += " ";
			}
			builder.append(line.trim()).append('\n');
		}
		
		return builder.toString();
	}

	@Override
	public String toString() {
		String result = "Canvas [";
		for (Colour[] row : pixels) {
			result += "[ Colours=[";
			for (Colour c : row) {
				result += " Colour=[ "+c.getX()+" "+c.getY()+" "+c.getZ()+" ],";
			}
			result += "]\n";
		}
		result += " ]";
		return result;
	}
	
}
