 
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class NotationTestStudent {
	 public String complexInfix = "(10 + (((6 * 3) - (((9 / 3) - 2) * 5)) * 4))";
	    public String complexPostfix = "10363*93/2-5*4*-+";
	    public String easyInfix = "(8 + 2)";
	    public String easyPostfix = "82+";
	    public String intermediateInfix = "((2 * (6 + 3)) + 4)";
	    public String intermediatePostfix = "263+*4+";

	    public String invalidPostfixExpression = "263+*4+-";
	    public String invalidInfixExpression = "(10 + 2) * 5))";

	  	    public double evalComplexPostfix = 70.0;
	    public double evalIntermediatePostfix = 22.0;
	    public double evalEasyPostfix = 10.0;

	    @BeforeEach    
	    public void setUp() throws Exception {
	    }

	    @AfterEach
	    public void tearDown() throws Exception {
	    }

	    // Test conversion from infix to postfix
	    @Test
	    public void testComplexConvertInfixToPostfix() throws InvalidNotationFormatException {
	        try {
	            String postfixResult = Notation.convertInfixToPostfix​(complexInfix);
	            assertEquals("10363*93/2-5*4*-+", postfixResult);
	        } catch (InvalidNotationFormatException e) {
	            fail("Exception should not have been thrown");
	        }
	    }

	    @Test
	    public void testIntermediateConvertInfixToPostfix() throws InvalidNotationFormatException {
	        try {
	            String postfixResult = Notation.convertInfixToPostfix​(intermediateInfix);
	            assertEquals("263+*4+", postfixResult);
	        } catch (InvalidNotationFormatException e) {
	            fail("Exception should not have been thrown");
	        }
	    }

	    @Test
	    public void testEasyConvertInfixToPostfix() throws InvalidNotationFormatException {
	        try {
	            String postfixResult = Notation.convertInfixToPostfix​(easyInfix);
	            assertEquals("82+", postfixResult);
	        } catch (InvalidNotationFormatException e) {
	            fail("Exception should not have been thrown");
	        }
	    }

	    @Test
	    public void testInvalidInfixExpression() {
	        try {
	            Notation.convertInfixToPostfix​(invalidInfixExpression);
	            fail("This should have thrown an InvalidNotationFormatException");
	        } catch (InvalidNotationFormatException e) {
	        }
	    }

	  
	    @Test
	    public void testComplexConvertPostfixToInfix() throws InvalidNotationFormatException {
	        try {
	            String infixResult = Notation.convertPostfixToInfix​(complexPostfix);
	            assertEquals("(10 + (((6 * 3) - (((9 / 3) - 2) * 5)) * 4))", infixResult);
	        } catch (InvalidNotationFormatException e) {
	            fail("Exception should not have been thrown");
	        }
	    }

	    @Test
	    public void testIntermediateConvertPostfixToInfix() throws InvalidNotationFormatException {
	        try {
	            String infixResult = Notation.convertPostfixToInfix​(intermediatePostfix);
	            assertEquals("((2 * (6 + 3)) + 4)", infixResult);
	        } catch (InvalidNotationFormatException e) {
	            fail("Exception should not have been thrown");
	        }
	    }

	    @Test
	    public void testEasyConvertPostfixToInfix() throws InvalidNotationFormatException {
	        try {
	            String infixResult = Notation.convertPostfixToInfix​(easyPostfix);
	            assertEquals("(8 + 2)", infixResult);
	        } catch (InvalidNotationFormatException e) {
	            fail("Exception should not have been thrown");
	        }
	    }

	    @Test
	    public void testInvalidPostfixExpressionB() {
	        try {
	            Notation.convertPostfixToInfix​(invalidPostfixExpression);
	            fail("This should have thrown an InvalidNotationFormatException");
	        } catch (InvalidNotationFormatException e) {
	        }
	    }

	    @Test
	    public void testComplexEvaluatePostfixExpression() throws InvalidNotationFormatException, StackOverflowException {
	        try {
	            double result = Notation.evaluatePostfixExpression​(complexPostfix);
	            assertEquals(evalComplexPostfix, result, .001);
	        } catch (Exception e) {
	            fail("Exception should not have been thrown");
	        }
	    }

	    @Test
	    public void testIntermediateEvaluatePostfixExpression() throws InvalidNotationFormatException, StackOverflowException {
	        try {
	            double result = Notation.evaluatePostfixExpression​(intermediatePostfix);
	            assertEquals(evalIntermediatePostfix, result, .001);
	        } catch (Exception e) {
	            fail("Exception should not have been thrown");
	        }
	    }

	    @Test
	    public void testEasyEvaluatePostfixExpression() throws InvalidNotationFormatException, StackOverflowException {
	        try {
	            double result = Notation.evaluatePostfixExpression​(easyPostfix);
	            assertEquals(evalEasyPostfix, result, .001);
	        } catch (Exception e) {
	            fail("Exception should not have been thrown");
	        }
	    }

	    @Test
	    public void testInvalidPostfixExpressionA() throws StackOverflowException {
	        try {
	            Notation.evaluatePostfixExpression​(invalidPostfixExpression);
	            fail("This should have thrown an InvalidNotationFormatException");
	        } catch (InvalidNotationFormatException e) {
	        }
	    }
}
