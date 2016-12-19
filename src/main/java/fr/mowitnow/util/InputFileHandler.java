package fr.mowitnow.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.mowitnow.model.Coordinates;
import fr.mowitnow.model.Lawn;
import fr.mowitnow.model.LawnMower;
import fr.mowitnow.model.LawnMowerBrain;
import fr.mowitnow.model.LawnMowerPosition;
import fr.mowitnow.model.Orientation;

public class InputFileHandler {

	private static final Logger logger = LogManager.getLogger(InputFileHandler.class);
	private final static String PATTERN = "\\s+";

	public void handleInputFile(String path) {

		// On crée le reader pour proceser toutes les lignes du fichier
		Path filePath = FileSystems.getDefault().getPath(path);

		try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {

			// Lecture des dimensions de la pelouse
			String[] header = reader.readLine().split(PATTERN);
			Lawn lawn = new Lawn(Integer.valueOf(header[0]), Integer.valueOf(header[1]));

			// Initialisation de la tendeuse
			LawnMower lawnMowner = new LawnMower(new LawnMowerBrain(lawn));

			// On itère sur le reste de lignes du fichier
			String line = null;
			while ((line = reader.readLine()) != null) {

				logger.info("Processing lawnmower information...");
				// Position initiale
				String[] initialPositionElements = line.split(PATTERN);

				Coordinates position = new Coordinates(Integer.valueOf(initialPositionElements[0]),
						Integer.valueOf(initialPositionElements[1]));
				LawnMowerPosition initialPosition = new LawnMowerPosition(position,
						Orientation.valueOf(initialPositionElements[2]));
				lawnMowner.init(initialPosition);

				// Execution des instructions
				String sequence = reader.readLine();
				LawnMowerPosition finalPosition = lawnMowner.execute(sequence);

				logger.info("({}) -> ({}) ==> ({})", initialPosition, sequence, finalPosition);
			}

			logger.info("Done!");

		} catch (IOException ex) {
			logger.error("Error while reading file {}: {}", path, ex.getMessage());
		}
	}

}
