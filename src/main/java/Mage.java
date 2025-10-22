public class Mage extends Character{
    private int mana;

    public Mage(String name, int health, int mana) {
        super(name, health);
        this.mana = mana;
    }

    public void castSpell (Character character){
        if (mana < 10) return;
        mana -= 10;

        character.health -= 20;
        character.status = Status.POISONED;
    }

    public void heal (Character character){
        if (mana < 15) return;
        mana -= 15;

        character.health += 20;
    }

    public int getMana(){
        return mana;
    }
}
