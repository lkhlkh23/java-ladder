package ladder.domain;

import java.util.*;

public class Ladder {
	private int height;
	private int countOfPerson;
	private List<LadderLine> ladderImage = new ArrayList<>();
	
	public Ladder(int countOfPerson, int height) {
		this.countOfPerson = countOfPerson;
		this.height = height;
	}
	
	private LadderLine makeLine(List<Participation> participations) {
		return new LadderLine(countOfPerson, participations).makeLine();
	}

	public List<LadderLine> getLadder(List<Participation> participations) {
		for(int i = 0; i < height; i++) {
			ladderImage.add(makeLine(participations));
		}
		return ladderImage;
	}
}
