package Enemies;
//13.04.2020
public class Wolf extends Enemy {
	
	private static Wolf singleton = null;
	
	public static Wolf factoryWolf() {
		if(singleton == null) {
			singleton = new Wolf(10, 3, "Animal");
		}
		return singleton;
	}

	private Wolf(int Health, int Damage, String Type) {
		super(Health, Damage, Type);
	}

}
