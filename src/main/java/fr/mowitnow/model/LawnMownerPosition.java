package fr.mowitnow.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class LawnMownerPosition {

	private Position position;
	private Orientation orientation;

	public LawnMownerPosition() {
		this.position = new Position(0, 0);
		this.orientation = Orientation.N;
	}

	public LawnMownerPosition(LawnMownerPosition source) {

		this.position = new Position(source.getPosition().getX(), source.getPosition().getY());
		this.orientation = source.orientation;
	}

	@Override
	public String toString() {
		return String.format("%d, %d, %s", this.position.getX(), this.position.getY(), orientation);
	}
}
