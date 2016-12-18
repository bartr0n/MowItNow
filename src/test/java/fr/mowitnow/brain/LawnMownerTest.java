package fr.mowitnow.brain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import fr.mowitnow.model.Lawn;
import fr.mowitnow.model.LawnMower;
import fr.mowitnow.model.LawnMownerBrain;
import fr.mowitnow.model.LawnMownerPosition;
import fr.mowitnow.model.Orientation;
import fr.mowitnow.model.Position;

public class LawnMownerTest {

	private LawnMower lawnMowner;

	@Before
	public void setUp() {
		LawnMownerBrain brain = new LawnMownerBrain();
		brain.setLawn(new Lawn(5, 5));

		lawnMowner = new LawnMower(brain);
	}

	@Test
	public void lawnMownerTest1() {

		lawnMowner.init(new LawnMownerPosition(new Position(1, 2), Orientation.N));
		LawnMownerPosition finalPosition = lawnMowner.execute("GAGAGAGAA");

		assertNotNull("finalPosition is null", finalPosition);
		assertEquals("Wrong orientation", Orientation.N, finalPosition.getOrientation());
		assertEquals("Wrong X coordinate", Integer.valueOf(1), finalPosition.getPosition().getX());
		assertEquals("Wrong Y coordinate", Integer.valueOf(3), finalPosition.getPosition().getY());
	}

	@Test
	public void lawnMownerTest2() {

		lawnMowner.init(new LawnMownerPosition(new Position(3, 3), Orientation.E));
		LawnMownerPosition finalPosition = lawnMowner.execute("AADAADADDA");

		assertNotNull("finalPosition is null", finalPosition);
		assertEquals("Wrong orientation", Orientation.E, finalPosition.getOrientation());
		assertEquals("Wrong X coordinate", Integer.valueOf(5), finalPosition.getPosition().getX());
		assertEquals("Wrong Y coordinate", Integer.valueOf(1), finalPosition.getPosition().getY());
	}
}
