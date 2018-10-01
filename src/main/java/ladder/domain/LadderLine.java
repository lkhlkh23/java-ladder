package ladder.domain;

import java.util.*;

public class LadderLine {
	private int countOfPerson;
	private List<Boolean> points;

	public LadderLine(int countOfPerson) {
		this.countOfPerson = countOfPerson;
	}

	public LadderLine(int countOfPerson, List<Participation> participations) {
		this(countOfPerson);
		this.points = new ArrayList<>();
	}

	/* 테스트를 위한 생성자! */
	public LadderLine(int countOfPerson, List<Participation> participations, List<Boolean> points) {
		this(countOfPerson);
		this.points = points;
	}
	
	public void addPoint(boolean isBar) {
		points.add(isBar);
	}
	
	private boolean getRandom() {
		return new Random().nextBoolean();
	}
	
	public boolean isContinous(int index, boolean nowBar) {
		return prevBar(index - 1) == nowBar;
	}
	
	private boolean prevBar(int index) {
		return points.get(index);
	}
	
	public boolean setBar(int index, boolean nowBar) {
		if(isContinousBar(index, isContinous(index, nowBar))) {
			return false; 
		}
		return nowBar;
	}

	private boolean isContinousBar(int index, boolean continous) {
		return continous && prevBar(index - 1);
	}

	public LadderLine makeLine() {
		addPoint(false);
		for(int i = 1; i < countOfPerson; i++) {
			addPoint(setBar(i, getRandom()));
		}
		return this;
	}
	
	public List<Boolean> getLine() {
		return Collections.unmodifiableList(points);
	}

	public void moveDistance(Participation participation) {
		if(participation.getPointer().isMoveLeft(points)) {
			participation.getPointer().moveX(-1);
		} else if(participation.getPointer().isMoveRight(points)) {
			participation.getPointer().moveX(1);
		}
	}

}
