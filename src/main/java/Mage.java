
public class Mage extends Character{
    private int mana; // Solo un mago tiene Maná

    public Mage(String name, int health, int mana) {
        super(name, health);
        this.mana = mana;
    }

    public int getMana() {
        return this.mana;
    }

    public void castSpell(Character target) { // Lanzar hechizo. Un mago puede lanzar echizo a cualquiera
        if (this.mana - 10 >= 0) {
            this.mana -= 10;
            target.receiveDamage(20);
            target.status = Status.POISONED;
        }
    }
    // Metodo para curar. a otro
    public void heal(Character target) { //Metodo para curar. Le pasamos como parametro al objeto que queremos curar
        this.mana -= 15;
        target.health += 20;

    }
}
