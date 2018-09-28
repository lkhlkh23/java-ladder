package ladder.controller;
import ladder.view.*;
import ladder.domain.*;

import java.util.List;

public class LadderMain {

	public static void main(String[] args) {
		/* 1. 참가자 이름을 받아서 Participation 객체 생성! */
		List<Participation> participations = InputView.getParticipations();

		/* 2. 사다리 게임 보상 결과 리스트에 저장! */
		List<String> rewards = InputView.getReward(participations.size());

		/* 3. 사다리 높이 저장! */
		int height = InputView.getLadderHeigth();

		/* 4. 참가자 목록 출력! */
		ResultViewLadder.printResultMessage();
		ResultViewParticipation.printParticipation(participations);

		/* 5. 사다리 이미지를 리스트에 저장! */
		List<LadderLine> ladderImage = new Ladder(participations.size(), height).getLadder(participations);

		/* 6. 사다리 이미지 출력! */
		ResultViewLadder.printLadderResult(ladderImage);

		/* 7. 사다리 이미지 밑에 보상 출력! */
		ResultViewReward.printRewards(rewards);

		/* 8. 참가자들의 사다리 보상 결과 출력! */
		Reward reward = new Reward(ladderImage);
		reward.setAllRewardResult(participations, rewards);

		printFinalResult(reward);
		InputView.close();
	}

	private static void printFinalResult(Reward reward) {
		String name = null;
		do {
			name = InputView.getParticipationName(reward);
			ResultViewReward.printRewardResult(name, reward);
		} while(!name.equals("all"));
	}
}
