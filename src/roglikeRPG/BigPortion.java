package roglikeRPG;

public class BigPortion extends Food {
	
	private String name;
	
	public BigPortion() {
		super(500);
		this.name = "�ϳ� ����� ���� ����";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public String getDesc() {
		return "�ϳ� ����� �����Դϴ�! hp�� 500 ��ŭ ȸ���մϴ�.";
	}
}
