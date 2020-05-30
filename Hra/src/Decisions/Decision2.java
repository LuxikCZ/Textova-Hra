package Decisions;

import java.util.Scanner;

import Enemies.Bandit;
import Enemies.Wolf;
import Pets.TamedWolf;
import Weapons.Bow;
import players.Player;

public class Decision2 extends Decision1{
	
	//14.04.2020
	public static Object Decision2a(Player Player) {
		Scanner sc = new Scanner(System.in);
		Wolf wolf = Wolf.factoryWolf();
		System.out.println("You hear the growling nearing you.");
		System.out.println("On a rock before you suddenly stands a wolf.");
		System.out.println("Do you want to fight it or have you changed your mind and want to run?");
		String decision2 = sc.nextLine();
		Player.Save(Player);
		while(decision2.equalsIgnoreCase("fight")!=true && decision2.equalsIgnoreCase("run")!=true) {//20.04.2020
			System.out.println("You only have two options fight or run");
			decision2 = sc.nextLine();
		}
		if(decision2.equalsIgnoreCase("fight")) {
			System.out.println("The wolf is slowly nearing you and keeps growling.");
			System.out.println("Do you wish to attack it or wait for what will the wolf do?");
			decision2 = sc.nextLine();
			Player.Save(Player);
			while(decision2.equalsIgnoreCase("attack")!=true && decision2.equalsIgnoreCase("wait")!=true) {//20.04.2020
				System.out.println("You only have two options attack or wait");
				decision2 = sc.nextLine();
			}
			if(decision2.equalsIgnoreCase("attack")) {
				Player.dealDamage(Player, wolf);
				System.out.println("You angried the wolf and it has attacked you.");
				Player.recieveDamage(Player, wolf.getDamage());
				System.out.println("You attacked the wolf again.");
				Player.dealDamage(Player, wolf);
				return Decision3.Decison3a();
			}
			//15.04.2020
			if(decision2.equalsIgnoreCase("wait")) {
				System.out.println("The wolf comes near you, it does not attack, but it looks hungry?");
				System.out.println("Do you wish to feed it or attack it?");
				decision2 = sc.nextLine();
				Player.Save(Player);
				while(decision2.equalsIgnoreCase("attack")!=true && decision2.equalsIgnoreCase("feed")!=true) {//20.04.2020
					System.out.println("You only have two options attack or feed");
					decision2 = sc.nextLine();
				}
				if(decision2.equalsIgnoreCase("feed")) {
					System.out.println("You pulled a meat from you pouch and gave it to the wolf.");
					System.out.println("The wold ate the meat and befriended you.");
					TamedWolf tamedWolf = TamedWolf.factoryTamedWolf();	//16.04.2020
					Player.changePet(Player, tamedWolf); //16.04.2020
					return Decision3.Decison3b();
				}
				if(decision2.equalsIgnoreCase("attack")) {
					System.out.println("You tried to attack the wolf.");
					System.out.println("The wolf reacted quickly a caught you by surprise.");
					System.out.println("You had no time to react and died.");
					Player.recieveDamage(Player, 999999);
				}
			}
		}
		//16.04.2020
		if(decision2.equalsIgnoreCase("run")) {
			System.out.println("You turn aroun and start running, but the starts folowing you.");
			System.out.println("You keep running as fast as you can, but the wolf is still closing in.");
			System.out.println("The wolf finally catches you and attacks you by jumping on your back.");
			System.out.println("You try to defend yourself but invain and you die.");
			Player.recieveDamage(Player, 999999);
		}
		return null;
	}
	//17.04.2020
	public static Object Decision2b(Player Player) {
		Scanner sc = new Scanner(System.in);
		System.out.println("You run deeper to the forest until you found a village, or something that looks like some sort of settlement.");
		System.out.println("The village looks abandoned.");
		System.out.println("Do you wish to investigate or avoid it?");
		String decision2 = sc.nextLine();
		Player.Save(Player);
		while(decision2.equalsIgnoreCase("investigate")!=true && decision2.equalsIgnoreCase("avoid")!=true) {//20.04.2020
			System.out.println("You only have two options investigate or avoid");
			decision2 = sc.nextLine();
		}
		if(decision2.equalsIgnoreCase("investigate")) {
			System.out.println("You decided to investigate the abandoned village.");
			System.out.println("You carefully approach the first of the abandoned houses.");
			System.out.println("When you are standing next to the house you suddenly hear voices.");
			System.out.println("\"What if the village is not abandoned after all\" you think to yourself.");
			System.out.println("But then you hear a female scream, you carefully peek out of the corner.");
			System.out.println("You see some bandits porbably killing the remaining villagers, but first they are torturing them and they look like they enjoy it.");
			System.out.println("Do you wish to try and help the remaining villagers or leave them to their fate and run?");
			decision2 = sc.nextLine();
			Player.Save(Player);
			while(decision2.equalsIgnoreCase("help")!=true && decision2.equalsIgnoreCase("run")!=true) {//20.04.2020
				System.out.println("You only have two options help or run");
				decision2 = sc.nextLine();
			}
			if(decision2.equalsIgnoreCase("help")) {
				System.out.println("You think about your chances and realise you cannot fight them in close combat.");
				System.out.println("Then you see a dead archer with some of remaining arrows in his quiver.");
				System.out.println("You hide your spear-like twig and pick up his bow.");
				Bow bow = Bow.factoryBow();//23.04.2020
				Player.changeWeapon(Player, bow);//23.04.2020
				System.out.println("The bandits still do not seem to notice you, you can use that to your advantage.");
				System.out.println("You notice that there is a ladder near the building you were hiding behind.");
				System.out.println("You can use the ladder to climb on a roof or you can shoot from the ground.");
				System.out.println("Do you want to shoot from roof or ground.");
				decision2 = sc.nextLine();
				Player.Save(Player);
				while(decision2.equalsIgnoreCase("roof")!=true && decision2.equalsIgnoreCase("ground")!=true) {//20.04.2020
					System.out.println("You only have two options roof or ground");
					decision2 = sc.nextLine();
				}
				if(decision2.equalsIgnoreCase("ground")) {//23.04.2020
					System.out.println("You have chosen to stay on the ground while fighting the bandits.");
					System.out.println("There are three bandits, which one do you wish to attack first?");
					System.out.println("The one on the left or the one in the middle or the one on the right?");
					Bandit left = Bandit.factoryBandit();
					Bandit middle = Bandit.factoryBandit();
					Bandit right = Bandit.factoryBandit();
					decision2 = sc.nextLine();
					Player.Save(Player);
					while(decision2.equalsIgnoreCase("left")!= true && decision2.equalsIgnoreCase("middle")!= true && decision2.equalsIgnoreCase("right")!= true) {
						System.out.println("You only have three options left, middle or right.");
						decision2 = sc.nextLine();
					}
					if(decision2.equalsIgnoreCase("left")) {//24.04.2020
						//27.04.2020
						System.out.println("You decided to attack the left bandit first.");
						Player.dealDamage(Player, left);
						System.out.println("The bandits have noticed you and are running towards you.");
						System.out.println("Do you wish to attack the bandit again or fallback?");
						decision2 = sc.nextLine();
						Player.Save(Player);
						while(decision2.equalsIgnoreCase("attack")!= true && decision2.equalsIgnoreCase("fallback")!= true) {
							System.out.println("You only have two options attack or fallback.");
							decision2 = sc.nextLine();
						}
						if(decision2.equalsIgnoreCase("attack")) {
							System.out.println("You decided to stand your ground and attack again.");
							Player.dealDamage(Player, left);
							System.out.println("The bandits are really close to you now, you have a little time for just one thing.");
							System.out.println("Do you wish to attack again or try to fallback?");
							decision2 = sc.nextLine();
							Player.Save(Player);
							while(decision2.equalsIgnoreCase("attack")!= true && decision2.equalsIgnoreCase("fallback")!= true) {
								System.out.println("You only have two options attack or fallback.");
								decision2 = sc.nextLine();
							}
							if(decision2.equalsIgnoreCase("attack")) {
								System.out.println("You attack the left bandit again and finally killed him.");
								Player.dealDamage(Player, left);
								System.out.println("But the other two bandits are really close to you.");
								System.out.println("You can try to use your primitive spear or surrender.");
								System.out.println("Do you want to fight or surrender?");
								//28.04.2020
								decision2 = sc.nextLine();
								Player.Save(Player);
								while(decision2.equalsIgnoreCase("fight")!= true && decision2.equalsIgnoreCase("surrender")) {
									System.out.println("You only have two options fight or surrender.");
									decision2 = sc.nextLine();
								}
								if(decision2.equalsIgnoreCase("fight")) {
									System.out.println("You decided to fight them.");
									System.out.println("You take your primitive spear and attack");
									Weapons.TwigSpear TwigSpear = Weapons.TwigSpear.factoryTwigSpear();
									while(Player.getHealth() > 0 && (middle.getHealth()>0||right.getHealth()>0)) {
										if(middle.getHealth() > 0) {
											Player.dealDamage(Player, middle);
											if(middle.getHealth()>0) {
												Player.recieveDamage(Player, middle.getDamage());
											}
											if(right.getHealth()>0) {
												Player.recieveDamage(Player, right.getDamage());
											}
										}else {
											if(right.getHealth()>0) {
												Player.dealDamage(Player, right);
												if(right.getHealth()>0) {
													Player.recieveDamage(Player, right.getDamage());
												}
												if(middle.getHealth()>0) {
													Player.recieveDamage(Player, middle.getDamage());
												}
											}
										}
									}
								}
								if(decision2.equalsIgnoreCase("surrender")) {//29.04.2020
									System.out.println("You have dropped your weapons and surrendered.");
									Player.clearInventory(Player);
									Weapons.Hands Hands = Weapons.Hands.factoryHands();
									Player.changeWeapon(Player, Hands);
									System.out.println("One of the bandits approached you laughed and hit you with somethig heavy.");
									System.out.println("You lost consiousness.");
									return Decision3.decision3e();
								}
							}
							if(decision2.equalsIgnoreCase("fallback")) {//29.04.2020
								System.out.println("You tried to fallback, but the bandits caught you and knocked you on the ground.");
								System.out.println("You try to defend yourself but one of the bandits started to choke you and the other one is holding you.");
								System.out.println("You are slowly loosing consiousness...");
								Player.recieveDamage(Player, 99999999);
							}
						}
						if(decision2.equalsIgnoreCase("fallback")) {//29.04.2020
							System.out.println("You decided to fall back to safe distance before attacking again.");
							System.out.println("Now you have time to fire two arrows before needing to fallback again.");
							System.out.println("You attacked the left bandit again, twice.");
							Player.dealDamage(Player, left);
							Player.dealDamage(Player, left);
							//30.04.2020
							System.out.println("One of the bandits is finally dead, but you have to kill the other two.");
							System.out.println("You fallback again and attack another one of the bandits.");
							Player.dealDamage(Player, middle);
							System.out.println("You shot the bandit to a neck and he bled out.");
							middle.bleedOut(middle);
							System.out.println("You shot the last bandit.");
							Player.dealDamage(Player, right);
							System.out.println("The bandit got scared from death of his comrades, dropped his weapon and ran.");
							System.out.println("You hid your weapon and went to the place where you heard the screams from.");
							Weapons.Hands Hands = Weapons.Hands.factoryHands();
							Player.changeWeapon(Player, Hands);
							System.out.println("You slowly approach the woman, she seems to be unconcious and heavily injured.");
							System.out.println("She probably will not survive without help.");
							System.out.println("Do you wish to help her or leave her to die?");
							decision2 = sc.nextLine();
							Player.Save(Player);
							while(decision2.equalsIgnoreCase("help")!=true && decision2.equalsIgnoreCase("leave")!=true) {
								System.out.println("You only have two options help or leave.");
								decision2 = sc.nextLine();
							}
							if(decision2.equalsIgnoreCase("help")) {
								//04.05.2020
								System.out.println("You have decided to help the injured woman.");
								System.out.println("You kneel down next to her and start bandaging her wounds.");
								return Decision3.decision3f();
							}
							if(decision2.equalsIgnoreCase("leave")) {
								//04.05.2020
								System.out.println("You decided it was too late to save the woman and left the village.");
								return Decision3.decision3g();
							}
						}
					}
					if(decision2.equalsIgnoreCase("middle")) {//24.04.2020
						//TODO attack middle
					}
					if(decision2.equalsIgnoreCase("right")){//24.04.2020
						//TODO attack right
					}
				}
				if(decision2.equalsIgnoreCase("roof")) {
					//05.05.2020
					Bandit left = Bandit.factoryBandit();
					Bandit middle = Bandit.factoryBandit();
					Bandit right = Bandit.factoryBandit();
					System.out.println("You have decided to climb the ladder to the roof and use height as your advantage while attacking the bandits.");
					System.out.println("You have used your advantage a shot one of the unsuspecting bandits straight in to the head.");
					middle.bleedOut(middle);
					System.out.println("The other two bandits noticed that something is not right and are searching for the shooter -you-.");
					System.out.println("Do you wish to attack another one of the bandits, or hide until they split up?");
					decision2 = sc.nextLine();
					Player.Save(Player);
					while(decision2.equalsIgnoreCase("attack")!=true&&decision2.equalsIgnoreCase("hide")!=true) {
						System.out.println("You only have two options attack or hide.");
						decision2 = sc.nextLine();
					}
					if(decision2.equalsIgnoreCase("attack")) {
						//06.05.2020
						System.out.println("You attacked another bandit and hit the neck.");
						left.bleedOut(left);
						System.out.println("The last bandit noticed you and hid behind a wall, so you can not shoot him.");
						System.out.println("You can try and pursue him or wait for him to make a move.");
						System.out.println("Do you want to pursue him or wait?");
						decision2 = sc.nextLine();
						Player.Save(Player);
						while(decision2.equalsIgnoreCase("pursue")!=true&&decision2.equalsIgnoreCase("wait")!=true) {
							System.out.println("You only have two options pursue or wait.");
							decision2 = sc.nextLine();
						}
						if(decision2.equalsIgnoreCase("pursue")) {
							//15.05.2020
							System.out.println("You have decided not to wait for the bandit, but to pursue him.");
							System.out.println("You slowly approach the position you saw him last.");
							System.out.println("You take a peak behind the corner, but the bandit is not there.");
							System.out.println("But suddenly a sword pierces your body from the back.");
							System.out.println("You slowly bleed out and die.");
							Player.recieveDamage(Player, 99999999);
						}
						if(decision2.equalsIgnoreCase("wait")) {
							//15.05.2020
							System.out.println("You decide to wait on the roof for the bandit to make a mistake.");
							System.out.println("You wait for a long time, but suddenly the bandit peeks out.");
							System.out.println("You have not missed the chance and shot him straight in the eye.");
							right.bleedOut(right);
							System.out.println("You approach the woman you heard screaming, she is barrely breathing and will not survive without aid.");
							System.out.println("Do you wish to help her or leave her?");
							decision2 = sc.nextLine();
							Player.Save(Player);
							while(decision2.equalsIgnoreCase("help")!=true&&decision2.equalsIgnoreCase("leave")!=true) {
								System.out.println("You only have two options leave or help.");
								decision2 = sc.nextLine();
							}
							if(decision2.equalsIgnoreCase("help")) {
								return Decision3.decision3f();
							}
							if(decision2.equalsIgnoreCase("leave")) {
								return Decision3.decision3d();
							}
						}
					}
					if(decision2.equalsIgnoreCase("hide")) {//05.05.2020
						System.out.println("You have hidden yourself from the bandits.");
						System.out.println("The bandits desperately want to find you and have spread out.");
						System.out.println("You can attack now without fearing you will be detected by the other one.");
						System.out.println("Do you want to attack the left or the right one?");
						decision2 =sc.nextLine();
						Player.Save(Player);
						while(decision2.equalsIgnoreCase("left")!=true&&decision2.equalsIgnoreCase("right")!=true) {
							System.out.println("You only have two options left or right.");
							decision2 = sc.nextLine();
						}
						if(decision2.equalsIgnoreCase("left")) {//06.05.2020
							//TODO attack left
						}
						if(decision2.equalsIgnoreCase("right")) {//06.05.2020
							//TODO attack right
						}
					}
				}
			}
			if(decision2.equalsIgnoreCase("run")) {//24.04.2020
				System.out.println("You have decided to run away and leave the villagers to their fate.");
				System.out.println("As you are leaving the village, you hear the woman scream in pain again.");
				System.out.println("Maybe, there is still time to save her, do you wish to try or just leave?");
				decision2 = sc.nextLine();
				Player.Save(Player);
				while(decision2.equalsIgnoreCase("help")!=true && decision2.equalsIgnoreCase("leave")) {
					System.out.println("You only have two options help or leave.");
				}
				if(decision2.equalsIgnoreCase("help")) {
					return Decision3.decision3c();
				}
				if(decision2.equalsIgnoreCase("leave")) {
					return Decision3.decision3d();
				}
			}
		}
		if(decision2.equalsIgnoreCase("avoid")) {
			//04.05.2020
			System.out.println("You have decided to avoid the village and go deeper to the woods.");
			System.out.println("As you are nearing the end of the village you hear a female scream, as if in pain...");
			System.out.println("Have you changed your mind and want to help or leave");
			decision2 = sc.nextLine();
			Player.Save(Player);
			while(decision2.equalsIgnoreCase("help")!=true && decision2.equalsIgnoreCase("leave")!=true) {
				System.out.println("You only have two options help or leave.");
				decision2 = sc.nextLine();
			}
			if(decision2.equalsIgnoreCase("help")) {
				return Decision3.decision3c();
			}
			if(decision2.equalsIgnoreCase("leave")) {
				return Decision3.decision3d();
			}
		}
		return null;
	}

}
