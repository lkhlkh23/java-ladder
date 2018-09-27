package ladder.domain;

import java.util.*;

public class Line {
	private int countOfPerson;
	private List<Boolean> points;
	
	public Line(int countOfPerson) {
		this.countOfPerson = countOfPerson;
		points = new ArrayList<>();
	}

	/* 테스트를 위해 난수를 통해 생성되는 리스트를 생성자를 통해 SET! */
	public Line(int countOfPerson, List<Boolean> points) {
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

	public Line makeLine() {
		addPoint(false);
		for(int i = 1; i < countOfPerson; i++) {
			addPoint(setBar(i, getRandom()));
		}
		return this;
	}
	
	public List<Boolean> getLine() {
		return Collections.unmodifiableList(points);
	}
	
	public int getPointsSize() {
		return points.size();
	}
}
