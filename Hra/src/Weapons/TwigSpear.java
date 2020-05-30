package Weapons;
//09.04.2020
public class TwigSpear extends Weapon {
	
	private static TwigSpear singleton = null;
	
	public static TwigSpear factoryTwigSpear() {
		if(singleton == null) {
			singleton = new TwigSpear("Twig Spear", "Melee", 5);
		}
		return singleton;
	}
	
	private TwigSpear(String Name,String Type, int Damage) {
		super(Name, Type, Damage);
	}
	
}
