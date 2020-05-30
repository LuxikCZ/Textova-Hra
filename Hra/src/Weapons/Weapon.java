package Weapons;
//30.03.2020
public class Weapon {

	public int currentAmmo;
	private String Type;
	private int Damage;
	private String Name;

	protected Weapon(String Name, String Type, int Damage) {
		this.Type = Type;
		this.Damage = Damage;
		this.Name = Name;
	}
	
	public String toString() {
		return Name + " Type: " + Type + " Damage: " + getDamage();
	}

	public int getDamage() {
		return Damage;
	}
	
	public String getType() {
		return Type;
	}
	
	public String getName() {
		return Name;
	}

}
