package roglikeRPG;
import java.io.Serializable;

public class Player implements Serializable{
	
	private Inventory i;
	private int level;
	private int hp;
	private int maxHp;
	private int atk;
	private int exp;
	private int expmargin[] = {10,100,200,350,500,650,850,1050,1350};
	
	public Player() {
		super();
		this.hp = 500;
		this.atk = 15;
		this.exp = 0;
		this.level = 1;
		this.maxHp = 500;
		i = new Inventory();
	}
	
	public void levelup()
	{
		System.out.println("-------����~��!!-------");
		System.out.println("�ִ� HP���� ����߽��ϴ�.");
		System.out.println("���ݷ��� ����߽��ϴ�.");
		System.out.println("---------------------");
		
		this.maxHp += this.maxHp/10;
		this.atk += this.atk/10;
	}
	
	@Override
	public String toString() {
		return "------�÷��̾� ������------\n\n�÷��̾� ���� : "+ level + "\n�÷��̾� ���� HP : " + hp + "\n�÷��̾� �ִ� HP : " + maxHp + "\n�÷��̾� ���ݷ� : " + atk + "\n�÷��̾� ����ġ : " + exp + "\n\n------------------------";
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int[] getExpmargin() {
		return expmargin;
	}

	public void setExpmargin(int[] expmargin) {
		this.expmargin = expmargin;
	}

	public Inventory getI() {
		return i;
	}
	
	public void setI(Inventory i) {
		this.i = i;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getExp() {
		return exp;
	}
	
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	
}
