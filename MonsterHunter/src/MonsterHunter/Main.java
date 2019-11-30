package MonsterHunter;

public class Main {

    Main() {

    }

    public static void main(String[] args) {
        Game game = new Game();
        boolean running = true;
        while(running) {
            running = game.play();
        }
    }
}
