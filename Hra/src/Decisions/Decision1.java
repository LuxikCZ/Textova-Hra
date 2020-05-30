package Decisions;

import java.util.Scanner;

import players.Player;

//10.04.2020
public class Decision1 {
	public static Object Decision(Player Player) {
		Scanner sc = new Scanner(System.in);
		System.out.println("You woke up in a forest, you have nothing but clothes and you don't remember what happened.");
		System.out.println("Suddenly you hear a beast-like growl, very close to you.");
		System.out.println("Near you lies a twig, that could be used as a spear.");
		System.out.println("Will you fight or run?");
		String decision1 = sc.nextLine();
		while(decision1.equalsIgnoreCase("fight")!=true && decision1.equalsIgnoreCase("run")!=true) {
			System.out.println("You only have two options fight or run");
			decision1 = sc.nextLine();
		}
		if(decision1.equalsIgnoreCase("fight")) {
			Weapons.TwigSpear TwigSpear = Weapons.TwigSpear.factoryTwigSpear();
			Player.changeWeapon(Player, TwigSpear);
			System.out.println("You picked up the Spear-like twig and prepared to fight whatever will come.");
			return Decision2.Decision2a(Player);
		}
		if(decision1.equalsIgnoreCase("run")) {
			Weapons.TwigSpear TwigSpear = Weapons.TwigSpear.factoryTwigSpear();
			Player.changeWeapon(Player, TwigSpear);
			System.out.println("You decided to not fight the unknown beast and ran.");
			System.out.println("On the way you picked up the Spear-like twig.");
			return Decision2.Decision2b(Player);
		}
		return null;
	}

}
