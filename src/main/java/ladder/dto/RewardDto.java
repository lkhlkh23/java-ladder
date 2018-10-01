package ladder.dto;

import java.util.*;

public class RewardDto {
    private Map<String, String> rewardMatch;

    public RewardDto() {
        this.rewardMatch = new HashMap<>();
    }

    public void setRewardMatch(Map<String, String> rewardMatch) {
        this.rewardMatch = rewardMatch;
    }

    public Map<String, String> getRewardMatch() {
        return Collections.unmodifiableMap(rewardMatch);
    }

    public String getParticipationReward(String name) {
        return rewardMatch.get(name);
    }

    /* 참가자가 존재하는지 확인 (존재하지 않으면 다시 호출) */
    public boolean isParticipation(String name) {
        return rewardMatch.containsKey(name);
    }

    public void setReward(String name, String reward) {
        rewardMatch.put(name, reward);
    }
}
