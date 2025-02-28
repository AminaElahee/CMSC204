/*
 * Class: CMSC204
 * Instructor: Khandan Monshi   
 * Description: Notation
 * Due: 02/27/2025
 * Platform/compiler:
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: _Amina Elahee_
*/

public class Notation {

	public Notation() {
	}

	public static double evaluatePostfixExpression​(String postfixExpr)throws InvalidNotationFormatException, StackOverflowException {
		MyStack<Double> stack = new MyStack<>(postfixExpr.length());

		try {
			for (char current : postfixExpr.toCharArray()) {
				if (current == ' ') {
					continue;
				} 
				else if (Character.isDigit(current)) {
					stack.push((double) (current - '0'));
				} 
				else if ("+-*/".indexOf(current) != -1) {
					if (stack.size() < 2) {
						throw new InvalidNotationFormatException("The postfix expression is invalid.");
					}
					double second = stack.pop();
					double first = stack.pop();
					switch (current) {
					case '+':
						stack.push(first + second);
						break;
					case '-':
						stack.push(first - second);
						break;
					case '*':
						stack.push(first * second);
						break;
					case '/':
						if (second == 0)
							throw new ArithmeticException("Cannot divide by zero.");
						stack.push(first / second);
						break;
					}
				}
				else {
					throw new InvalidNotationFormatException("The postfix expression is invalid.");
				}
			}
			if (stack.size() != 1) {
				throw new InvalidNotationFormatException("The postfix expression is invalid.");
			}
			return stack.pop();
		}
		catch (StackUnderflowException | StackOverflowException e) {
			throw new InvalidNotationFormatException("The postfix expression is invalid.");
		}

	}

	public static String convertPostfixToInfix​(String postfix) throws InvalidNotationFormatException {
		MyStack<String> stack = new MyStack<>(postfix.length());

		try {
			for (char current : postfix.toCharArray()) {
				if (current == ' ') {
					continue;
				}
				else if (Character.isDigit(current)) {
					stack.push(String.valueOf(current));
				}
				else if (current == '*' || current == '/' || current == '+' || current == '-') 
				{
					if (stack.size() < 2) {
						throw new InvalidNotationFormatException(
								"This should have thrown an InvalidNotationFormatException");
					}

					String second = stack.pop();
					String first = stack.pop();
					String infix = "(" + first + current + second + ")";
					stack.push(infix);
				} 
				else {
					throw new InvalidNotationFormatException(
							"This should have thrown an InvalidNotationFormatException");
				}
			}

			if (stack.size() != 1) {
				throw new InvalidNotationFormatException("This should have thrown an InvalidNotationFormatException");
			}

			return stack.pop();
		} catch (StackOverflowException | StackUnderflowException e) {
			throw new InvalidNotationFormatException("This should have thrown an InvalidNotationFormatException");
		}
	}

	public static String convertInfixToPostfix​(String infix) throws InvalidNotationFormatException {
		MyQueue<Character> queue = new MyQueue<>(infix.length());
		MyStack<Character> stack = new MyStack<>(infix.length());

		try {
			for (char current : infix.toCharArray()) {
				if (current == ' ') {
					continue;
				}
				else if (Character.isDigit(current)) {
					queue.enqueue(current);
				} 
				else if (current == '(') {
					stack.push(current);
				}
				else if (current == '*' || current == '/' || current == '+' || current == '-') {
					while (!stack.isEmpty() && stack.top() != '(' && Extra(stack.top()) >= Extra(current)) {
						queue.enqueue(stack.pop());
					}
					stack.push(current);
				} 
				else if (current == ')') {

					while (!stack.isEmpty() && stack.top() != '(') {
						queue.enqueue(stack.pop());
					}
					if (stack.isEmpty()) {
						throw new InvalidNotationFormatException("The infix expression is invalid.");
					}
					stack.pop();
				} 
				else {
					throw new InvalidNotationFormatException("The infix expression is invalid.");
				}
			}

			while (!stack.isEmpty()) {
				char top = stack.pop();
				if (top == '(') {
					throw new InvalidNotationFormatException("The infix expression is invalid.");
				}
				queue.enqueue(top);
			}

		} 
		catch (QueueOverflowException | StackOverflowException | StackUnderflowException e) 
		{
			throw new InvalidNotationFormatException("The infix expression is invalid.");
		}

		return queue.toString();
	}

	private static int Extra(char item) {
		switch (item) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return -1;
		}
	}

}
