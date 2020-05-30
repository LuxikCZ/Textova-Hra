package cz.spsejecna.titera2.game;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Decisions.Decision1;
import players.Player;

public class Main {

	public static void main(String[] args) {
		//02.04.2020
		Pattern p = Pattern.compile("[A-Z]{1}[a-z]{3,15}");
		Scanner sc = new Scanner(System.in);
		Player player = Player.Load();	//03.04.2020
		if(player == null) { 	//03.04.2020
			System.out.println("Name of you character:");
			String name = sc.nextLine();
			Matcher m = p.matcher(name);
			while(m.matches() == false){
				if(name.length()<4) {
					System.err.println("Name is too short");
				}else {
					if(name.length()>16) {
						System.err.println("Name is too long");
					}else {
						System.err.println("Name contains unalowed characters or has no capital character on begining.");
					}
				}
				name = sc.nextLine();
				m = p.matcher(name);
			}
			player = Player.factoryPlayer(name);
		}
		System.out.println(player);
		//03.04.2020
		player.Save(player);
		Decision1.Decision(player);
	}
}
