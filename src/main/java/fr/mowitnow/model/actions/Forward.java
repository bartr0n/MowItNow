package fr.mowitnow.model.actions;

import fr.mowitnow.model.LawnMownerPosition;


public class Forward implements ActionHandler {

    public void execute(LawnMownerPosition position) {

        switch (position.getOrientation()) {
            case N:
                position.getPosition().setY(position.getPosition().getY() + 1);
                break;
            case S:
                position.getPosition().setY(position.getPosition().getY() - 1);
                break;
            case E:
                position.getPosition().setX(position.getPosition().getX() + 1);
                break;
            default:
                position.getPosition().setX(position.getPosition().getX() - 1);
        }
    }
}