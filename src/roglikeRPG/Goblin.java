package roglikeRPG;

public class Goblin extends Monster {

	private String name;
	
	public Goblin() {
		super(100, 20, 15);
		this.name = "���";
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDesc() {
		return "�ð��� ���̶� ģ��";
	}
}
