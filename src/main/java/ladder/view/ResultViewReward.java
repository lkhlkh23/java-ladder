package ladder.view;

import ladder.domain.Participation;
import ladder.dto.RewardDto;

import java.util.*;

public class ResultViewReward {
    public static void printRewards(List<String> rewards) {
        for(String reward : rewards) {
            System.out.print(stringFormat(reward));
        }
        System.out.println();
    }

    private static String stringFormat(String reward) {
        return String.format("%" + (Participation.MAX_NAME_LENGTH + 1) + "s", reward);
    }

    public static boolean printRewardResult(String name, RewardDto reward) {
        System.out.println("실행결과");
        if(name.equals("all")) {
            printParticipationAllResult(reward);
            return false;
        }
        printParticipationResult(name, reward);
        return true;
    }

    private static void printParticipationAllResult(RewardDto reward) {
        Iterator<String> it = reward.getRewardMatch().keySet().iterator();
        while(it.hasNext()) {
            printParticipationResult(it.next(), reward);
        }
    }

    private static void printParticipationResult(String name, RewardDto reward) {
        System.out.println(name + " : " + reward.getParticipationReward(name));
    }

}
