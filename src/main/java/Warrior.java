public class Warrior extends Character{
    private int strength;

    public Warrior(String name, int health,int strength){
        //reutilizar la clase base
        super(name,health);
        //Añadimos las nuevas propiedades
        this.strength = strength;
    }

    //(performHeavyAttack void , enterBerserkMode void, getStrength int).

    public void performHeavyAttack(Character target){
        target.receiveDamage(strength);

    }

    public void enterBerserkMode(){
        this.status = Status.FURIOUS;


    }

    public int getStrength(){

        return strength;
    }
}
