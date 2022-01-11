import java.util.*;
public class Playsnkldr {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the no of dices to be used: ");
        int number = scan.nextInt();
        Dice dicee = new Dice(number);
        
        System.out.print("Enter the size of the board: ");
        int size = scan.nextInt();

        System.out.print("Enter how many players will play: ");
        int playerscount = scan.nextInt();
        Queue<Player> allplayers = new LinkedList<>();
        Map<String,Integer> cp = new HashMap<>();
        for(int i=1;i<=playerscount;i++){
            System.out.print("Enter players "+i+" name: ");
            String playername = scan.next();
            Player k = new Player(playername);
            allplayers.offer(k);
            cp.put(playername, 0);
            System.out.println(playername +" is at position 0");
        }
        Transfer s1 = new Transfer(23,5);
        Transfer s2 = new Transfer(69,12);
        Transfer s3 = new Transfer(56,25);
        Transfer s4 = new Transfer(43,38);
        Transfer s5 = new Transfer(98,58);
        Transfer s6 = new Transfer(86,54);
        ArrayList<Transfer> Snakelist = new ArrayList<>();
        Snakelist.add(s1);
        Snakelist.add(s2);
        Snakelist.add(s3);
        Snakelist.add(s4);
        Snakelist.add(s5);
        Snakelist.add(s6);

        Transfer l1 = new Transfer(3,21);
        Transfer l2 = new Transfer(16,26);
        Transfer l3 = new Transfer(8,55);
        Transfer l4 = new Transfer(37,76);
        Transfer l5 = new Transfer(64,85);
        Transfer l6 = new Transfer(80,99);
        ArrayList<Transfer> Ladderlist = new ArrayList<>();
        Ladderlist.add(l1);
        Ladderlist.add(l2);
        Ladderlist.add(l3);
        Ladderlist.add(l4);
        Ladderlist.add(l5);
        Ladderlist.add(l6);

        Board play = new Board(dicee,allplayers, Snakelist, Ladderlist, cp, size);
        play.playgame();


    }
}
