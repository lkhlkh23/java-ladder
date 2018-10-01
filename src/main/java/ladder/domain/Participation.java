package ladder.domain;

public class Participation {
	public static final int MAX_NAME_LENGTH = 5;
	private String name;
	private Pointer pointer;
	
	public Participation(String name, Pointer pointer) {
		this.name = name;
		this.pointer = pointer;
	}

	public int getNameSize() {
		return name.length();
	}

	public boolean isOverSize() {
		if(getNameSize() > MAX_NAME_LENGTH) {
			return true;
		}
		return false;
	}

	public void subStringName() {
		this.name = name.substring(0, MAX_NAME_LENGTH);
	}

	public String stringFormat() {
		return String.format("%" + (MAX_NAME_LENGTH + 1) + "s", name);
	}
	
	public String getName() {
		if(isOverSize()) {
			subStringName();
		}
		return stringFormat();
	}

	public Pointer getPointer() {
		return pointer;
	}
}
/* 인스턴스 변수로 상태로 유지를 관리핧 필요 X */