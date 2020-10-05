import Control.ControlGame;

public class Main {
    public static void main(String[] args) {

        String gametype = "";

        if (args.length > 0)
        {
            gametype = args[0];
            if (gametype.contains("console")){
                new ControlGame(("console").toUpperCase());
            }
            else if (gametype.contains("gui")){
                new ControlGame(("gui").toUpperCase());
            }
        }
    }
}
