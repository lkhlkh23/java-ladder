package ladder.domain;

import java.util.*;

public class Ladder {
	private int height;
	private int countOfPerson;
	private List<Line> ladderImage = new ArrayList<>();
	
	public Ladder(int countOfPerson, int height) {
		this.countOfPerson = countOfPerson;
		this.height = height;
	}
	
	private Line makeLine() {
		return new Line(countOfPerson).makeLine();
	}

	public List<Line> getLadder() {
		for(int i = 0; i < height; i++) {
			ladderImage.add(makeLine());
		}
		return ladderImage;
	}
}
