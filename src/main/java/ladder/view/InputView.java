package ladder.view;

import java.util.*;
import ladder.domain.Participation;

public class InputView {
	private static final String SPLIT_STANDARD = ",";
	private static Scanner sc = new Scanner(System.in);
	
	public static Participation[] getParticipations() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		return makeParticipation(splitName(sc.nextLine()));
	}
	
	public static int getLadderHeigth() {
		System.out.println("최대 사다리 높이는 몇 개인가요?");
		return sc.nextInt();
	}
	
	private static String[] splitName(String nameInput) {
		return nameInput.split(SPLIT_STANDARD);
	}
	
	private static Participation[] makeParticipation(String[] names) {
		Participation[] participations = new Participation[names.length];
		int cnt = 0;
		for(String name : names) {
			participations[cnt++] = new Participation(name);
		}
		return participations;
	}

	public static void close() {
		sc.close();
	}
}
