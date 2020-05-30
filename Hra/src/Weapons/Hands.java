package Weapons;
//30.03.2020
public class Hands extends Weapon {

	private static Hands singleton = null;

	public static Hands factoryHands() {
		if (singleton == null) {
			singleton = new Hands("Hands","Melee", 1);
		}
		return singleton;
	}

	private Hands(String Name,String Type, int Damage) {
		super(Name, Type, Damage);
	}

}
