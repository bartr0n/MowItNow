package fr.mowitnow.brain.actions;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import fr.mowitnow.brain.actions.ActionHandler;
import fr.mowitnow.brain.actions.Forward;
import fr.mowitnow.brain.actions.TurnLeft;
import fr.mowitnow.brain.actions.TurnRight;
import fr.mowitnow.model.LawnMowerPosition;
import fr.mowitnow.model.Orientation;

public class MoveTest {

	private LawnMowerPosition position;
	private ActionHandler leftHandler;
	private ActionHandler rightHandler;
	private ActionHandler forwardHandler;

	@Before
	public void setUp() {
		position = new LawnMowerPosition();

		leftHandler = new TurnLeft();
		rightHandler = new TurnRight();
		forwardHandler = new Forward();
	}

	@Test
	public void turnLeftTest() {

		leftHandler.execute(position);
		assertEquals("Wrong position", Orientation.W, position.getOrientation());

		leftHandler.execute(position);
		assertEquals("Wrong position", Orientation.S, position.getOrientation());

		leftHandler.execute(position);
		assertEquals("Wrong position", Orientation.E, position.getOrientation());

		leftHandler.execute(position);
		assertEquals("Wrong position", Orientation.N, position.getOrientation());
	}

	@Test
	public void turnRightTest() {

		rightHandler.execute(position);
		assertEquals("Wrong position", Orientation.E, position.getOrientation());

		rightHandler.execute(position);
		assertEquals("Wrong position", Orientation.S, position.getOrientation());

		rightHandler.execute(position);
		assertEquals("Wrong position", Orientation.W, position.getOrientation());

		rightHandler.execute(position);
		assertEquals("Wrong position", Orientation.N, position.getOrientation());
	}

	@Test
	public void turnLeftRightTest() {

		leftHandler.execute(position);
		assertEquals("Wrong position", Orientation.W, position.getOrientation());

		rightHandler.execute(position);
		assertEquals("Wrong position", Orientation.N, position.getOrientation());
	}

	@Test
	public void moveForwardTest() {

		forwardHandler.execute(position);
		assertEquals("Orientation changed", Orientation.N, position.getOrientation());

		assertEquals("Wrong X position", Integer.valueOf(0), position.getPosition().getX());
		assertEquals("Wrong Y position", Integer.valueOf(1), position.getPosition().getY());

		rightHandler.execute(position);

		forwardHandler.execute(position);
		assertEquals("Invalid orientation", Orientation.E, position.getOrientation());

		assertEquals("Wrong X position", Integer.valueOf(1), position.getPosition().getX());
		assertEquals("Wrong Y position", Integer.valueOf(1), position.getPosition().getY());

		rightHandler.execute(position);

		forwardHandler.execute(position);
		assertEquals("Invalid orientation", Orientation.S, position.getOrientation());

		assertEquals("Wrong X position", Integer.valueOf(1), position.getPosition().getX());
		assertEquals("Wrong Y position", Integer.valueOf(0), position.getPosition().getY());

		rightHandler.execute(position);

		forwardHandler.execute(position);
		assertEquals("Invalid orientation", Orientation.W, position.getOrientation());

		assertEquals("Wrong X position", Integer.valueOf(0), position.getPosition().getX());
		assertEquals("Wrong Y position", Integer.valueOf(0), position.getPosition().getY());
	}

}
