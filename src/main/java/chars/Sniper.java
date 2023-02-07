package chars;

import java.util.ArrayList;

public class Sniper extends Archer{
    public Sniper(ArrayList<BaseHero> mySide, int x, int y) {
        super(mySide, String.format("%02d", ++Sniper.number), 15, 12, 10, new int[]{8, 10}, 9, 32, x, y);
    }
}