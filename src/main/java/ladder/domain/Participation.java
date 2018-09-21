package ladder.domain;

public class Participation {
	public static final int MAX_NAME_LENGTH = 5;
	private String name;
	
	public Participation(String name) {
		this.name = name;
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
}
