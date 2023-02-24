package chars;

import java.util.ArrayList;
import java.util.Random;

public class Healer extends BaseHero {
    protected int magic;

    public Healer(ArrayList<BaseHero> mySide, String name, int hp, int attack, int defence, int[] damage, int speed, int magic, int x, int y) {
        super(mySide, name, hp, attack, defence, damage, speed, x, y);
        this.magic = magic;
    }

    @Override
    public String toString() {
        return String.format("%s %s %-3s", super.toString(), "\ud83d\udd2e", magic);
    }

//    public void step(ArrayList<BaseHero> sideList) {
//        if (this.hp <= 0) {
//            System.out.println(this.name + " " + this.getClass().getSimpleName() + " is dead ☠️");
//        } else {
//            int index = getIndexPlayerMinHp(mySide);
//            int d = r.nextInt(this.damage[0], this.damage[1]);
//            if (index != -1 && mySide.get(index).hp != mySide.get(index).maxHp) {
//                if (mySide.get(index).hp - d > mySide.get(index).maxHp) {
//                    mySide.get(index).hp = mySide.get(index).maxHp;
//                } else {
//                    mySide.get(index).hp -= d;
//                }
//                System.out.println(this.name + " " + this.getClass().getSimpleName() + " \ud83d\ude4c " + (-d) + " \ud83d\udc9a " + mySide.get(index));
//            } else {
//                System.out.println(this.name + " " + this.getClass().getSimpleName() + " \uD83D\uDE34");
//            }
//        }
//    }
    public void step(ArrayList<BaseHero> sideList) {
        if (this.hp <= 0) {
            System.out.println(this.name + " " + this.getClass().getSimpleName() + " is dead ☠️");
        }
        else if (this.magic == 0){
            System.out.println(this.name + " " + this.getClass().getSimpleName() + " \uD83D\uDE34");
            this.magic += 1;
        }else {
            int index = getIndexPlayerMinHp(mySide);
            int d = r.nextInt(this.damage[0], this.damage[1]);
            if (mySide.get(index).hp == 0) {
                switch (new Random().nextInt(6)) {
                    case (0) -> mySide.set(index, new Mage(mySide, mySide.get(index).position.x, mySide.get(index).position.y));
                    case (1) -> mySide.set(index, new Rogue(mySide, mySide.get(index).position.x, mySide.get(index).position.y));
                    case (2) -> mySide.set(index, new Peasant(mySide, mySide.get(index).position.x, mySide.get(index).position.y));
                    case (3) -> mySide.set(index, new Sniper(mySide, mySide.get(index).position.x, mySide.get(index).position.y));
                    case (4) -> mySide.set(index, new Spearman(mySide, mySide.get(index).position.x, mySide.get(index).position.y));
                    case (5) -> mySide.set(index, new Monk(mySide, mySide.get(index).position.x, mySide.get(index).position.y));
                    case (6) -> mySide.set(index, new Crossbowman(mySide, mySide.get(index).position.x, mySide.get(index).position.y));
                }

                System.out.println(this.name + " " + this.getClass().getSimpleName() + " \uD83D\uDE07 resurrection " + mySide.get(index));
                this.magic -= 1;
            }
            if (index != -1 && mySide.get(index).hp != mySide.get(index).maxHp) {
                if (mySide.get(index).hp - d > mySide.get(index).maxHp) {
                    mySide.get(index).hp = mySide.get(index).maxHp;
                } else {
                    mySide.get(index).hp -= d;
                }
                System.out.println(this.name + " " + this.getClass().getSimpleName() + " \ud83d\ude4c " + (-d) + " \ud83d\udc9a " + mySide.get(index));
            } else {
                System.out.println(this.name + " " + this.getClass().getSimpleName() + " \uD83D\uDE34");
            }
        }
    }
}