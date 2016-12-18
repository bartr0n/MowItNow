package fr.mowitnow.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import fr.mowitnow.model.Lawn;
import fr.mowitnow.model.LawnMower;
import fr.mowitnow.model.LawnMownerBrain;
import fr.mowitnow.model.LawnMownerPosition;
import fr.mowitnow.model.Orientation;
import fr.mowitnow.model.Position;

public class InputFileHandler {

	private final static String PATTERN = "\\s+";

	public void handleInputFile(String path) {

		Path filePath = FileSystems.getDefault().getPath(path);

		try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {

			// Lecture des dimensions de la pelouse
			String[] header = reader.readLine().split(PATTERN);
			Lawn lawn = new Lawn(Integer.valueOf(header[0]), Integer.valueOf(header[1]));

			// Initialisation du brainx
			LawnMownerBrain lawnMownerBrain = new LawnMownerBrain();
			lawnMownerBrain.setLawn(lawn);

			LawnMower lawnMowner = new LawnMower(lawnMownerBrain);

			// LoawnMowner configuration
			String line = null;
			while ((line = reader.readLine()) != null) {

				// Position initiale
				String[] initialPositionElements = line.split(PATTERN);
				Position position = new Position(Integer.valueOf(initialPositionElements[0]),
						Integer.valueOf(initialPositionElements[1]));
				LawnMownerPosition initialPosition = new LawnMownerPosition(position,
						Orientation.valueOf(initialPositionElements[2]));

				lawnMowner.init(initialPosition);

				// Execution des instructions
				LawnMownerPosition finalPosition = lawnMowner.execute(reader.readLine());

				System.out.println(finalPosition);
			}

			System.out.println("Done!");

		} catch (IOException ex) {
			System.err.println("File not found!");
			ex.printStackTrace();
		}
	}

}
