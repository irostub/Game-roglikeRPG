package roglikeRPG;

public class Ghuol extends Monster {

	private String name;
	
	public Ghuol() {
		super(125, 20, 20);
		this.name = "����";
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDesc() {
		return "����..������ �׷��� ���ִ���..�ڳ׵� �����ϰڳ�?";
	}
}
