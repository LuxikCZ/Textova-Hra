package Weapons;

import Enemies.Enemy;
import players.Player;

//21.04.2020
public class Bow extends Weapon {

	private static Bow singleton = null;
	private static final int MAX_AMMO = 15;
	public int currentAmmo = 15;

	public static Bow factoryBow() {
		if (singleton == null) {
			singleton = new Bow("Bow", "Ranged", 8, MAX_AMMO);
		}
		return singleton;
	}

	protected Bow(String Name, String Type, int Damage, int Ammo) {
		super(Name, Type, Damage);
		this.currentAmmo = Ammo;
	}
	
	//22.04.2020
	public void useAmmo(Player Player, Enemy Enemy) {
		if(Player.getWeapon().getType().equalsIgnoreCase("ranged")) {
			if(Player.getWeapon().currentAmmo != 0) {
				Player.dealDamage(Player, Enemy);
			}
			if(Player.getWeapon().currentAmmo == 0) {
				System.out.println("You dont have ammo.");
			}
		}
	}
	//22.04.2020
	public Player addAmmo(Player Player, int addedAmmo) {
		if(Player.getWeapon().currentAmmo == MAX_AMMO) {
			System.out.println("Your ammo is full.");
		}
		if(Player.getWeapon().currentAmmo < MAX_AMMO) {
			if(addedAmmo < MAX_AMMO) {
				currentAmmo = currentAmmo + addedAmmo;
				if(currentAmmo > MAX_AMMO) {
					currentAmmo = MAX_AMMO;
				}
			}
		}
		return Player;
	}

}
