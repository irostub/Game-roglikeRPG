package roglikeRPG;

public class Portion extends Food{
	private String name;

	public Portion() {
		super(150);
		this.name = "���� ���� ����";
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public String getDesc() {
		return "���� �����Դϴ�. hp�� 150 ��ŭ ȸ���մϴ�.";
	}
}
