package ladder.domain;

import java.util.List;

public class Pointer {
    private int pointX;

    public Pointer(int pointX) {
        this.pointX = pointX;
    }

    public void moveX(List<Boolean> ladderLine) {
        pointX += moveDistance(ladderLine);
    }

    public boolean isMoveLeft(List<Boolean> ladderLine) {
        if(pointX == 0) {
            /* 좌측으로 이동이 불가능할 경우 */
            return false;
        }
        return ladderLine.get(pointX);
    }

    public boolean isMoveRight(List<Boolean> ladderLine) {
        if(pointX == ladderLine.size() - 1) {
            /* 우측으로 이동이 불가능할 경우 */
            return false;
        }
        return ladderLine.get(pointX + 1);
    }

    private int moveDistance(List<Boolean> ladderLine) {
        if(isMoveLeft(ladderLine)) {
            return -1;
        }

        if(isMoveRight(ladderLine)) {
            return 1;
        }
        return 0;
    }

    public int getPointX() {
        return pointX;
    }
}
