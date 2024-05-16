package org.cobra.models;

import com.itextpdf.kernel.colors.Color;

public class Library {

	String logoPath;
	String gradientPath;
	String font;
	Color main_background_color;

	public String getLogoPath() {
		return logoPath;
	}

	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}

	public String getGradientPath() {
		return gradientPath;
	}

	public void setGradientPath(String gradientPath) {
		this.gradientPath = gradientPath;
	}

	public String getFont() {
		return font;
	}

	public void setFont(String font) {
		this.font = font;
	}

	public Color getMain_background_color() {
		return main_background_color;
	}

	public void setMain_background_color(Color main_background_color) {
		this.main_background_color = main_background_color;
	}

	@Override
	public String toString() {
		return "Library [logoPath=" + logoPath + ", gradientPath=" + gradientPath + ", font=" + font
				+ ", main_background_color=" + main_background_color + "]";
	}

}
