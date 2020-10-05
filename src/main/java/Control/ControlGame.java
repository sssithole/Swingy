package Control;

import View.*;
import org.jetbrains.annotations.NotNull;

public class ControlGame {

    private Idisplay idisplay;

    public ControlGame(@NotNull String view){
        if(view.equals("console".toUpperCase())){
            idisplay  = (Idisplay) new Console();
            idisplay.initGame();

        }
        if(view.equals("gui".toUpperCase())) {
            idisplay = new Gui();
            idisplay.initGame();
        }

        try {
            while (true) {
                run();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void run(){
        idisplay.playGame();
    }
}
