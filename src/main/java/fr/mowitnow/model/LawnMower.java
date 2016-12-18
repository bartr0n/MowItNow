package fr.mowitnow.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LawnMower {

	private LawnMowerBrain brain;

	public void init(LawnMowerPosition initialPosition) {
		brain.setCurrentPosition(initialPosition);
	}

	public LawnMowerPosition execute(String commands) {

		commands.chars().forEach(x -> brain.move(Action.valueOf(new Character((char) x).toString())));

		return brain.getCurrentPosition();
	}

}
