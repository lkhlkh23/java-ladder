package ladder;

import java.util.ArrayList;

public class ResultView {
    private static final char VERTICAL_BAR = '|';
    private static final char HORIZONTAL_BAR = '-';
    private static final char NO_BAR = ' ';
    private static final int MAX_NAME_LENGTH = 5;

    public static void printParticipations(String[] participations) {
        for(String participation : participations) {
            System.out.print(nameFormat(participation));
        }
        System.out.println();
    }

    private static String nameFormat(String name) {
        return String.format("%" + (MAX_NAME_LENGTH) + "s", name);
    }

    public static void printLadder(ArrayList<Line> ladderImage) {
        StringBuilder sb = new StringBuilder();
        for (Line line : ladderImage) {
            sb.append(printLine(line)).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static String printLine(Line line) {
        StringBuilder sb = new StringBuilder();
        for (Boolean isBar : line.getLine()) {
            sb.append(drawBar(isBar)).append(VERTICAL_BAR);
        }
        return sb.toString();
    }

    private static char getBarImage(boolean isBar) {
        return isBar ? HORIZONTAL_BAR : NO_BAR;
    }

    private static String drawBar(boolean isBar) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < MAX_NAME_LENGTH; i++) {
            sb.append(getBarImage(isBar));
        }
        return sb.toString();
    }

    /* Bar의 모양 출력을 테스트 하기 위한 메소드! */
    public static String drawBarTest(Boolean isBar) {
        return drawBar(isBar);
    }

    /* 이름이 6글자인지 테스트 하기 위한 메소드! */
    public static String nameFormatTest(String name) {
        return nameFormat(name);
    }

    /* 이름이 한줄 출력을 테스트 하기 위한 메소드! */
    public static String printLineTest(Line line) {
        return printLine(line);
    }
}

