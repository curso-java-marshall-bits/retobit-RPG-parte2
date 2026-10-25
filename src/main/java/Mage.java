public class Mage extends Character {

    protected int mana;
    public Mage(String name, int health, int mana) {
        super(name, health);          // reutiliza el constructor de Character
        this.mana = mana;     // lo nuevo, propio del Mago
    }
    public void castSpell(Character target) {
        if (this.mana <10){
            System.out.println("No tienes el mana suficiente");

        }else{
        this.mana=(this.mana-10);
        target.receiveDamage(5);
        target.status= Status.POISONED;
        }
    }

    public void heal(Character target) {
        if (this.mana <15){
            System.out.println("No tienes el mana suficiente");

        }else{
            this.mana=(this.mana-15);
            target.health=target.health+20;

        }
    }

    public int getMana() {
        return mana;     // temporal, solo para compilar
    }


}
