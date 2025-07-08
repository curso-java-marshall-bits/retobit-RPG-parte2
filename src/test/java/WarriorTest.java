import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledIf;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WarriorTest {

    static boolean isWarriorClassAvailable() {
        try {
            Class.forName("Warrior");
            new Warrior("TestWarrior", 1, 1);
            return true;
        } catch (ClassNotFoundException e) {
            System.out.println("Clase 'Warrior' no encontrada. Los tests de Warrior se saltarán.");
            return false;
        } catch (NoClassDefFoundError | Exception e) {
            System.out.println("La clase 'Warrior' existe pero no compila o su constructor/dependencias son incorrectas. Los tests de Warrior se saltarán. Error: " + e.getMessage());
            return false;
        }
    }

    @Test
    @Order(1)
    @DisplayName("Warrior: Herencia de Character y Constructor con propiedad 'strength'")
    @EnabledIf("WarriorTest#isWarriorClassAvailable")
    void testWarriorConstructorAndProperties() {
        Warrior warrior = new Warrior("Conan", 120, 25);

        assertNotNull(warrior, "El objeto Warrior no debe ser nulo después de la instanciación.");
        assertEquals("Conan", warrior.name, "La propiedad 'name' heredada no se inicializa correctamente.");
        assertEquals(120, warrior.health, "La propiedad 'health' heredada no se inicializa correctamente.");
        assertEquals(Status.REGULAR, warrior.status, "La propiedad 'status' heredada no se inicializa a REGULAR por defecto.");
        assertEquals(25, warrior.strength, "La propiedad 'strength' de Warrior no se inicializa correctamente.");
    }

    @Test
    @Order(2)
    @DisplayName("Warrior: Implementación de métodos heredados de Combatant")
    @EnabledIf("WarriorTest#isWarriorClassAvailable")
    void testWarriorInheritedCombatantMethods() {
        Warrior warrior = new Warrior("Braveheart", 150, 20);

        assertTrue(warrior.isAlive(), "isAlive() debería devolver true para un Guerrero con salud > 0.");
        warrior.receiveDamage(150);
        assertFalse(warrior.isAlive(), "isAlive() debería devolver false para un Guerrero con salud = 0.");

        Warrior testWarriorHealth = new Warrior("Test Warrior Health", 80, 15);
        assertEquals(80, testWarriorHealth.getCurrentHealth(), "getCurrentHealth() debería devolver la salud actual del Guerrero.");
        assertEquals("Test Warrior Health", testWarriorHealth.getName(), "getName() debería devolver el nombre del Guerrero.");
        assertEquals(Status.REGULAR.name(), testWarriorHealth.getStatus(), "getStatus() debería devolver REGULAR para un Guerrero inicial.");
        testWarriorHealth.receiveDamage(100);
        assertEquals(Status.DEAD.name(), testWarriorHealth.getStatus(), "getStatus() debería devolver DEAD para un Guerrero muerto.");

        Warrior damageWarrior = new Warrior("Damaged Warrior", 70, 10);
        damageWarrior.receiveDamage(30);
        assertEquals(40, damageWarrior.getCurrentHealth(), "receiveDamage() no reduce la salud del Guerrero correctamente.");
        damageWarrior.receiveDamage(70);
        assertEquals(0, damageWarrior.getCurrentHealth(), "receiveDamage() no fija la salud del Guerrero en 0 al morir.");
        assertEquals(Status.DEAD.name(), damageWarrior.getStatus(), "receiveDamage() no cambia el estado del Guerrero a DEAD al morir.");
    }

    @Test
    @Order(3)
    @DisplayName("Warrior: Método performHeavyAttack() - Causa daño mayor")
    @EnabledIf("WarriorTest#isWarriorClassAvailable")
    void testPerformHeavyAttackMethod() {
        Warrior warrior = new Warrior("Berserker", 100, 30);
        Mage target = new Mage("Wizard", 50, 20);

        int initialTargetHealth = target.health;

        warrior.performHeavyAttack(target);

        assertTrue(target.health < initialTargetHealth, "performHeavyAttack() debería causar daño al objetivo.");
        assertEquals(initialTargetHealth - warrior.strength, target.health, "performHeavyAttack() debe restar tantos puntos como strength tenga el warrior."); // Asumo daño = strength + 5

    }

    @Test
    @Order(4)
    @DisplayName("Warrior: Método enterBerserkMode() - Cambia estado a FURIOUS")
    @EnabledIf("WarriorTest#isWarriorClassAvailable")
    void testEnterBerserkModeMethod() {
        Warrior warrior = new Warrior("Rager", 100, 20);

        assertEquals(Status.REGULAR, warrior.status, "El estado inicial del Guerrero debería ser REGULAR.");

        warrior.enterBerserkMode();

        assertEquals(Status.FURIOUS, warrior.status, "enterBerserkMode() debería cambiar el estado del Guerrero a FURIOUS.");

    }
}