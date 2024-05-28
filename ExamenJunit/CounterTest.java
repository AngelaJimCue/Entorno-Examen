package junito.mipaquete;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CounterTest {
	private Counter counter1;
	private Counter counter2;
	private Counter counter3;
	
	@BeforeEach
	public void sepUp() {
		counter1 = new Counter();
		counter2 = new Counter (100_000); 
		counter3 = new Counter (8,"junito");
	}
	
	
	@Test
	public void testConstructorSinValores() {
		assertEquals(0, counter1.getValue());
		assertEquals(0, counter1.getValue());
		assertEquals("N-COUNTER", counter1.getModel());
	}


	@Test
	public void testConstructorCopia() {
		Counter counterCopia= new Counter(counter3);
		assertEquals(0, counterCopia.getValue());
		assertEquals(8, counterCopia.getMaxValue());
		assertEquals("junito",counterCopia.getModel());
	}


	@Test
	public void testIncrementoVacioTrue() {
		assertTrue(counter1.increment());
		assertEquals(1, counter1.getValue());		
		assertTrue(counter1.increment());
		assertEquals(2, counter1.getValue());
		
		assertTrue(counter2.increment());
		assertEquals(1, counter2.getValue());
		
		assertTrue(counter3.increment());
		assertEquals(1, counter3.getValue());
	}	
	@Test
	public void testIncrementoVacioFalse() {
		counter1.increment(100_000);
		assertFalse(counter1.increment());
		
		counter2.increment(100_000);
		assertFalse(counter2.increment());
		
		counter3.increment(100_000);
		assertFalse(counter3.increment());
	}
	

	@Test
	public void testIncrementoNumero() {
		assertTrue(counter2.increment(3));
		assertEquals(3, counter2.getValue());
		
		assertFalse(counter3.increment(23));
		assertEquals(8, counter3.getValue());
	}
	
	@Test
	public void testIncrementoNumeroMaximoValor() {		
		assertFalse(counter1.increment(Integer.MAX_VALUE));
		assertEquals(100_000, counter1.getValue());
		
		assertFalse(counter2.increment(Integer.MAX_VALUE));
		assertEquals(100_000, counter2.getValue());
		
		assertFalse(counter3.increment(Integer.MAX_VALUE));
		assertEquals(8, counter3.getValue());
		
	}
	@Test
	public void testIncrementoNumeroExcepciones() {	
		assertThrows(IllegalArgumentException.class,()-> counter1.increment(-8));
		assertThrows(IllegalArgumentException.class,()-> counter1.increment(0));
		
		assertThrows(IllegalArgumentException.class,()-> counter2.increment(-23));
		assertThrows(IllegalArgumentException.class,()-> counter2.increment(0));
		
		assertThrows(IllegalArgumentException.class,()-> counter3.increment(-2024));
		assertThrows(IllegalArgumentException.class,()-> counter3.increment(0));
	}
 
	
	@Test
	public void testToString() {
		assertEquals("Contador: modelo (N-COUNTER) y valor 0 de 100000", 
				counter1.toString(), "toString incorrecto");
		assertEquals("Contador: modelo (N-COUNTER) y valor 0 de 100000", 
				counter2.toString(), "toString incorrecto");
		assertEquals("Contador: modelo (junito) y valor 0 de 8", 
				counter3.toString(), "toString incorrecto");
	}
	
}
