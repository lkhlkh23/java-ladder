package ladder;

import java.util.ArrayList;
import java.util.Random;

public class Ladder {
    private ArrayList<Line> ladderImage = new ArrayList<>();
    private int height;
    private int countOfPerson;

    Ladder(int countOfPerson, int height) {
        this.height = height;
        this.countOfPerson = countOfPerson;
    }

    public ArrayList<Line> getLadder() {
        for(int i = 0; i < height; i++) {
            ladderImage.add(getLine());
        }
        return ladderImage;
    }

    private Line getLine() {
        Line line = new Line(countOfPerson);
        line.makeLine();
        return line;
    }
}