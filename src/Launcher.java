import gfx.Assets;
import weergave.SpelVenster;

public class Launcher {

    public static void main(String[] args) {
        Assets.init();
        new SpelVenster();
    }
}