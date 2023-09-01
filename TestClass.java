package Project1;

import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String player1;
        int w;
        String move;
        int stats;
        int exit;
        System.out.println();
        System.out.println();
        System.out.println(" \t\t\t\t*** Welcome to School in USA ***");
        System.out.println();
        PlayerStatus p1 = new PlayerStatus();
        PlayerStatus p2 = new PlayerStatus();

        System.out.println(" Introduce player's name: ");
        player1 = sc.nextLine();

        p1.initPlayer(player1, 3, 20000);
        p1.movePlayerTo(10, 50);
        p1.initPlayer(player1, 3, 20000);
        p1.movePlayerTo(10, 50);

        System.out.println(" Welcome back in the game " + p1.getNickName() + "!");
        System.out.println(" You have been spawned to: x=" +  p1.getPositionX() + " , y=" + p1.getPositionY());
        System.out.println();
        System.out.println(" You don't have a gun. To select one press: (1) Kalashnikov; (2) Sniper; (3) Knife. ");
        w = sc.nextInt();

        if (w == 1) p1.setWeaponInHand("kalashnikov");
        if (w == 2) p1.setWeaponInHand("sniper");
        if (w == 3) p1.setWeaponInHand("knife");
        if (w <= 0 || w > 3) {
            System.out.println("Please introduce a number between 1 and 3");
        }
        System.out.println(" You have selected " + p1.getWeaponInHand() + ". You are ready to fight!");
        System.out.println();

        p1.movePlayerTo(50, 100);
        p1.findArtifact(496);

        System.out.println(" Congratulations! You have found an artefact. ");
        System.out.println("  Press (4) to see the player's current status: ");
        stats = sc.nextInt();
        System.out.println();
        p1.movePlayerTo(70, 150);
        System.out.println("Nickname: " + p1.getNickName() + "\nScore: " + p1.getScore() + "\nHealth: " + p1.getHealth()
                + " \nWeapon Used: " + p1.getWeaponInHand() + "\nCoords: x= " + p1.getPositionX() + " , y= " + p1.getPositionY());
        System.out.println();
        System.out.println(" The player is moving! ");

        p1.findArtifact(60);
        p1.movePlayerTo(100, 200);

        System.out.println(" Bad luck! You have found an artefact but it is a trap! ");
        System.out.println();
        System.out.println(" Your status after the update is: ");
        System.out.println("Nickname: " + p1.getNickName() + "\nScore: " + p1.getScore() + "\nHealth: " + p1.getHealth()
                + " \nWeapon Used: " + p1.getWeaponInHand() + "\nCoords: x= " + p1.getPositionX() + " , y= " + p1.getPositionY());
        System.out.println();
        System.out.println(" The player is moving! ");

        p2.initPlayer("Player2", 1, 20000);
        p2.setWeaponInHand("sniper");
        p2.movePlayerTo(90, 250);

        System.out.println(" You can see: " + p2.getNickName() + " who is at the next coordinates: x="
                + p2.getPositionX() + " , y=" + p2.getPositionY() + " and uses a " + p2.getWeaponInHand());
        System.out.println();
        System.out.println(" \t* WARNING *");
        System.out.println();
        if (p1.shouldAttackOpponent(p2)) {
            System.out.println(" You have the chance to win because " + p2.getNickName() + " uses a " + p2.getWeaponInHand()
                    + " and you use a " + p1.getWeaponInHand());
        } else {
            System.out.println(" You will lose because " + p2.getNickName() + " uses a " + p2.getWeaponInHand()
                    + " and you use a " + p1.getWeaponInHand() + ".");
        }
        System.out.println();
        System.out.println(" The player is moving! ");

        p2.movePlayerTo(2000, 5000);
        p2.setWeaponInHand("sniper");

        System.out.println(" You can see: " + p2.getNickName() + " who is at the next coordinates: x="
                + p2.getPositionX() + " , y=" + p2.getPositionY() + " and uses a " + p2.getWeaponInHand());
        System.out.println();
        System.out.println("\t * WARNING *");
        System.out.println();
        if (p1.shouldAttackOpponent(p2)) {
            System.out.println(" You have the chance to win because " + p2.getNickName() + " uses a " + p2.getWeaponInHand() + ".");
        } else {
            System.out.println(" You will lose because " + p2.getNickName() + " uses a " + p2.getWeaponInHand()
                    + " and you use " + p1.getWeaponInHand() + ".");
        }
        if (p1.getHealth() < 0) {
            System.out.println(" GAME OVER");
        }

        sc.close();
    }

}
