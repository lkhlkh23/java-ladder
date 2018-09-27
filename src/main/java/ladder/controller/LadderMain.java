package ladder.controller;
import ladder.view.*;
import ladder.domain.*;

import java.util.List;

public class LadderMain {

	public static void main(String[] args) {
		List<Participation> participations = InputView.getParticipations();
		List<String> rewards = InputView.getReward();
		int height = InputView.getLadderHeigth();

		ResultViewLadder.printResultMessage();
		ResultViewParticipation.printParticipation(participations);
		List<Line> ladderImage = new Ladder(participations.size(), height).getLadder();
		ResultViewLadder.printLadderResult(ladderImage);
		ResultViewReward.printRewards(rewards);

		Reward reward = new Reward(ladderImage);
		reward.setAllRewardResult(participations, rewards);

		printFinalResult(reward);
	}

	private static void printFinalResult(Reward reward) {
		String name = null;
		do {
			name = InputView.getParticipationName(reward);
			ResultViewReward.printRewardResult(name, reward);
		} while(!name.equals("all"));
	}
}
