package fr.mowitnow.model;

import fr.mowitnow.brain.actions.ActionHandler;
import fr.mowitnow.util.ActionFactory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
public class LawnMowerBrain {

	@Setter
	private Lawn lawn;

	@Getter
	@Setter
	private LawnMowerPosition currentPosition;

	public LawnMowerBrain(Lawn lawn) {
		this.lawn = lawn;
	}

	public void move(Action action) {

		// On calcule la position suivante par rapport � la position actuelle
		LawnMowerPosition newPosition = new LawnMowerPosition(currentPosition);
		ActionHandler actionHandler = ActionFactory.getInstance(action);
		actionHandler.execute(newPosition);

		// On valide si la position est dans les limites de la pelouse. Si c'est
		// le cas, on ne bouge pas
		if (!lawn.isOutOfBoundaries(newPosition.getCoordinates())) {
			currentPosition = newPosition;
		}

	}
}
