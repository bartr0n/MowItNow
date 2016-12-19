package fr.mowitnow.model;

import com.google.common.collect.Range;

public class Lawn {

	private final static Integer ORIGIN = 0;

	private Range<Integer> xRange;
	private Range<Integer> yRange;

	public Lawn(Integer x, Integer y) {
		if (x < ORIGIN || y < ORIGIN) {
			throw new IllegalArgumentException(String.format("X and Y coordinates must be greater than %d", ORIGIN));
		}

		xRange = Range.closed(ORIGIN, x);
		yRange = Range.closed(ORIGIN, y);
	}

	public boolean isOutOfBoundaries(Coordinates position) {

		return !xRange.contains(position.getX()) || !yRange.contains(position.getY());
	}
}
