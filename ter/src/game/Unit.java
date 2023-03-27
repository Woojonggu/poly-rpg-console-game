package game;

public abstract class Unit {

	int maxHp;
	int curHp;
	String name;
	int attack;
	
	Unit(int maxHp, int curHp, String name, int attack){
		this.maxHp = maxHp;
		this.curHp = curHp;
		this.name = name;
		this.attack = attack;
	}
	
	
	
}
