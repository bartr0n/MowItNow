package fr.mowitnow.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Lawn {

	private Position boundaries;

	public boolean isOutOfBoundaries(Position position) {

		// TODO classe Range?
		return position.getX() < 0 || position.getX() > boundaries.getX() || position.getY() < 0
				|| position.getY() > boundaries.getY();
	}
}
