package ladder;

import java.util.*;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    private int countOfPerson;

    public Line(int countOfPerson) {
        this.countOfPerson = countOfPerson;
    }

    public void makeLine() {
        addPoint(false);
        for(int i = 1; i < countOfPerson; i++) {
            addPoint(isContinous(i) ? false : getRandom());
        }
    }

    private boolean isContinous(int index) {
        return points.get(index);
    }

    public void addPoint(boolean isBar) {
        points.add(isBar);
    }

    private boolean getRandom() {
        return new Random().nextBoolean();
    }

    public List<Boolean> getLine() {
        return Collections.unmodifiableList(points);
    }

    public boolean isContinousTest(int index) {
        return isContinous(index);
    }
}
