public class Warrior extends Character {

    int strength=25;

    // 🏗️ CONSTRUCTOR
    public Warrior(String name, int health, int strength) {
        super(name, health);
        this.strength = strength;
    }

    // Métodos específicos del guerrero

    public void performHeavyAttack(Character target) {
        int damage = this.strength ; // El ataque pesado hace daño igual a la fuerza del guerrero
        target.receiveDamage(damage);
        System.out.println(this.name + " realiza un ataque pesado a " + target.getName() + " causando " + damage + " de daño.");
        System.out.println(target.getName()+ " recibe el ataque pesado " +damage+ " de daño. Salud restante: " + (this.strength- target.getCurrentHealth()));
    }

    public void enterBerserkMode() {
        this.strength += 5; // El guerrero aumenta su fuerza en 5 puntos
        this.status = Status.FURIOUS; // Cambia el estado a BERSERK
        System.out.println(this.name + " entra en modo berserker. Fuerza actual: " + this.strength);
    }

    public int getStrength() {
        System.out.println(this.name + " tiene una fuerza de " + this.strength);
        return strength;
    }
}