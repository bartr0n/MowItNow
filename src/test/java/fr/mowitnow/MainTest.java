package fr.mowitnow;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import fr.mowitnow.util.InputFileHandler;

/**
 * Created by joseam on 14/12/2016.
 */
public class MainTest {

	private InputFileHandler fileHandler;

	@Before
	public void setUp() {
		fileHandler = new InputFileHandler();
	}

	@Test
	public void testValidFile() {
		fileHandler.handleInputFile("src/test/resources/testFiles/inputFile1.txt");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidFile() {
		fileHandler.handleInputFile("src/test/resources/testFiles/inputFile2.txt");
		fail("No exception thrown!");
	}
}
