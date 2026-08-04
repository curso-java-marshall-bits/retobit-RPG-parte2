public class Warrior extends Character{
    private int strength; // Solo los guerreros tienene fuerza


    public Warrior(String name, int health, int strength) {
        super(name, health);
        this.strength = strength;
    }

    public int getStrength(){
        return this.strength;
    }

    public void performHeavyAttack(Character target) { // Ejecutar Ataque a otro objeto
        target.receiveDamage(this.strength);
    }

    public void enterBerserkMode(){ // activar modo frenesí
        this.status = Status.FURIOUS;
    }


}
