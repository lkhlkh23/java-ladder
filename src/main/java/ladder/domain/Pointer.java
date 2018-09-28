package ladder.domain;

import java.util.List;

public class Pointer {
    private int pointX;

    public Pointer(int pointX) {
        this.pointX = pointX;
    }

    public void moveX(int distance) {
        pointX += distance;
    }

    public int getPointX() {
        return pointX;
    }
}
