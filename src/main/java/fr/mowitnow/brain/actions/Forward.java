package fr.mowitnow.brain.actions;

import fr.mowitnow.model.LawnMowerPosition;

public class Forward implements ActionHandler {

	private final static Integer OFFSET = 1;

	public void execute(LawnMowerPosition position) {

		switch (position.getOrientation()) {
		case N:
			position.getCoordinates().setY(position.getCoordinates().getY() + OFFSET);
			break;
		case S:
			position.getCoordinates().setY(position.getCoordinates().getY() - OFFSET);
			break;
		case E:
			position.getCoordinates().setX(position.getCoordinates().getX() + OFFSET);
			break;
		default:
			position.getCoordinates().setX(position.getCoordinates().getX() - OFFSET);
		}
	}
}
