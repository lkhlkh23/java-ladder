package ladder.domain;

import java.util.*;

public class Reward {
    private List<Line> ladderImage;
    private Map<String, String> rewardMatch;

    public Reward(List<Line> ladderImage) {
        this.ladderImage = ladderImage;
        this.rewardMatch = new HashMap<>();
    }

    public void setAllRewardResult(List<Participation> participations, List<String> rewards) {
        /* 참가자 전체 인원에 대한 결과를 Map 에 셋팅 */
        for(Participation participation : participations) {
            rewardMatch.put(participation.getName().trim(), rewards.get(getParticipationResult(participation)));
        }
    }

    public int getParticipationResult(Participation participation) {
        for(int i = 0; i < ladderImage.size(); i++) {
            moveLine(i, participation);
        }
        return participation.getPointer().getPointX();
    }

    public void moveLine(int index, Participation participation) {
        participation.getPointer().moveX(ladderImage.get(index));
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
