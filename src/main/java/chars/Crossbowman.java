package chars;

import java.util.ArrayList;

public class Crossbowman extends Archer {

    public Crossbowman(ArrayList<BaseHero> mySide, int x, int y) {
        super(mySide, String.format("%02d", ++Crossbowman.number), 6, 3, 10, new int[]{2, 3}, 4, 16, x, y);
    }
}