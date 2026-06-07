public class Mage extends Character{
    private int mana;

    public Mage(String nombre,int health,int mana){
        super(nombre,health);
        this.mana = mana;
    }

    public void castSpell(Character character){
        if(this.mana < 10){
            return;
        }

        this.mana -= 10;



        character.receiveDamage(mana);
        character.status = Status.POISONED;

    }

    public void heal(Character character){
       this.mana -= 15;

       character.health += 20;


    }

    public int getMana(){
        return this.mana;
    }
}
