package fr.mowitnow.util;

import java.util.HashMap;
import java.util.Map;

import fr.mowitnow.brain.actions.ActionHandler;
import fr.mowitnow.brain.actions.Forward;
import fr.mowitnow.brain.actions.TurnLeft;
import fr.mowitnow.brain.actions.TurnRight;
import fr.mowitnow.model.Action;

public class ActionFactory {

	public static Map<Action, ActionHandler> handlerCache = new HashMap<>();

	public static ActionHandler getInstance(Action action) {

		// On cherche sur la cache de handlers
		ActionHandler handler = handlerCache.get(action);
		if (handler != null) {
			return handler;
		}

		// ActionHandler non trouvé, on le crée et on le met dans la cache pour
		// les utilisations suivantes
		switch (action) {
		case A:
			handler = new Forward();
			break;
		case D:
			handler = new TurnRight();
			break;
		default:
			handler = new TurnLeft();
		}

		handlerCache.put(action, handler);

		return handler;
	}
}
