package de.thro.inf.prg3.a09.model;

import javafx.scene.image.Image;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author Peter Kurfer
 */

public class Fighter {

	private final String pilot;
	private final Image fighterImage;
	private String type;
	private Force side;

	public Fighter(String pilot, Image fighterImage) {
		this.pilot = pilot;
		this.fighterImage = fighterImage;
	}
	public Fighter(String pilot, Image fighterImage, String type, Force side) {
		this.pilot = pilot;
		this.fighterImage = fighterImage;
		this.type = type;
		this.side = side;
	}


	public String getPilot() {
		return pilot;
	}

	public Image getFighterImage() {
		return fighterImage;
	}

	public Force getSideOfForce(){
		return side;

	}
	public String getFighterType() {
		return type;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;

		if (!(o instanceof Fighter)) return false;

		Fighter fighter = (Fighter) o;

		return new EqualsBuilder()
			.append(getPilot(), fighter.getPilot())
			.append(getFighterType(), fighter.getFighterType())
			.isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 37)
			.append(getPilot())
			.append(getFighterType())
			.toHashCode();
	}
}
