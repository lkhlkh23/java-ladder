package ladder;

import java.util.Random;

public class Ladder {
    private static final char VERTICAL_BAR = '|' ;
    private static final char HORIZONTAL_BAR = '-' ;
    private static final char NO_BAR = ' ' ;
    private char[][] ladderImage;

    Ladder(int participation, int height) {
        this.ladderImage = new char[height][participation * 2 -1];
    }

    public char[][] getLadder() {
        for(int i = 0; i < ladderImage.length; i++) {
            getStage(i);
        }
        return ladderImage;
    }

    private void getStage(int stage) {
        for(int i = 0; i < ladderImage[stage].length; i++) {
            getStep(stage, i);
        }
    }

    private void getStep(int stage, int step) {
        ladderImage[stage][step] = step % 2 == 0 ? VERTICAL_BAR : getLadderImage();
    }

    private char getLadderImage() {
        return new Random().nextBoolean() ? HORIZONTAL_BAR : NO_BAR;
    }


}