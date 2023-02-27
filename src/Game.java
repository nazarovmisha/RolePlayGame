import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Game {
    private static BufferedReader br;
    private static Battle battle=null;
    private static Entity player = null;

    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        battle = new Battle();
        System.out.println("Как зовут нашего героя?");

    }
    public static void command(String string){
        switch (string){

        }
    }
}
