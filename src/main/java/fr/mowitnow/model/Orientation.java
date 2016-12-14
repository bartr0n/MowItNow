package fr.mowitnow.model;

public enum Orientation {
    N, E, S, W;

    public Orientation next() {
        int index = (this.ordinal() + 1) % values().length;

        return values()[index];
    }

    public Orientation previous() {
        int index = (this.ordinal() - 1) % values().length;

        return values()[index];
    }
}
