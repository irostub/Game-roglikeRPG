package roglikeRPG;

public class Troll extends Monster{

	private String name;
	
	public Troll() {
		super(225, 25, 30);
		this.name = "Ʈ��";
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDesc() {
		return "Ʈ���� ��û���� �ʾ�!";
	}
}
