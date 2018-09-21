package ladder.domain;

import java.util.*;

public class Line {
	private int countOfPerson;
	private List<Boolean> points;
	
	public Line(int countOfPerson) {
		this.countOfPerson = countOfPerson;
		points = new ArrayList<>();
	}
	
	public void addPoint(boolean isBar) {
		points.add(isBar);
	}
	
	private boolean getRandom() {
		return new Random().nextBoolean();
	}
	
	public boolean isContinous(int index, boolean nowBar) {
		if(prevBar(index - 1) == nowBar == true) {
			return true;
		}
		return false;
	}
	
	private boolean prevBar(int index) {
		return points.get(index);
	}
	
	public boolean setBar(int index, boolean nowBar) {
		if(isContinous(index, nowBar)) {
			return false; 
		}
		return getRandom();
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
