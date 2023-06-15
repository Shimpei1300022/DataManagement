import java.util.Random;

class DiceGame{
    
    public static void main(String[] args){
        Random rnd = new Random();
        System.out.println("Rolling dice...");

        int x = rnd.nextInt(6) + 1;
        System.out.println("Die 1: " + x);
        
        int y = rnd.nextInt(6) + 1;
        System.out.println("Die 2: " + y);

        System.out.println("Total value: " + (x+y));
        if(x+y > 7)System.out.println("You won");
        else System.out.println("You lost");
    }
}