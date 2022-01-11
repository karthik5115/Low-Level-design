import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Board {
    Dice dice;
    Queue<Player>players;
    ArrayList<Transfer> Snakes;
    ArrayList<Transfer> Ladders;
    Map<String,Integer> playerscurrentposition;
    int boardsize;
    public Board(Dice dice, Queue<Player>players,ArrayList<Transfer> Snakes,ArrayList<Transfer> Ladders,Map<String,Integer> playerscurrentposition,int boardsize){
        this.dice = dice;
        this.players = players;
        this.Snakes=Snakes;
        this.Ladders = Ladders;
        this.playerscurrentposition = playerscurrentposition;
        this.boardsize = boardsize;
    }
    public void playgame(){
        while(players.size()>1){
        Player player = players.poll();
        Scanner scan = new Scanner(System.in);
        System.out.println(player.getName()+" press any numeric to roll the dice..");
        int roll = scan.nextInt();
        int dicevalue = dice.rolldice();
        System.out.println(player.getName()+"'s dice value is "+dicevalue);
        int currentposition = playerscurrentposition.get(player.getName());
        int nextcell = currentposition + dicevalue;
        if(nextcell ==boardsize){
            System.out.println(player.getName()+" is won the match!!!");
        }
        else if(nextcell>boardsize){
            players.offer(player);

        } 
        else if(nextcell<boardsize){
            int nextposition = nextcell;
            boolean ty = false;
            for(Transfer t :Snakes){
                if(nextposition ==t.getstartpoint()){
                    nextposition = t.getendpoint();
                }
            }
            if(nextposition != nextcell){
                System.out.println(player.getName()+" is bitten by Snake  at "+ nextcell);
            }
            for(Transfer r :Ladders){
                if(r.getstartpoint()==nextposition){
                    nextposition = r.getendpoint();
                    ty = true;
                }
            }
            if(nextposition != nextcell && ty){
                System.out.println(player.getName()+" is got a ladder  at "+ nextcell);
            }
            if(nextposition == boardsize){
                System.out.println(player.getName()+" win the match..... ");
            }
            else{
                playerscurrentposition.put(player.getName(), nextposition);
                System.out.println(player.getName() +" is at position "+playerscurrentposition.get(player.getName()));
                players.offer(player);
            }
        }
                
    }
}
    
}
