package de.thro.inf.prg3.a09.model;

import de.thro.inf.prg3.a09.model.empire.TieBomber;
import de.thro.inf.prg3.a09.model.empire.TieFighter;
import de.thro.inf.prg3.a09.model.empire.TieInterceptor;
import de.thro.inf.prg3.a09.resource.FxImageLoaderAdapter;
import de.thro.inf.prg3.a09.resource.ResourceLoader;
import de.thro.inf.prg3.a09.util.NameGenerator;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Factory to create new fighters
 * Creates random fighters
 *
 * @author Peter Kurfer
 */
public final class FighterFactory {

	private static final int NumberOfKnownFighterTypes = 6;
	private final Random random;
	private final NameGenerator nameGenerator;
	private final ResourceLoader<Image> imageResourceLoader;
	private Map<String,Fighter> fightermap = new HashMap<>();
	private String [] paths ={"fighter/awing.jpg","fighter/xwing.jpg","fighter/ywing.jpg","fighter/tiebomber.jpg","fighter/tiefighter.jpg","fieghter/tieinterceptor.jpg"};

	private FxImageLoaderAdapter fAdapter;

	public FighterFactory() {
		nameGenerator = new NameGenerator();
		random = new Random();
		imageResourceLoader = new ResourceLoader<>(Image::new);
		fAdapter = new FxImageLoaderAdapter(imageResourceLoader);
	}

	Fighter getFighter(String path){

		if(fightermap.containsKey(path)){
			return fightermap.get(path);
		}
		Fighter fg = new Fighter(nameGenerator.generateName(), fAdapter.loadImage(path));
		fightermap.put(path, fg);
		return fg;
	}

	/**
	 * Create a random Fighter
	 *
	 * @implNote the method has an implementation flaw because it always loads the fighters image
	 * @return a new Fighter instance
	 */
	public Fighter createFighter() {
		int v = random.nextInt(NumberOfKnownFighterTypes);
		String path = paths[v];

		return getFighter(path);

	}
}
