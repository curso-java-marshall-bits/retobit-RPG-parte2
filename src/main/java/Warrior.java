public class Warrior extends Character{
    int Strenght;
    public Warrior(String name, int health,int strenght) {
        super(name, health);
        this.Strenght=strenght;
    }

    public int getStrength(){
        return this.Strenght;
    }
    public void performHeavyAttack(Character target){
     target.health-=this.Strenght;

    }
    public void enterBerserkMode(){
    this.status=Status.FURIOUS;
    }
}
