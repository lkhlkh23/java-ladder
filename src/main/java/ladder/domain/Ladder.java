package ladder.domain;

import ladder.dto.RewardDto;

import java.util.*;

public class Ladder {
	private int height;
	private int countOfPerson;
	private List<LadderLine> ladderImage = new ArrayList<>();
	
	public Ladder(int countOfPerson, int height) {
		this.countOfPerson = countOfPerson;
		this.height = height;
	}
	
	private LadderLine makeLine(List<Participation> participations) {
		return new LadderLine(countOfPerson, participations).makeLine();
	}

	public List<LadderLine> getLadder(List<Participation> participations) {
		for(int i = 0; i < height; i++) {
			ladderImage.add(makeLine(participations));
		}
		return ladderImage;
	}

	public RewardDto setAllRewardResult(List<Participation> participations, List<String> rewards) {
		/* 참가자 전체 인원에 대한 결과를 Map 에 셋팅 */
		RewardDto rewardDto = new RewardDto();
		for(Participation participation : participations) {
			rewardDto.setReward(participation.getName().trim(), rewards.get(getParticipationResult(participation)));
		}
		return rewardDto;
	}
	/* 참가자 한명에 대한 보상 결과 반환 */
	public int getParticipationResult(Participation participation) {
		for(int i = 0; i < ladderImage.size(); i++) {
			/* 참가자 한명을 사다리의 높이만큼 반복 */
			moveLine(i, participation);
		}
		return participation.getPointer().getPointX();
	}

	/*   @param [index : 사다리의 세로 위치, participationIndex : 참가자의 순번(몇 번째 참가자인지)
	 *
	 * */
	public void moveLine(int index, Participation participation) {
		ladderImage.get(index).moveDistance(participation);
	}

}
