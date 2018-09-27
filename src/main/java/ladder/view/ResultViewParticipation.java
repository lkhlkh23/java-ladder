package ladder.view;

import ladder.domain.Participation;

import java.util.*;

public class ResultViewParticipation {
	public static void printParticipation(List<Participation> participations) {
		System.out.println(getParticipation(participations));
	}
	
	
	private static String getParticipation(List<Participation> participations) {
		StringBuilder sb = new StringBuilder();
		for(Participation participation : participations) {
			sb.append(participation.getName());
		}
		return sb.toString();
	}
}
