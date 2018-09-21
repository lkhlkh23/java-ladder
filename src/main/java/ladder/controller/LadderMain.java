package ladder.controller;

import ladder.view.*;
import ladder.domain.*;

public class LadderMain {

	public static void main(String[] args) {
		Participation[] participations = InputView.getParticipations();	
		int height = InputView.getLadderHeigth();
		ResultViewParticipation.printParticipation(participations);
		ResultViewLadder.printLadder(new Ladder(participations.length, height).getLadder());
		InputView.close();
	}
}
