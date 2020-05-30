package Pets;
//13.04.2020
public class Pet {
	private int Health;
	private int Damage;
	private String Type;
	
	protected Pet(int Health, int Damage, String Type) {
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
	
	public String getType() {
		return Type;
	}
	

}
