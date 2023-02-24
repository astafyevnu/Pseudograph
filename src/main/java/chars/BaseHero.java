package chars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public abstract class BaseHero implements BaseInterface {
    protected ArrayList<BaseHero> mySide;
    protected static int number;
    protected static Random r;

    static {
        BaseHero.number = 0;
        BaseHero.r = new Random();
    }

    public String name;
    protected int maxHp;
    public int hp;
    protected int attack;
    protected int defence;
    protected int[] damage;
    protected int speed;
    protected Vector2 position;

    public BaseHero(ArrayList<BaseHero> mySide, String name, int hp, int attack, int defence, int[] damage, int speed, int x, int y) {
        this.position = new Vector2(x, y);
        this.name = name;
        this.maxHp = hp;
        this.hp = hp;
        this.attack = attack;
        this.defence = defence;
        this.damage = damage;
        this.speed = speed;
        this.mySide = mySide;
    }

    @Override
    public String toString() {
        return String.format("%s %s \u2764\ufe0f%02d/%02d  \uD83D\uDDE1️%d  \ud83d\udee1\ufe0f%d  \ud83e\ude78%s  \uD83C\uDFC3%d ",
                name, getClass().getSimpleName(), hp, maxHp, attack, defence, Arrays.toString(damage), speed);
    }

    public void getDamage(int d) {
        if (this.hp - d > 0) {
            this.hp -= d;
            if (this.hp > this.maxHp) {
                this.hp = this.maxHp;
            }
        } else {
            this.hp = 0;
        }
    }

    public float getDistance(int x2, int y2) {
        float dx = x2 - position.x;
        float dy = y2 - position.y;
        return (float)Math.sqrt(dx * dx + dy * dy);

    }

    @Override
    public void step(ArrayList<BaseHero> teamList) {
    }

    public Vector2 getPosition() {
        return position;
    }

    @Override
    public int getInfo() {
        return (hp * 100 / maxHp);
    }

    public String getName() {
        return name;
    }

    public int getIndexPlayerMinHp(ArrayList<BaseHero> teamList) {
        int max = 101;
        int index = -1;
        for (int i = 0; i < teamList.size(); i++) {
//            if (teamList.get(i).hp != 0) {
                if (teamList.get(i).getInfo() < max) {
                    max = teamList.get(i).getInfo();
                    index = i;
                }
//            }
        }
        return index;
    }
}