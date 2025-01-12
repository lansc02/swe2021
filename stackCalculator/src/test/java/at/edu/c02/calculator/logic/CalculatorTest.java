package at.edu.c02.calculator.logic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import at.edu.c02.calculator.Calculator;
import at.edu.c02.calculator.CalculatorException;
import at.edu.c02.calculator.Calculator.Operation;
import at.edu.c02.calculator.logic.CalculatorImpl;

public class CalculatorTest {

	@Test
	public void testSimpleAddOperation() throws Exception {

		//setup
		Calculator calc = new CalculatorImpl();
		
		//execute
		calc.push(2.0);
		calc.push(3);
		double result = calc.perform(Operation.add);

		//verify
		assertEquals(5, result, 0);
		

	}
	
	@Test
	public void testSimpleMulOperation() throws Exception {

		Calculator calc = new CalculatorImpl();
		calc.push(2.0);
		calc.push(3);
		double result = calc.perform(Operation.mul);

		assertEquals(6, result, 0);

	}
	
	@Test
	public void testSimpleDivOperation() throws Exception {

		Calculator calc = new CalculatorImpl();
		calc.push(6.0);
		calc.push(2);
		double result = calc.perform(Operation.div);

		assertEquals(2, result, 0);

	}

	@Test
	public void testSimpleModOperation1() throws Exception {

		Calculator calc = new CalculatorImpl();
		calc.push(20.0);
		calc.push(10);
		double result = calc.perform(Operation.mod);

		assertEquals(0, result, 0);

	}

	@Test
	public void testSimpleModOperation2() throws Exception {

		// Windows Rechner ist Referenz

		Calculator calc = new CalculatorImpl();
		calc.push(26.0);
		calc.push(-6.0);
		double result = calc.perform(Operation.mod);

		assertEquals(-4, result, 0);

	}

	@Test
	public void testSimpleModOperation3() throws Exception {

		// Windows Rechner ist Referenz

		Calculator calc = new CalculatorImpl();
		calc.push(-45);
		calc.push(10);
		double result = calc.perform(Operation.mod);

		assertEquals(5, result, 0);

	}

	@Test
	public void testSimpleModOperation4() throws Exception {

		Calculator calc = new CalculatorImpl();

		try {
			calc.push(0);
			calc.push(0);
			calc.perform(Operation.mod);

			fail("Exception expected");


		} catch (CalculatorException e) {
			assertEquals("Modulo with zero", e.getMessage());
			// e.getCause()
		}

	}




	@Test
	public void testSimpleModOperation5() throws Exception {

		Calculator calc = new CalculatorImpl();
		calc.push(4);
		calc.push(84);
		double result = calc.perform(Operation.mod);

		assertEquals(4, result, 0);

	}

	
	
	

	//
	@Test(expected = CalculatorException.class)
	public void testPopOnEmptyStack() throws Exception {

		Calculator calc = new CalculatorImpl();
		calc.pop();

	}

	@Test
	public void testDivisionByZero() throws Exception {

		//Setup
		Calculator calc = new CalculatorImpl();
		try {
			calc.push(2);
			calc.push(0);
			calc.perform(Operation.div);

			fail("Exception expected");
			

		} catch (CalculatorException e) {
			assertEquals("Division by zero", e.getMessage());
			// e.getCause()
		}

	}
}
