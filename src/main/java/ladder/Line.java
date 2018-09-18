package ladder;

import java.util.ArrayList;
import java.util.Random;

public class Line {
    private ArrayList<Boolean> points = new ArrayList<>();
    private int countOfPerson;

    public Line(int countOfPerson) {
        this.countOfPerson = countOfPerson;
    }

    public void makeLine() {
        addPoint(false);
        for(int i = 1; i < countOfPerson; i++) {
            if(isContinous(points.get(i - 1))) {
                addPoint(false);
            } else {
                addPoint(getRandom());
            }
        }
    }

    private boolean isContinous(boolean prev) {
        return prev;
    }

    public void addPoint(boolean isBar) {
        points.add(isBar);
    }

    private boolean getRandom() {
        return new Random().nextBoolean();
    }

    public ArrayList<Boolean> getLine() {
        return points; //getter 생성했음....
    }
}
