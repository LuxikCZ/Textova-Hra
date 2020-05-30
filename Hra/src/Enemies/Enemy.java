package Enemies;
//07.04.2020
public class Enemy {
	private int Health;
	private int Damage;
	private String Type;
	
	protected Enemy(int Health, int Damage, String Type) {
		this.Health = Health;
		this.Damage = Damage;
		this.Type = Type;
	}
	
	public int getDamage() {
		return Damage;
	}
	
	public int getHealth() {
		return Health;
	}
	
	public Enemy recieveDamage(Enemy Enemy, int Damage) {
		if(Enemy.Health <= Damage) {
			System.out.println("The " + Type + " has died");
		}else {
			if(Enemy.Health > Damage) {
				Enemy.Health = Enemy.Health - Damage;
				System.out.println("The " + Type + " has survived the attack, with " + Enemy.Health + " remaining health");
			}
		}
		return Enemy;
	}
	//30.04.2020
	public Enemy bleedOut(Enemy Enemy) {
		Enemy.recieveDamage(Enemy, 9999999);
		return Enemy;
	}
}
