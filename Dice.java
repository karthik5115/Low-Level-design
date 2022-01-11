public class Dice{
    int NoOfDices;
    public Dice(int NoOfDices){
        this.NoOfDices=NoOfDices;
    }
    public int rolldice(){
        return ((int) (Math.random()*(6*NoOfDices-1*NoOfDices)))+1;
    }
    public int getNoOfDices(){
        return NoOfDices;
    }
}