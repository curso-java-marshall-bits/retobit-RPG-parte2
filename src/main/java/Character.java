public abstract class Character implements Combatant {
    // 🗒️ PROPIEDADES
    protected String name; // nombre
    protected int health; //  puntos de vidas
    protected Status status; // estados

    // 🏗️ CONSTRUCTOR
    protected Character(String name, int health) {
        this.name = name;
        this.health = health;
        this.status = Status.REGULAR;
    }

    @Override
    public void receiveDamage(int damage) {
        this.health -= damage;
        if(this.health <= 0){ // si es menor o igual a 0 está muerto
            this.health = 0; // nos aseguramos de que no es negativo
            this.status = Status.DEAD;
        }
    }

    @Override
    public boolean isAlive() {

        return this.health > 0; // True o false
    }

    @Override
    public int getCurrentHealth() {

        return this.health; // salud actual consulta
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getStatus() {
        return this.status.toString();
    }
}