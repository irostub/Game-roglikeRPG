package roglikeRPG;

public class Skeleton extends Monster {
	
	private String name;
	
	public Skeleton() {
		super(50, 10, 5);
		this.name = "���̷���";
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDesc() {
		return "���� ���� ��Ⱑ �������°�?";
	}
}
