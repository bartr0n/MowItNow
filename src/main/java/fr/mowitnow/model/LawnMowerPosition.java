package fr.mowitnow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LawnMowerPosition {

	private Coordinates coordinates;
	private Orientation orientation;

	public LawnMowerPosition() {
		this.coordinates = new Coordinates(0, 0);
		this.orientation = Orientation.N;
	}

	public LawnMowerPosition(LawnMowerPosition source) {

		this.coordinates = new Coordinates(source.getCoordinates().getX(), source.getCoordinates().getY());
		this.orientation = source.orientation;
	}

	@Override
	public String toString() {
		return String.format("%d, %d, %s", this.coordinates.getX(), this.coordinates.getY(), orientation);
	}
}
