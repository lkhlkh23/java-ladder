package ladder.view;

import java.util.*;
import ladder.domain.Participation;
import ladder.domain.Pointer;
import ladder.domain.Reward;

public class InputView {
	private static final String SPLIT_STANDARD = ",";
	private static Scanner sc = new Scanner(System.in);
	
	public static List<Participation> getParticipations() {
		System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
		return makeParticipation(splitSentence(sc.nextLine()));
	}
	
	public static int getLadderHeigth() {
		System.out.println("최대 사다리 높이는 몇 개인가요?");
		return sc.nextInt();
	}

	public static List<String> getReward() {
		System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
		return splitSentence(sc.next());
	}

	public static String getParticipation() {
		System.out.println("결과를 보고 싶은 사람은?");
		return sc.next();
	}

	public static String getParticipationName(Reward reward) {
		String name = "";
		do {
			name = getParticipation();
		} while(!nameCheck(name, reward));
		return name;

	}

	public static boolean nameCheck(String name, Reward reward) {
		if(reward.isParticipation(name) || name.equals("all")) {
			return true;
		}
		System.out.println("이름을 정확히 입력해주세요.");
		return false;
	}

	private static List<String> splitSentence(String nameInput) {
		List<String> splited = new ArrayList<>();
		for(String str : nameInput.split(SPLIT_STANDARD)) {
			splited.add(str);
		}
		return splited;
	}
	
	private static List<Participation> makeParticipation(List<String> names) {
		List<Participation> participations = new ArrayList<>();
		int cnt = 0;
		for (String name : names) {
			participations.add(new Participation(name, makePointer(cnt++)));
		}
		return participations;
	}

	private static Pointer makePointer(int index) {
		return new Pointer(index);
	}

	public static void close() {
		sc.close();
	}
}
