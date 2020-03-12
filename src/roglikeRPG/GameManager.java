package roglikeRPG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {

	private ArrayList<Tile> t;
	private Player p;
	private int playerTile;
	public Scanner s;

	public GameManager() {
		t = new ArrayList<Tile>();
		p = new Player();
		playerTile = 0;
		s = new Scanner(System.in);
	}

	public void game() {
		
		loadData();
		
		System.out.println("S's roglike RPG ������ �����մϴ�. ��԰� ����ּ���.");

		int select = 0;
		int itemSelect = -1;
		while (p.getHp() > 0 || select != 999) {
			t.add(new Tile());
			// ������ ���� �� ���� ���
			System.out.println("[     ���� �÷��̾� ��ġ : " + (int) (playerTile + 1) + "     ]");
			if (t.get(playerTile).i == null && t.get(playerTile).m == null) {
				Boolean isCheck = true;
				while (isCheck) {
					printVoidRoom();
					select = s.nextInt();
					System.out.println("--------------------");
					System.out.println();

					switch (select) {
					case 0:saveData(p);break;// ���̺�� �̰��� �ۼ�
					case 1:
						p.getI().showInven();
						break;
					case 2:
						// player�� �κ��丮 ���� �����۸���Ʈ�� �������� �ϳ��� ���� ��
						if (p.getI().getI() == null) {
							System.out.println("��! �������� �ϳ��� ���׿�. ����� �����!");
							break;
						}
						p.getI().showInven();
						System.out.println();
						System.out.println("����� �������� ��ȣ�� �Է����ּ��� : ");
						itemSelect = s.nextInt();

						if (itemSelect < 0 || itemSelect > p.getI().getI().size() - 1) {
							System.out.println("���� �߸������߳�������! �ٽ� �õ��ϼ���!");
							break;
						}

						p.getI().getI().get(itemSelect).use(p);// ����ϰ� ����� ������ ����
						p.getI().getI().remove(itemSelect);
						break;
					case 3:System.out.println(p);break;
					case 4:
						isCheck = false;
						break;// whileŻ��
					case 5: p.setHp(p.getHp()+p.getMaxHp()/10);break;
					case 999:
						saveData(p);
						select = 999;
						break;// ���̺� �� ���� �������Ḧ ���⿡ �ۼ�
					default:
						System.out.println("���� �߸������� ����̿���! �ٽ� �õ��ϼ���!");
					}
					if(select == 999)
					{
						break;
					}
				}
				if(select == 999)
				{
					break;
				}
			}
			// ������ ���� ������ ���� ���
			else if (t.get(playerTile).i != null && t.get(playerTile).m == null) {
				Boolean isCheck = true;
				p.getI().addItem(t.get(playerTile).i);
				while (isCheck) {
					printItemRoom(t.get(playerTile).i);

					select = s.nextInt();
					System.out.println("--------------------");
					System.out.println();

					switch (select) {
					case 0:
						p.getI().showInven();
						break;// ������ ������ ����
					case 1:
						// player�� �κ��丮 ���� �����۸���Ʈ�� �������� �ϳ��� ���� ��
						if (p.getI().getI() == null) {
							System.out.println("��! �������� �ϳ��� ���׿�. ����� �����!");
							break;
						}
						p.getI().showInven();
						System.out.println();
						System.out.println("����� �������� ��ȣ�� �Է����ּ��� : ");
						itemSelect = s.nextInt();

						if (itemSelect < 0 || itemSelect > p.getI().getI().size() - 1) {
							System.out.println("���� �߸������߳�������! �ٽ� �õ��ϼ���!");
							break;
						}

						p.getI().getI().get(itemSelect).use(p);// ����ϰ� ����� ������ ����
						p.getI().getI().remove(itemSelect);
						break;
					case 2:System.out.println(p);break;
					case 3:
						isCheck = false;
						break;// whileŻ��
					case 999:
						saveData(p);
						select = 999;
						break;// ���̺� �� ���� �������Ḧ ���⿡ �ۼ�
					default:
						System.out.println("���� �߸������� ����̿���! �ٽ� �õ��ϼ���!");
					}
					if(select == 999)
					{
						break;
					}
				}
				if(select == 999)
				{
					break;
				}
			}
			// ������ ���� ���� ���� ���
			else if (t.get(playerTile).i == null && t.get(playerTile).m != null) {
				System.out.println("���͹濡 �����̱���! ���� ����!!");
				int turnCount = 1;
				Boolean isCheck = true;
				while (isCheck) {
					// �÷��̾��� ü���� 0�� ���ų� 0���� �۾��� ��� ����. ó�� : ���� ���� ���� ����
					if (p.getHp() <= 0) {
						System.out.println("���Ϳ��� �������� �������� ���Ҿ��...");
						System.out.println("���� ������ �� �� ��ƺ���!");
						System.out.println();
						System.out.println("ps.���� ��� ���̺���� �ʽ��ϴ�.");
						select = 999;
						break;
					}

					// ������ ü���� 0�̵Ǿ� �÷��̾ �̱� ���. ó�� : �÷��̾��� exp�� ������ exp�� ���ϰ� ��ŵ
					if (t.get(playerTile).m.getHp() <= 0) {
						System.out.println();
						System.out.println("--------------------");
						System.out.println("���Ϳ��� �������� �¸��߽��ϴ�!");
						System.out.println("����ġ ȹ�� EXP + "+ t.get(playerTile).m.getExp());
						System.out.println("--------------------");
						System.out.println();
						p.setExp(p.getExp() + t.get(playerTile).m.getExp());
						checkPlayerLevelup();
						break;
					}

					System.out.println("[ ��  " + turnCount + "��  ]");
					printMonsterRoom(t.get(playerTile).m);

					select = s.nextInt();
					System.out.println("--------------------");
					System.out.println();

					switch (select) {
					case 0:
						t.get(playerTile).m.setHp(t.get(playerTile).m.getHp() - p.getAtk());
						p.setHp(p.getHp() - t.get(playerTile).m.getAtk());
						break;// ���⼭ ����
					case 1:
						// player�� �κ��丮 ���� �����۸���Ʈ�� �������� �ϳ��� ���� ��
						if (p.getI().getI() == null) {
							System.out.println("��! �������� �ϳ��� ���׿�. ����� �����!");
							break;
						}
						p.getI().showInven();
						System.out.println();
						System.out.println("����� �������� ��ȣ�� �Է����ּ��� : ");
						itemSelect = s.nextInt();

						if (itemSelect < 0 || itemSelect > p.getI().getI().size() - 1) {
							System.out.println("���� �߸������߳�������! �ٽ� �õ��ϼ���!");
							break;
						}

						p.getI().getI().get(itemSelect).use(p);// ����ϰ� ����� ������ ����
						p.getI().getI().remove(itemSelect);
						break;
					case 2: System.out.println(p); break;
					case 3:
						p.setHp(p.getHp() - t.get(playerTile).m.getAtk());
						break;
					default:
						System.out.println("���� �߸������� ����̿���! �ٽ� �õ��ϼ���!");
					}
					if(select == 999)
					{
						break;
					}
					turnCount++;
				}
			}
			// ���� ����
			else {
				System.out.println("gamanager game�޼ҵ� ���� �߻�. tile������ ������ �˻��� ��.");
			}
			playerTile++;
		}
		System.out.println("������ ����˴ϴ�!");
		// �� while�� �ȿ��� ��� ���� �÷��̰� �̷����. �̰����� Ż���ϸ� ������ ��������.
	}

	public void printVoidRoom() {
		System.out.println();
		System.out.println("--------------------");
		System.out.println("�� �濡 �����̱���! ������ �Ͻðھ��?");
		System.out.println();
		System.out.println("[0]���̺�");
		System.out.println("[1]������ ��� ����");
		System.out.println("[2]������ ���");
		System.out.println("[3]�÷��̾� ������");
		System.out.println("[4]�ƹ��͵� ���ϰ� ��ŵ");
		System.out.println("[5]�޽�(ü��ȸ��)");
		System.out.println("[999]���� ����");
		System.out.println("--------------------");
		System.out.print("���� : ");
	}

	public void printItemRoom(Item i) {
		System.out.println();
		System.out.println("--------------------");
		System.out.println("�����۹濡 �����̱���! �����ؿ�!");
		System.out.println();
		System.out.println("-----ȹ�� ������ ����-----");
		System.out.println("�����۸� : " + i.getName());
		System.out.println("�����ۼ��� : " + i.getDesc());
		System.out.println("--------------------");
		System.out.println("[0]������ ��� ����");
		System.out.println("[1]������ ���");
		System.out.println("[2]�÷��̾� ������");
		System.out.println("[3]�ƹ��͵� ���ϰ� ��ŵ");
		System.out.println("[999]���� ����");
		System.out.println("--------------------");
		System.out.print("���� : ");
	}

	public void printMonsterRoom(Monster m) {
		System.out.println();
		System.out.println("--------------------");
		System.out.println(m.getName() + "��� : " + m.getDesc());
		System.out.println();
		System.out.println("-----�� ������ ����-----\t\t\t-----�÷��̾��� ����-----");
		System.out.println("���� �̸� : " + m.getName()+"\t\t\t\t�÷��̾� HP : "+p.getHp());
		System.out.println("���� ü�� : " + m.getHp()+"\t\t\t\t�÷��̾� LEVEL : "+p.getLevel());
		System.out.println("���� ���ݷ� : " + m.getAtk()+"\t\t\t\t�÷��̾� ATK : " + p.getAtk());
		System.out.println("���� ���� ������ ȹ�� ����ġ : " + m.getExp()+"\t\t\t�÷��̾� EXP : "+p.getExp());
		System.out.println("--------------------");
		System.out.println("[0]����");
		System.out.println("[1]������ ���");
		System.out.println("[2]�÷��̾� ������");
		System.out.println("[3]�ƹ��͵� ���ϰ� ��ŵ");
		System.out.println("--------------------");
		System.out.print("���� : ");
	}
	
	public void checkPlayerLevelup() {
		if(p.getExp()>p.getExpmargin()[0]) {
			p.setLevel(2);
			p.levelup();
		}else if(p.getExp()>p.getExpmargin()[1]) {
			p.setLevel(3);
			p.levelup();
		}else if(p.getExp()>p.getExpmargin()[2]) {
			p.setLevel(4);
			p.levelup();
		}else if(p.getExp()>p.getExpmargin()[3]) {
			p.setLevel(5);
			p.levelup();
		}else if(p.getExp()>p.getExpmargin()[4]) {
			p.setLevel(6);
			p.levelup();
		}else if(p.getExp()>p.getExpmargin()[5]) {
			p.setLevel(7);
			p.levelup();
		}else if(p.getExp()>p.getExpmargin()[6]) {
			p.setLevel(8);
			p.levelup();
		}else if(p.getExp()>p.getExpmargin()[7]) {
			p.setLevel(9);
			p.levelup();
		}else if(p.getExp()>p.getExpmargin()[8]) {
			p.setLevel(10);
			p.levelup();
		}else {
			
		}
	}
	
	public void saveData(Player data) {
		File f = new File("data.dat");
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(data);
			oos.flush();
			oos.close();
			System.out.println("�÷��̾� �����Ͱ� ����Ǿ����ϴ�.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadData()
	{
		File x = new File("data.dat");
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(x));
			Player temp = (Player)ois.readObject();
			this.p = temp;
			ois.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("S's roglike RPG ���ӿ� ó�����Ű� ȯ���մϴ�! �� ������ ù ���� ����ÿ��� �����մϴ�!");
			System.out.println("�� ������ �α� ����ũ�������� ó�� �ϴ� �е鿡�� �ټ� ����� �� �ֽ��ϴ�.");
			System.out.println("���� ��� ó������ �ٽý����ϰ� �Ǹ�, �����ʰ� �߰��߰� �� �濡�� ������ �� �� �ֽ��ϴ�! ���ǰ� �������� ���� ĳ���͸� ������Ѻ�����!");
			System.out.println("-���� by irostub-");
			return;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
