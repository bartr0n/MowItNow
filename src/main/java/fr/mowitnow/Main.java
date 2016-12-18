package fr.mowitnow;

import fr.mowitnow.util.InputFileHandler;

/**
 * Hello world!
 */
public class Main {
	public static void main(String[] args) {

		if (args.length != 1) {
			System.err.println("Usage: java -jar filename.jar <inputFile>");
		} else {

			InputFileHandler inputFileHandler = new InputFileHandler();
			inputFileHandler.handleInputFile(args[0]);
		}
	}
}
