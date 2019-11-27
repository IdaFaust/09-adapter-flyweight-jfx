package de.thro.inf.prg3.a09.resource;

import javafx.scene.image.Image;

public class FxImageLoaderAdapter {
	private ResourceLoader<Image> resourceLoader;

	public FxImageLoaderAdapter(ResourceLoader<Image> rl){
		this.resourceLoader = rl;
	}

	public Image loadImage(String resourcePath){
		Image image = resourceLoader.loadResource(ClassLoader.getSystemClassLoader(),resourcePath);
		return image;
	}

	public Image loadImage(ClassLoader resourceContext, String resourcePath){
		Image image = resourceLoader.loadResource(resourceContext,resourcePath);
		return image;
	}
}
