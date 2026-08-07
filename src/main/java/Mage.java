
public class Mage extends Character{
	
	private int mana = 0;
	
	protected Mage(String name, int health, int mana) {
		super(name, health);
		this.mana = mana;
	}
	
	public void castSpell(Character target) {
		this.mana = this.mana -10;
		if(this.mana >= 1) {
			target.health = target.health - health;
			target.status = Status.POISONED;
		}else {
			this.mana = 5;
		}
	}
	
	public void heal(Character target) {
		this.mana = this.mana -15;
		target.health = target.health +20;
	}
	
	public int getMana() {
		return this.mana;
	}

}
