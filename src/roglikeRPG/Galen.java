package roglikeRPG;

public class Galen extends Monster{

	private String name;

	public Galen() {
		super(150, 15, 10);
		this.name = "����";
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDesc() {
		return "��ġ�� �ʴ� ���̰� ���� ��������!";
	}
}
