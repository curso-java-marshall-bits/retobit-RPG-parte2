import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MageTest {

    static boolean isMageClassAvailable() {
        try {
            Class.forName("Mage");
            new Mage("TestMage", 1, 1);
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("Clase 'Mage' no encontrada. Los tests de Mage se saltarán.");
            return false;
        } catch (NoClassDefFoundError | Exception e) {
            System.out.println("La clase 'Mage' existe pero no compila o su constructor/dependencias son incorrectas. Los tests de Mage se saltarán. Error: " + e.getMessage());
            return false;
        }
    }

    @Test
    @Order(1)
    @DisplayName("Mage: Herencia de Character y Constructor con propiedad 'mana'")
    @EnabledIf("MageTest#isMageClassAvailable")
    void testMageConstructorAndProperties() {
        Mage mage = new Mage("Gandalf", 80, 50);

        assertNotNull(mage, "El objeto Mage no debe ser nulo después de la instanciación.");
        assertEquals("Gandalf", mage.name, "La propiedad 'name' heredada no se inicializa correctamente.");
        assertEquals(80, mage.health, "La propiedad 'health' heredada no se inicializa correctamente.");
        assertEquals(Status.REGULAR, mage.status, "La propiedad 'status' heredada no se inicializa a REGULAR por defecto.");
        assertEquals(50, mage.getMana(), "La propiedad 'mana' de Mage no se inicializa correctamente.");
    }

    @Test
    @Order(2)
    @DisplayName("Mage: Implementación de métodos heredados de Combatant")
    @EnabledIf("MageTest#isMageClassAvailable")
    void testMageInheritedCombatantMethods() {
        Mage mage = new Mage("Elminster", 100, 75);

        assertTrue(mage.isAlive(), "isAlive() debería devolver true para un Mago con salud > 0.");
        mage.receiveDamage(100);
        assertFalse(mage.isAlive(), "isAlive() debería devolver false para un Mago con salud = 0.");

        Mage testMageHealth = new Mage("Test Health Mage", 65, 30);
        assertEquals(65, testMageHealth.getCurrentHealth(), "getCurrentHealth() debería devolver la salud actual del Mago.");
        assertEquals("Test Health Mage", testMageHealth.getName(), "getName() debería devolver el nombre del Mago.");
        assertEquals(Status.REGULAR.name(), testMageHealth.getStatus(), "getStatus() debería devolver REGULAR para un Mago inicial.");
        testMageHealth.receiveDamage(100);
        assertEquals(Status.DEAD.name(), testMageHealth.getStatus(), "getStatus() debería devolver DEAD para un Mago muerto.");

        Mage damageMage = new Mage("Damaged Mage", 50, 20);
        damageMage.receiveDamage(20);
        assertEquals(30, damageMage.getCurrentHealth(), "receiveDamage() no reduce la salud del Mago correctamente.");
        damageMage.receiveDamage(50);
        assertEquals(0, damageMage.getCurrentHealth(), "receiveDamage() no fija la salud del Mago en 0 al morir.");
        assertEquals(Status.DEAD.name(), damageMage.getStatus(), "receiveDamage() no cambia el estado del Mago a DEAD al morir.");
    }

    @Test
    @Order(3)
    @DisplayName("Mage: Método castSpell() - Consume mana y causa daño/estado")
    @EnabledIf("MageTest#isMageClassAvailable")
    void testCastSpellMethod() {
        Mage mage = new Mage("Merlin", 100, 50);
        Mage target = new Mage("Goblin", 30, 0);

        int initialMana = mage.getMana();
        int initialTargetHealth = target.health;

        mage.castSpell(target);

       assertTrue(mage.getMana() < initialMana, "castSpell() debería consumir 10 de mana.");
        assertEquals(initialMana - 10, mage.getMana(), "castSpell() no consume la cantidad correcta de mana.");

        assertTrue(target.health < initialTargetHealth, "castSpell() debería causar daño al objetivo.");
        assertEquals(Status.POISONED, target.status, "castSpell() debería cambiar el estado del objetivo a POISONED.");

        Mage lowManaMage = new Mage("LowMana", 100, 5);
        lowManaMage.castSpell(target);
        assertEquals(5, lowManaMage.getMana(), "castSpell() el maná no debería ser negativo. Si no hay suficiente el spell no se lanza.");
    }

    @Test
    @Order(4)
    @DisplayName("Mage: Método heal() - Consume mana y restaura salud")
    @EnabledIf("MageTest#isMageClassAvailable")
    void testHealMethod() {
        Mage healer = new Mage("Healer", 100, 40);
        Mage injuredAlly = new Mage("Injured", 50, 20);
        injuredAlly.receiveDamage(30);

        int initialMana = healer.getMana();
        int allyHealthBeforeHeal = injuredAlly.health;

        healer.heal(injuredAlly);

        assertTrue(healer.getMana() < initialMana, "heal() debería consumir 15 de mana.");
        assertEquals(initialMana - 15, healer.getMana(), "heal() no consume la cantidad correcta de mana.");

        assertTrue(injuredAlly.health > allyHealthBeforeHeal, "heal() debería restaurar 20 de salud del aliado.");
        assertEquals(allyHealthBeforeHeal + 20, injuredAlly.health, "heal() no restaura la cantidad correcta de salud.");

    }
}
