package chars;

import java.util.ArrayList;

public class Rogue extends Warrior {
    public Rogue(ArrayList<BaseHero> mySide, int x, int y) {
        super(mySide, String.format("%02d", ++Rogue.number), 10, 8, 3, new int[]{2, 4}, 6, x, y);
    }
}