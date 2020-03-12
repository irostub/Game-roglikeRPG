package roglikeRPG;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;

public class Inventory implements Serializable
{
	private ArrayList<Item> i;
	
	public Inventory() {
		i = new ArrayList<Item>();
	}
	
	public void setI(ArrayList<Item> i) {
		this.i = i;
	}

	public void showInven() {
		
		Iterator<Item> itr = i.iterator();
		int count = 0;
		
		if(i.isEmpty())
		{
			System.out.println("ȹ���� �������� �ƹ��͵� ���׿�! ���� ������. ����� �����!");
			return;
		}
		System.out.println("--------------------");
		System.out.println("[   ȹ���� ������ ���      ]");
		
		while(itr.hasNext()) {
			Item temp = itr.next();
			System.out.println("["+count+"] �� �κ��丮 ������");
			System.out.println("�����۸� : " + temp.getName());
			System.out.println("������ ���� : " + temp.getDesc());
			System.out.println();
			count++;
		}
		System.out.println("--------------------");
	}
	
	public ArrayList<Item> getI() {
		if(i.size() == 0) {
			return null;
		}
		return i;
	}
	
	public void addItem(Item i)
	{
		this.i.add(i);
	}
	
	public void delItem(int index)
	{
		i.remove(index);
	}
}
