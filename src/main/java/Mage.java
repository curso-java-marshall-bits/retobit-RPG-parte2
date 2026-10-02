public class Mage extends Character{
    private int mana;

    public Mage (String name, int health,int mana){
        //reutilizar la clase base
        super(name,health);
        //Añadimos las nuevas propiedades
        this.mana = mana;
    }

    public void castSpell(Character target) {

        if(this.mana >= 10){ // si es mayor o igual a 10
            this.mana -= 10; //se le resta solo si no es negativo
            target.receiveDamage(20);
            //System.out.println(target.status); el metodo receiveDamage le cambia el status según ciertas condiciones, pero no hay problema porque abajo le reasignamos lo que se nos pide.
            target.status = Status.POISONED;
        }
    }



    public void heal(Character target){
        if(this.mana >= 15){ // si es mayor o igual a 10
            this.mana -= 15;// nos aseguramos de que no es negativo
            target.health = target.health + 20;
        }
    }

    public int getMana(){

        //System.out.println("Este es tu mana actual: " + mana);
        return mana ;
    }
}
