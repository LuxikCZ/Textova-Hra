package Enemies;
//23.04.2020
public class Bandit extends Enemy {
	
	protected Bandit(int Health, int Damage, String Type) {
		super(Health, Damage, Type);
	}

	public static Bandit factoryBandit() {
		Bandit bandit = new Bandit(25, 10, "Bandit");
		return bandit;
	}

}
