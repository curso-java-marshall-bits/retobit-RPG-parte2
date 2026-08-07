
public class Warrior extends Character{
	
	private int strength = 0; 

	protected Warrior(String name, int health, int strength) {
		super(name, health);
		this.strength = strength;
	}
	
	public void performHeavyAttack(Character target) {
		target.health = target.health - this.strength;
	}
	
	public void enterBerserkMode() {
		this.status = Status.FURIOUS;
	}
	
	public int getStrength() {
		return this.strength;
	}
}
