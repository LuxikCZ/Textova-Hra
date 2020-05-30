package Pets;
//15.04.2020
public class TamedWolf extends Pet {
	
	private static TamedWolf singleton = null;
	
	public static TamedWolf factoryTamedWolf() {
		if(singleton == null) {
			singleton = new TamedWolf(10, 3, "Animal");
		}
		return singleton;
	}

	private TamedWolf(int Health, int Damage, String Type) {
		super(Health, Damage, Type);
		
	}

}
