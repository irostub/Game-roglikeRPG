package roglikeRPG;

public class Yaso extends Monster{

	private String name;
	
	public Yaso() {
		super(250, 1, 30);
		this.name = "�߽���";
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDesc() {
		return "�߽����� �����̶��, ���ó�?";
	}
}
