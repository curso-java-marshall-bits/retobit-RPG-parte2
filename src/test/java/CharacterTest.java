import org.junit.jupiter.api.*;

import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class CharacterTest {

    private static class ConcreteCharacterForTesting extends Character {
        public ConcreteCharacterForTesting(String name, int health) {
            super(name, health);
        }
    }


    @Test
    @Order(1)
    @DisplayName("Character es una clase abstracta")
    void testCharacterIsAbstractInitially() {
        try {
            Class<?> characterClass = Class.forName("Character");
            assertTrue(Modifier.isAbstract(characterClass.getModifiers()),
                    "La clase 'Character' DEBE ser abstracta");
        } catch (ClassNotFoundException e) {
            fail("La clase 'Character' no se encontró. Asegúrate de que existe y el nombre del paquete es correcto.");
        }
    }

    @Test
    @Order(2)
    @DisplayName("Constructor de Character y propiedades iniciales")
    void testCharacterConstructorAndInitialProperties() {
        Character char1 = new ConcreteCharacterForTesting("Generic", 100);
        assertNotNull(char1, "No se puede crear un objeto heredado de Character, el resultado es null");
        assertEquals("Generic", char1.name, "La propiedad 'name' no se inicializa correctamente.");
        assertEquals(100, char1.health, "La propiedad 'health' no se inicializa correctamente.");
        assertEquals(Status.REGULAR, char1.status, "La propiedad 'status' no se inicializa a REGULAR por defecto.");
    }

    @Test
    @Order(3)
    @DisplayName("Implementación de isAlive()")
    void testIsAliveMethod() {
        Character aliveChar = new ConcreteCharacterForTesting("Alive Character", 10);
        assertTrue(aliveChar.isAlive(), "isAlive() debería devolver true cuando la salud es > 0.");

        Character deadChar = new ConcreteCharacterForTesting("Dead Character", 0);

        assertFalse(deadChar.isAlive(), "isAlive() debería devolver false cuando la salud es 0.");

    }

    @Test
    @Order(4)
    @DisplayName("Implementación de getCurrentHealth()")
    void testGetCurrentHealthMethod() {
        Character char1 = new ConcreteCharacterForTesting("Health Checker", 75);
        assertEquals(75, char1.getCurrentHealth(), "getCurrentHealth() debería devolver la salud actual.");

        Character char2 = new ConcreteCharacterForTesting("Zero Health", 0);
        assertEquals(0, char2.getCurrentHealth(), "getCurrentHealth() debería devolver 0 cuando la salud es 0.");
    }

    @Test
    @Order(5)
    @DisplayName("Implementación de getName()")
    void testGetNameMethod() {
        Character char1 = new ConcreteCharacterForTesting("MyName", 50);
        assertEquals("MyName", char1.getName(), "getName() debería devolver el nombre asignado.");
    }

    @Test
    @Order(6)
    @DisplayName("Implementación de getStatus()")
    void testGetStatusMethod() {
        Character char1 = new ConcreteCharacterForTesting("Status Check", 1);
        assertEquals(Status.REGULAR.name(), char1.getStatus(), "getStatus() debe devolver el estado REGULAR inicial.");

        // Prueba de cambio de estado (si la lógica de receiveDamage lo permite)
        char1.receiveDamage(100); // Asumiendo que esto mata al personaje
        assertEquals(Status.DEAD.name(), char1.getStatus(), "getStatus() debe devolver el estado DEAD después de morir.");
    }

    @Test
    @Order(7)
    @DisplayName("Implementación de receiveDamage() - Reducción de salud y mínimo 0")
    void testReceiveDamageMethodHealthReduction() {
        Character char1 = new ConcreteCharacterForTesting("Damage Taker", 100);
        char1.receiveDamage(30);
        assertEquals(70, char1.getCurrentHealth(), "receiveDamage() no reduce la salud correctamente.");

        char1.receiveDamage(70); // Daño para dejarlo en 0
        assertEquals(0, char1.getCurrentHealth(), "receiveDamage() debería dejar la salud en 0, no negativa.");

        char1.receiveDamage(10); // Daño extra a un personaje ya muerto/en 0
        assertEquals(0, char1.getCurrentHealth(), "receiveDamage() no debería reducir la salud por debajo de 0.");
    }

    @Test
    @Order(8)
    @DisplayName("Implementación de receiveDamage() - Cambio de estado a DEAD")
    void testReceiveDamageMethodStatusChange() {
        Character char1 = new ConcreteCharacterForTesting("Dying Guy", 10);
        assertEquals(Status.REGULAR.name(), char1.getStatus(), "El estado inicial debería ser REGULAR.");

        char1.receiveDamage(5);
        assertEquals(Status.REGULAR.name(), char1.getStatus(), "El estado debería seguir siendo REGULAR si la salud es > 0.");

        char1.receiveDamage(5); // Llevarlo a 0 de salud
        assertEquals(0, char1.getCurrentHealth(), "La salud debe ser 0.");
        assertEquals(Status.DEAD.name(), char1.getStatus(), "El estado debería cambiar a DEAD cuando la salud llega a 0.");

        Character char2 = new ConcreteCharacterForTesting("Instant Death", 50);
        char2.receiveDamage(100); // Matarlo de un golpe
        assertEquals(0, char2.getCurrentHealth(), "La salud debe ser 0 después de un golpe letal.");
        assertEquals(Status.DEAD.name(), char2.getStatus(), "El estado debería cambiar a DEAD con un golpe letal.");
    }

    @Test
    @Order(9)
    @DisplayName("La clase Mage no existe")
    void testMageClassShouldNotExistYet() {
        try {
            Class.forName("Mage");
            fail("Tu jefe ha especificado que esta clase no se debe crear todavía");
        } catch (ClassNotFoundException e) {
            assertTrue(true, "La clase 'Mage' aún no existe, lo cual es correcto para esta fase.");
        }
    }

    @Test
    @Order(10) // Ponerlo en un orden bajo para que se ejecute antes
    @DisplayName("La clase Warrior no existe")
    void testWarriorClassShouldNotExistYet() {
        try {
            Class.forName("Warrior");
            fail("Tu manager ha especificado que la clase Warrior todavía no debe ser creada.");
        } catch (ClassNotFoundException e) {
            assertTrue(true, "La clase 'Warrior' aún no existe, lo cual es correcto para esta fase.");
        }
    }
}
