package fr.mowitnow.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LawnMower {

	private LawnMownerBrain brain;

	public void init(LawnMownerPosition initialPosition) {
		brain.setCurrentPosition(initialPosition);
	}

	public LawnMownerPosition execute(String commands) {

		commands.chars().forEach(x -> brain.move(Action.valueOf(new Character((char) x).toString())));

		return brain.getCurrentPosition();
	}

}
