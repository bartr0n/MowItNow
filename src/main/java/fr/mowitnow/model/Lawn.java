package fr.mowitnow.model;

import javax.validation.constraints.Min;

import com.google.common.collect.Range;

public class Lawn {

	private final static Integer ORIGIN = 0;

	private Range<Integer> xRange;
	private Range<Integer> yRange;

	public Lawn(@Min(0) Integer x, @Min(0) Integer y) {
		xRange = Range.closed(ORIGIN, x);
		yRange = Range.closed(ORIGIN, y);
	}

	public boolean isOutOfBoundaries(Position position) {

		return !xRange.contains(position.getX()) || !yRange.contains(position.getY());
	}
}
