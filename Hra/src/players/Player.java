package players;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import Enemies.Enemy;
import Weapons.Hands;
import Weapons.Weapon;
import Pets.Pet;

//01.04.2020
public class Player implements Serializable {
	private final static int MAX_HEALTH = 100;
	private final static int MAX_ARMOR = 100;
	private String Name;
	private int Health;
	private Weapon Weapon;
	private int Armor;
	private Pet Pet = null;
	private static Player singleton = null;
	ArrayList<Object> Inventory = new ArrayList<Object>();//08.04.2020
	static Hands hands = Hands.factoryHands();
	
	public Weapon getWeapon() {//22.04.2020
		return Weapon;
	}

	public static Player factoryPlayer(String name) {
		if (singleton == null) {
			singleton = new Player(name, 100, 0, hands);
		}
		return singleton;
	}
	//01.04.2020
	private Player(String name, int health, int armor, Weapon weapon) {
		this.Name = name;
		this.Health = health;
		this.Armor = armor;
		this.Weapon = weapon;
	}
	//01.04.2020
	public String toString() {
		return "Player: \nName: " + Name + "\nHealth: " + Health + "\nArmor: " + Armor + "\nWeapon: " + Weapon;
	}
	//03.04.2020
	public void Save (Player Player) {
		try {
			Path pathRelative = Paths.get("player.dat");
			Path pathAbsolute = pathRelative.toAbsolutePath();
			String path = pathAbsolute.toString();
			FileOutputStream fileo = new FileOutputStream(path);
			ObjectOutputStream out = new ObjectOutputStream(fileo);

			out.writeObject(Player);

			out.close();
			fileo.close();

		} catch (IOException e) {
			System.err.println("IO Exception");
		} catch (Exception e) {
			System.err.println("An unexpected error has occurred");
		}
	}
	//03.04.2020
	public static Player Load () {
		Player Player = null;
		try {
			Path pathRelative = Paths.get("player.dat");
			Path pathAbsolute = pathRelative.toAbsolutePath();
			String path = pathAbsolute.toString();
			FileInputStream fileo = new FileInputStream(path);
			ObjectInputStream in = new ObjectInputStream(fileo);
	
			Player = (Player) in.readObject();
	
			in.close();
			fileo.close();
	
			System.out.println(Player);
			
	
		} catch (IOException e) {
			System.err.println("IO Exception");
		} catch (Exception e) {
			System.err.println("An unexpected error has occurred");
		}
		return Player;
	}
	//03.04.2020
	public static int AddHealth (Player Player, int AddedHealth) {
		if(Player.Health == MAX_HEALTH) {
			System.err.println("You already have maximal health");
		}else {
			Player.Health = Player.Health + AddedHealth;
			if(Player.Health > MAX_HEALTH) {
				Player.Health = MAX_HEALTH;
			}
		}
		return Player.Health;
	}
	//03.04.2020
	public static int AddArmor (Player Player, int AddedArmor) {
		if(Player.Armor == MAX_ARMOR) {
			System.err.println("You already have maximal armor");
		}else {
			Player.Armor = Player.Armor + AddedArmor;
			if(Player.Armor > MAX_ARMOR) {
				Player.Armor = MAX_ARMOR;
			}
		}
		return Player.Armor;
	}
	//06.04.2020
	public Player recieveDamage(Player Player, int Damage) {
		if(Player.Armor > 0) {
			if(Player.Armor < Damage) {
				System.out.println("You recieved damage of " + Damage);
				Player.Armor = 0;
				Damage = Damage - Player.Armor;
				Player.Health = Player.Health - Damage;
				if(Player.Health <= 0) {
					System.out.println("Game Over \nYou Died");
				}
			}
		}else {
			if(Player.Health <= Damage) {
				System.out.println("You recieved damage of " + Damage);
				System.out.println("Game Over \nYou Died");
			}else {
				if(Player.Armor == 0 && Player.Health > Damage) {
					Player.Health = Player.Health - Damage;
					System.out.println("You recieved damage of " + Damage);
					System.out.println("Your remaining health is " + Player.Health);
				}
			}
		}
		return Player;
	}
	
	//07.04.2020
	public void dealDamage(Player Player, Enemy Enemy) {
		int Damage = Player.Weapon.getDamage();
		Enemy.recieveDamage(Enemy, Damage);
	}
	//08.04.2020
	public void openInventory(Player Player) {
		if(Inventory.size() == 0) {
			System.out.println("Your inventory is empty");
		}else {
			for(int i = 0; i < Inventory.size(); i++) {
				System.out.println(Integer.toString(i) + ". " + Inventory.get(i));
			}
		}
	}
	//08.04.2020
	public Player disarm (Player Player) {
		if(Weapon.getName().equalsIgnoreCase("hands")!= true) {
			Inventory.add(Weapon);
			Player.Weapon = hands;
		}
		return Player;
	}
	//09.04.2020
	public Player changeWeapon(Player Player, Weapon Weapon) {
		if(Player.Weapon.getName().equalsIgnoreCase("hands")!=true) {
			Inventory.add(Player.Weapon);
			Player.Weapon = Weapon;
		}
		return Player;
	}
	//16.04.2020
	public Player changePet(Player Player, Pet Pet) {
		if(Player.Pet == null) {
			Player.Pet = Pet;
		}else {
			Inventory.add(Player.Pet);
			Player.Pet = Pet;
		}
		return Player;
	}
	public int getHealth() {
		return Health;
	}
	public Player clearInventory(Player Player) {//29.04.2020
		Inventory.clear();
		return Player;
	}

}
