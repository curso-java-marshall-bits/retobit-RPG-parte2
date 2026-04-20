public class Mage extends Character {

    int mana=50;


    // 🏗️ CONSTRUCTOR
    public Mage(String name, int health, int mana) {
        super(name, health);
         this.mana = mana;
    }

    // Métodos específicos del mago

    public void castSpell(Character target){
        if (mana >= 10){
            mana-=10;
            int damage = 25; // El hechizo hace un daño fijo de 25 puntos
            target.receiveDamage(damage);
            target.status = Status.POISONED;
            System.out.println(this.name + " lanza un hechizo. Mana restante: " + this.mana);
            System.out.println(this.name + " causa " + damage + " de daño a " + target.getName() + ". Salud restante de " + target.getName() + ": " + target.getCurrentHealth());
            System.out.println(target.getName() + " está " + target.getStatus());
            System.out.println(target.getName() + " tiene " + target.getCurrentHealth() + " de salud restante.");
        }
    }

    public void heal(Character target){
        if (mana >= 15){
            mana-=15;
            target.health += 20;
            System.out.println(this.name + " se cura. Salud actual: " + this.health + ". Mana restante: " + this.mana);
        }
    }

    public int getMana(){
        System.out.println(this.name + " tiene " + this.mana + " de mana.");
        return mana;
    }
}
