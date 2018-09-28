package ladder.domain;

import java.util.*;

public class LadderLine {
	private int countOfPerson;
	private List<Boolean> points;
	private List<Pointer> pointers;

	public LadderLine(int countOfPerson) {
		this.countOfPerson = countOfPerson;
	}

	public LadderLine(int countOfPerson, List<Participation> participations) {
		this(countOfPerson);
		this.points = new ArrayList<>();
		initPointers(participations);
	}

	/* 테스트를 위한 생성자! */
	public LadderLine(int countOfPerson, List<Participation> participations, List<Boolean> points) {
		this(countOfPerson);
		this.points = points;
	}

	private void initPointers(List<Participation> participations) {
		pointers = new ArrayList<>();
		for(Participation participation : participations) {
			pointers.add(participation.getPointer());
		}
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

	public boolean isMoveLeft(int pointX) {
		if(pointX == 0) {
			/* 좌측으로 이동이 불가능할 경우 */
			return false;
		}
		return points.get(pointX);
	}

	public boolean isMoveRight(int pointX) {
		if(pointX == points.size() - 1) {
			/* 우측으로 이동이 불가능할 경우 */
			return false;
		}
		return points.get(pointX + 1);
	}

	public void moveDistance(int index, int pointX) {
		if(isMoveLeft(pointX)) {
			pointers.get(index).moveX(-1);
		}

		if(isMoveRight(pointX)) {
			pointers.get(index).moveX(1);
		}
	}
}
