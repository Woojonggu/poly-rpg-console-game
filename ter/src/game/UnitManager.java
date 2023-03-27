package game;

import java.util.ArrayList;

public class UnitManager {

	ArrayList<Unit> unit = new ArrayList<>();
	ArrayList<Player> player = new ArrayList<>();

	private static UnitManager instance = new UnitManager();

	public static UnitManager getinstance() {
		return instance;
	}

	UnitManager() {
		unit.add(new UnitBat(10, 10, "����", 10));
		unit.add(new UnitBat(20, 20, "��ũ", 13));
		unit.add(new UnitBat(30, 30, "����", 16));
		player.add(new Player(10, 10, "dk", 14));
	}

}
