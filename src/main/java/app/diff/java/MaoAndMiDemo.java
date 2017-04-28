package app.diff.java;

import java.util.ArrayList;
import java.util.List;

public class MaoAndMiDemo {
	public static void main(String[] args) {
		String[] mao=new String[]{"大黄","小黑","红红"};
		String[] mi=new String[]{"大黄","小红","二狗"};
		List<Mao> left=new ArrayList<Mao>();
		List<Mi> right=new ArrayList<Mi>();
		for(String name:mao){
			Mao m=new Mao();
			m.name=name;
			left.add(m);
		}
		for(String mingzi:mi){
			Mi m=new Mi();
			m.mingzi=mingzi;
			right.add(m);
		}
		DiffResult dr = new ForLoopDiff().diff(left, right);
		System.out.println(dr);
	}
	
}

class Mao implements Diffble<Mao> {
	String name;

	@Override
	public int compareTo(Mao o) {
		return name.compareTo(o.name);
	}

	@Override
	public boolean amITheSameAs(Diffble<?> right) {
		if (right instanceof Mi) {
			Mi m = (Mi) right;
			return String.valueOf(m.mingzi).equals(name);
		}
		return false;
	}

	@Override
	public String toString() {
		return "{\"name\":\"" + name + "\"}";
	}
	
}

class Mi implements Diffble<Mi> {
	String mingzi;

	@Override
	public int compareTo(Mi o) {
		return mingzi.compareTo(o.mingzi);
	}

	@Override
	public boolean amITheSameAs(Diffble<?> right) {
		if (right instanceof Mao) {
			Mao m = (Mao) right;
			return String.valueOf(m.name).equals(mingzi);
		}
		return false;
	}

	@Override
	public String toString() {
		return "{\"mingzi\":\"" + mingzi + "\"}";
	}
	
}
