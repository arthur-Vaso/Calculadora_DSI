package controler;

import view.MainWindow;

public class ReadEntry {

	private MainWindow window;
	private ShowOnScreen screen;
	private Calculate calculate;
	private boolean dot = false;
	private boolean minus = false;

	public ReadEntry(MainWindow window, int num) {
		this.window = window;
		numberPressed(num);
	}

	public ReadEntry(MainWindow window, String sign) {
		this.window = window;
		signPressed(sign);
	}

	private void signPressed(String sign) {

		switch (sign) {
		case ".": {
			dot = true;
			if (window.getMemory().getFirstNumber() == null) {
				window.getMemory().setFirstNumber("0.");
				screen = new ShowOnScreen(window, sign, dot, minus);
			} else if (!window.getMemory().getFirstNumber().contains(sign)) {
				window.getMemory().setFirstNumber(window.getMemory().getFirstNumber().concat(sign));
				screen = new ShowOnScreen(window, sign, dot, minus);
			}
			if (window.getMemory().getSecondNumber() == null && window.isOperatorPressed()) {
				window.getMemory().setSecondNumber("0.");
				screen = new ShowOnScreen(window, sign, dot, minus);
			} else if (window.isOperatorPressed() && !window.getMemory().getSecondNumber().contains(sign)) {
				window.getMemory().setSecondNumber(window.getMemory().getSecondNumber().concat(sign));
				screen = new ShowOnScreen(window, sign, dot, minus);
			}
			break;
		}
		case "+", "*": {
			window.setOperator(sign);
			if (window.getMemory().getFirstNumber() != null && !window.isOperatorPressed()) {
				window.setOperatorPressed(true);
				window.getMemory().setOperator(sign);
				screen = new ShowOnScreen(window, sign, dot, minus);
			} else if (window.getMemory().getOperator() != null && window.isOperatorPressed()) {
				calculate = new Calculate(window, sign, dot, minus);
				window.getMemory().setOperator(sign);
			}
			break;
		}
		case "-": {
			window.setOperator(sign);
			minus = true;
			if (window.getMemory().getFirstNumber() == null) {
				window.getMemory().setFirstNumber("-");
				screen = new ShowOnScreen(window, sign, dot, minus);
			} else if (window.getMemory().getSecondNumber() == null && window.isOperatorPressed()) {
				window.getMemory().setSecondNumber("-");
				screen = new ShowOnScreen(window, sign, dot, minus);
			} else if (window.getMemory().getOperator() != null && window.isOperatorPressed()) {
				calculate = new Calculate(window, sign, dot, minus);
				window.getMemory().setOperator(sign);
			} else {
				minus = true;
				window.setOperatorPressed(true);
				window.getMemory().setOperator(sign);
				screen = new ShowOnScreen(window, sign, dot, minus);
			}
			break;
		}
		case "/": {
			window.setOperator(sign);
			if (window.getMemory().getFirstNumber() != null && !window.isOperatorPressed()) {
				window.setOperatorPressed(true);
				window.getMemory().setOperator(sign);
				screen = new ShowOnScreen(window, sign, dot, minus);
			} else if (window.getMemory().getOperator() != null && window.isOperatorPressed()) {
				
				calculate = new Calculate(window, sign, dot, minus);
				window.getMemory().setOperator(sign);
			}
			break;
		}
		case "=": {
			if (window.getMemory().getFirstNumber() != null && window.getMemory().getSecondNumber() != null
					&& window.isOperatorPressed()) {
				
				calculate = new Calculate(window, sign, dot, minus);
				window.getMemory().setOperator(sign);
				calculate = new Calculate(window, sign, dot, minus);
			} else if (window.getMemory().getOperator() != null) {
				calculate = new Calculate(window, sign, dot, minus);
				window.getMemory().setOperator(sign);
			}
			break;
		}
		case "c": {
			window.getMemory().setOperator(null);
			window.getMemory().setFirstNumber(null);
			window.getMemory().setSecondNumber(null);
			window.getMemory().setresult(null);
			window.setOperatorPressed(false);
			screen = new ShowOnScreen(window, "c", dot, minus);
			break;
		}
		}
	}

	public void numberPressed(int i) {
		if (!window.isOperatorPressed()) {
			if (window.getMemory().getFirstNumber() != null) {
				window.getMemory().setFirstNumber(window.getMemory().getFirstNumber().concat(String.valueOf(i)));
			} else {
				window.getMemory().setFirstNumber(String.valueOf(i));
			}
		}
		if (window.isOperatorPressed()) {
			if (window.getMemory().getSecondNumber() != null) {
				window.getMemory().setSecondNumber(window.getMemory().getSecondNumber().concat(String.valueOf(i)));
			} else {
				window.getMemory().setSecondNumber(String.valueOf(i));
			}
		}
		screen = new ShowOnScreen(window, String.valueOf(i), dot, minus);
	}

}
