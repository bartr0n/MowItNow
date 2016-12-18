package fr.mowitnow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LawnMowerPosition {

	private Coordinates position;
	private Orientation orientation;

	public LawnMowerPosition() {
		this.position = new Coordinates(0, 0);
		this.orientation = Orientation.N;
	}

	public LawnMowerPosition(LawnMowerPosition source) {

		this.position = new Coordinates(source.getPosition().getX(), source.getPosition().getY());
		this.orientation = source.orientation;
	}

	@Override
	public String toString() {
		return String.format("%d, %d, %s", this.position.getX(), this.position.getY(), orientation);
	}
}
