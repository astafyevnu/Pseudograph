package chars;

import java.util.ArrayList;

public class Spearman extends Warrior {
    public Spearman(ArrayList<BaseHero> mySide, int x, int y) {
        super(mySide, String.format("%02d", ++Spearman.number), 10, 4, 5, new int[]{1, 3}, 4, x, y);
    }
}