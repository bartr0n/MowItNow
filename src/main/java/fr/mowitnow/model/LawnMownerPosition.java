package fr.mowitnow.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class LawnMownerPosition {

    private Position position;
    private Orientation orientation;

    public LawnMownerPosition(LawnMownerPosition source) {

        this.position = new Position(source.getPosition().getX(), source.getPosition().getY());
        this.orientation = source.orientation;
    }
}
