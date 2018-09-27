package ladder.domain;

import java.util.List;

public class Pointer {
    private int pointX;

    public Pointer(int pointX) {
        this.pointX = pointX;
    }

    public void moveX(Line line) {
        pointX += moveDistance(line);
    }

    private int moveDistance(Line line) {
        if(line.isMoveLeft(pointX)) {
            return -1;
        }

        if(line.isMoveRight(pointX)) {
            return 1;
        }
        return 0;
    }

    public int getPointX() {
        return pointX;
    }
}
