package fr.mowitnow.brain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import fr.mowitnow.model.Action;
import fr.mowitnow.model.Lawn;
import fr.mowitnow.model.LawnMownerBrain;
import fr.mowitnow.model.LawnMownerPosition;
import fr.mowitnow.model.Orientation;
import fr.mowitnow.model.Position;

public class LawnMownerBrainTest {

	private LawnMownerBrain brain;

	@Before
	public void setUp() {
		brain = new LawnMownerBrain();
		brain.setLawn(new Lawn(new Position(3, 3)));
		brain.setCurrentPosition(new LawnMownerPosition());
	}

	@Test
	public void lawnMownerTest() {

		executeInstructions("AAAA");

		LawnMownerPosition finalPosition = brain.getCurrentPosition();
		assertEquals("Wrong direction", Orientation.N, finalPosition.getOrientation());
		assertEquals("Wrong X position", Integer.valueOf(0), finalPosition.getPosition().getX());
		assertEquals("Wrong Y position", Integer.valueOf(3), finalPosition.getPosition().getY());
	}

	@Test
	public void lawnMownerTest2() {

		executeInstructions("AAAAAA");

		LawnMownerPosition finalPosition = brain.getCurrentPosition();
		assertEquals("Wrong direction", Orientation.N, finalPosition.getOrientation());
		assertEquals("Wrong X position", Integer.valueOf(0), finalPosition.getPosition().getX());
		assertEquals("Wrong Y position", Integer.valueOf(3), finalPosition.getPosition().getY());
	}

	@Test
	public void lawnMownerTest3() {

		executeInstructions("GA");

		LawnMownerPosition finalPosition = brain.getCurrentPosition();
		assertEquals("Wrong direction", Orientation.W, finalPosition.getOrientation());
		assertEquals("Wrong X position", Integer.valueOf(0), finalPosition.getPosition().getX());
		assertEquals("Wrong Y position", Integer.valueOf(0), finalPosition.getPosition().getY());
	}

	@Test
	public void lawnMownerTest4() {

		executeInstructions("GAD");

		LawnMownerPosition finalPosition = brain.getCurrentPosition();
		assertEquals("Wrong direction", Orientation.N, finalPosition.getOrientation());
		assertEquals("Wrong X position", Integer.valueOf(0), finalPosition.getPosition().getX());
		assertEquals("Wrong Y position", Integer.valueOf(0), finalPosition.getPosition().getY());
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
