package ladder.domain;

import java.util.*;

public class Reward {
    private List<LadderLine> ladderImage;
    private Map<String, String> rewardMatch;

    public Reward(List<LadderLine> ladderImage) {
        this.ladderImage = ladderImage;
        this.rewardMatch = new HashMap<>();
    }

    public void setAllRewardResult(List<Participation> participations, List<String> rewards) {
        /* 참가자 전체 인원에 대한 결과를 Map 에 셋팅 */
        int participationIndex = 0;
        for(Participation participation : participations) {
            rewardMatch.put(participation.getName().trim(), rewards.get(getParticipationResult(participation, participationIndex++)));
        }
    }
    /* 참가자 한명에 대한 보상 결과 반환 */
    public int getParticipationResult(Participation participation, int participationIndex) {
        for(int i = 0; i < ladderImage.size(); i++) {
            /* 참가자 한명을 사다리의 높이만큼 반복 */
            moveLine(i, participation, participationIndex);
        }
        return participation.getPointer().getPointX();
    }

    /*   @param [index : 사다리의 세로 위치, participationIndex : 참가자의 순번(몇 번째 참가자인지)
    *
    * */
    public void moveLine(int index, Participation participation, int participationIndex) {
        ladderImage.get(index).moveDistance(participationIndex, participation.getPointer().getPointX());
    }

    public String getParticipationReward(String name) {
        return rewardMatch.get(name);
    }

    /* 참가자가 존재하는지 확인 (존재하지 않으면 다시 호출) */
    public boolean isParticipation(String name) {
        return rewardMatch.containsKey(name);
    }

    public Map<String, String> getRewardMatch() {
        return Collections.unmodifiableMap(rewardMatch);
    }

}
