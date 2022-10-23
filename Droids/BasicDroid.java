package Droids;

public class BasicDroid {
    private int hp = 6000;
    private int damage = 1000;

    public int Use(){
        return damage;
    }

    public int UseLikeBot(){
        return damage;
    }

    public boolean IsAlive(){
        if(hp>0){
            return true;
        }
        return false;
    }

    public int getDamage() {
        return damage;
    }

    public int getHp() {
        return hp;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public String toString() {
        return "BasicDroid{" +
                "hp=" + hp +
                ", damage=" + damage +
                '}';
    }
}
