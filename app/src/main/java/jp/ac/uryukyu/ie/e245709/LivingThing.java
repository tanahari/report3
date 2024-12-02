package jp.ac.uryukyu.ie.e245709;


public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        this.hitPoint = maximumHP;
        this.attack = attack;
        this.dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    public boolean isDead() {
        return this.dead;
    }

    public String getName() {
        return this.name;
    }

    public int getHitPoint() {
        return this.hitPoint;
    }

    public int getAttck() {
        return this.attack;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public void attack(LivingThing opponent) {
        if ( hitPoint > 0) {
            int damage = (int)(Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
            }
    }

    public  void wounded(int damage) {
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            setDead(dead);
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}
