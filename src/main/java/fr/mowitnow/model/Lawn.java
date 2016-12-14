package fr.mowitnow.model;

public class Lawn {

    private Position boundaries;

    public boolean isOutOfBoundaries(Position position) {

        return position.getX() > boundaries.getX() || position.getY() > boundaries.getY();
    }
}
