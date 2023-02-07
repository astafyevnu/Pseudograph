package chars;

import java.util.ArrayList;

public class Monk extends Healer {
    public Monk(ArrayList<BaseHero> mySide, int x, int y) {
        super(mySide, String.format("%02d", ++Monk.number), 30, 12, 7, new int[]{-4, 0}, 5, 1, x, y);
    }
}