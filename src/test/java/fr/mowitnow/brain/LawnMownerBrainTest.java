package fr.mowitnow.brain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import fr.mowitnow.model.Action;
import fr.mowitnow.model.Lawn;
import fr.mowitnow.model.LawnMowerBrain;
import fr.mowitnow.model.LawnMowerPosition;
import fr.mowitnow.model.Orientation;

public class LawnMownerBrainTest {

	private LawnMowerBrain brain;

	@Before
	public void setUp() {
		brain = new LawnMowerBrain();
		brain.setLawn(new Lawn(3, 3));
		brain.setCurrentPosition(new LawnMowerPosition());
	}

	@Test
	public void lawnMownerTest() {

		executeInstructions("AAAA");

		LawnMowerPosition finalPosition = brain.getCurrentPosition();
		assertEquals("Wrong direction", Orientation.N, finalPosition.getOrientation());
		assertEquals("Wrong X position", Integer.valueOf(0), finalPosition.getCoordinates().getX());
		assertEquals("Wrong Y position", Integer.valueOf(3), finalPosition.getCoordinates().getY());
	}

	@Test
	public void lawnMownerTest2() {

		executeInstructions("AAAAAA");

		LawnMowerPosition finalPosition = brain.getCurrentPosition();
		assertEquals("Wrong direction", Orientation.N, finalPosition.getOrientation());
		assertEquals("Wrong X position", Integer.valueOf(0), finalPosition.getCoordinates().getX());
		assertEquals("Wrong Y position", Integer.valueOf(3), finalPosition.getCoordinates().getY());
	}

	@Test
	public void lawnMownerTest3() {

		executeInstructions("GA");

		LawnMowerPosition finalPosition = brain.getCurrentPosition();
		assertEquals("Wrong direction", Orientation.W, finalPosition.getOrientation());
		assertEquals("Wrong X position", Integer.valueOf(0), finalPosition.getCoordinates().getX());
		assertEquals("Wrong Y position", Integer.valueOf(0), finalPosition.getCoordinates().getY());
	}

	@Test
	public void lawnMownerTest4() {

		executeInstructions("GAD");

		LawnMowerPosition finalPosition = brain.getCurrentPosition();
		assertEquals("Wrong direction", Orientation.N, finalPosition.getOrientation());
		assertEquals("Wrong X position", Integer.valueOf(0), finalPosition.getCoordinates().getX());
		assertEquals("Wrong Y position", Integer.valueOf(0), finalPosition.getCoordinates().getY());
	}

	@Test(expected = IllegalArgumentException.class)
	public void lawnMownerTestWrongActionType() {

		executeInstructions("GAF");
		fail("Exception not throwed");
	}

	private void executeInstructions(String commands) {

		commands.chars().forEach(x -> brain.move(Action.valueOf(new Character((char) x).toString())));
	}
}
