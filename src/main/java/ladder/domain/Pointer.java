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

    public boolean isMoveLeft(List<Boolean> points) {
        if(pointX == 0) {
            /* 좌측으로 이동이 불가능할 경우 */
            return false;
        }
        return points.get(pointX);
    }

    public boolean isMoveRight(List<Boolean> points) {
        if(pointX == points.size() - 1) {
            /* 우측으로 이동이 불가능할 경우 */
            return false;
        }
        return points.get(pointX + 1);
    }
}
