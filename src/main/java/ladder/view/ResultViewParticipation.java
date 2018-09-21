package ladder.view;

import ladder.domain.Participation;

public class ResultViewParticipation {
	public static void printParticipation(Participation[] participations) {
		System.out.println(getParticipation(participations));
	}
	
	
	private static String getParticipation(Participation[] participations) {
		StringBuilder sb = new StringBuilder();
		for(Participation participation : participations) {
			sb.append(participation.getName());
		}
		return sb.toString();
	}
}
