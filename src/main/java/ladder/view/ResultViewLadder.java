package ladder.view;

import java.util.List;
import ladder.domain.Line;
import ladder.domain.Participation;

public class ResultViewLadder {
	private static final char HORIZONTAL_BAR = '-';
	private static final char VERTICAL_BAR = '|';
	private static final char NO_BAR = ' ';
	
	public static void printLadder(List<Line> ladderImage) {
		for(Line line : ladderImage) {
			printLine(line);
		}
	}

	private static void printLine(Line line) {
		StringBuilder sb = new StringBuilder();
		for(Boolean isBar : line.getLine()) {
			sb.append(getPoint(isBar)).append(VERTICAL_BAR);
		}
		System.out.println(sb.toString());
	}

	private static String getPoint(Boolean isBar) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < Participation.MAX_NAME_LENGTH; i++) {
			sb.append(getBar(isBar));
		}
		return sb.toString();
	}

	private static char getBar(Boolean isBar) {
		if(isBar) {
			return HORIZONTAL_BAR;
		} 
		return NO_BAR;
	}
}
