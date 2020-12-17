package week5;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestExamplesTest {
	@Test
	void teste_null() {
		double result = TestExamples.norm(0, 0);
		assertEquals(0, result);
	}

	@Test
	void teste_negativ() {
		double result = TestExamples.norm(-4, 3);
		assertEquals(5.0, result);
	}
}
