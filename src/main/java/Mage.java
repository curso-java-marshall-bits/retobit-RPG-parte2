public class Mage extends Character{
    private int Mana;

    public Mage(String name, int health,int mana) {
        super(name, health);
        this.Mana=mana;
    }
    public int getMana(){
        return this.Mana;
    }
    public void castSpell(Character Target){
        if (this.Mana<=10){return;}
     this.Mana-=10;
     Target.health--;
     Target.status=Status.POISONED;
    }
    public void heal(Character Target){
    this.Mana-=15;
    Target.health+=20;
    }
}
