package fr.mowitnow;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.mowitnow.util.InputFileHandler;

/**
 * Main class permettant de lancer le traitement du fichier. Avant de proceder,
 * on valide le nombre d'arguments passés
 * 
 * @author joseam
 *
 */
public class Main {

	private static final Logger logger = LogManager.getLogger(Main.class);

	public static void main(String[] args) {

		// Verification des arguments
		if (args.length != 1) {
			logger.error("Usage: java -jar filename.jar <inputFile>");
		} else {

			// On commence à traiter le fichier
			InputFileHandler inputFileHandler = new InputFileHandler();

			try {
				inputFileHandler.handleInputFile(args[0]);
			} catch (IllegalArgumentException ex) {
				logger.error("Invalid argument: {}", ex.getMessage());
			} catch (Exception ex) {
				logger.error("Unexpected exception: {}", ex.getMessage());
			}
		}
	}
}
