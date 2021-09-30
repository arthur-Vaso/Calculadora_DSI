package controler;

import view.MainWindow;

public class Calculate {
	private MainWindow window;
	private ShowOnScreen screen;

	public Calculate(MainWindow window, String sign, boolean dot, boolean minus) {
		this.window = window;
		calculate(sign, dot, minus);
	}
	
	private void calculate(String sign, boolean dot, boolean minus) {
		window.setScreen("");
		switch (window.getMemory().getOperator()) {
		case "+": {

			window.getMemory().setresult(String.valueOf(Double.parseDouble(window.getMemory().getFirstNumber())
					+ Double.parseDouble(window.getMemory().getSecondNumber())));
			screen = new ShowOnScreen(window, window.getMemory().getresult() + sign, dot, minus);
			window.getMemory().setFirstNumber(window.getMemory().getresult());
			window.getMemory().setSecondNumber("0");
			break;
		}
		case "-": {

			window.getMemory().setresult(String.valueOf(Double.parseDouble(window.getMemory().getFirstNumber())
					- Double.parseDouble(window.getMemory().getSecondNumber())));
			screen = new ShowOnScreen(window, window.getMemory().getresult() + sign, dot, minus);
			window.getMemory().setFirstNumber(window.getMemory().getresult());
			window.getMemory().setSecondNumber("0");
			break;
		}
		case "*": {

			window.getMemory().setresult(String.valueOf(Double.parseDouble(window.getMemory().getFirstNumber())
					* Double.parseDouble(window.getMemory().getSecondNumber())));
			screen = new ShowOnScreen(window, window.getMemory().getresult() + sign, dot, minus);
			window.getMemory().setFirstNumber(window.getMemory().getresult());
			window.getMemory().setSecondNumber("0");
			break;
		}
		case "/": {
			if (window.getMemory().getSecondNumber() != null) {
				if (Double.parseDouble(window.getMemory().getSecondNumber()) == 0.0) {
					screen = new ShowOnScreen(window, "Err", dot, minus);
					window.getMemory().setresult(null);
				} else {
					window.getMemory().setresult(String.valueOf(Double.parseDouble(window.getMemory().getFirstNumber())
							/ Double.parseDouble(window.getMemory().getSecondNumber())));
					screen = new ShowOnScreen(window, window.getMemory().getresult() + sign, dot, minus);
					window.getMemory().setFirstNumber(window.getMemory().getresult());
					window.getMemory().setSecondNumber("0");
				}
			}
			break;
		}
		case "=": {
			if ((window.getMemory().getSecondNumber() == null
					|| Double.parseDouble(window.getMemory().getSecondNumber()) == 0.0)
					&& !window.isOperatorPressed()) {
				screen = new ShowOnScreen(window, "Err", dot, minus);
				window.getMemory().setresult(null);
			} else {
				if (window.getOperator() != null && window.getOperator().equals("/") && window.getMemory().getresult() == null) {
					screen = new ShowOnScreen(window, "Err", dot, minus);
					window.getMemory().setresult(null);
				} else {
					screen = new ShowOnScreen(window, window.getMemory().getresult(), dot, minus);
					window.getMemory().setFirstNumber(window.getMemory().getresult());
					window.getMemory().setSecondNumber(null);
					window.setOperatorPressed(false);
				}
			}
			break;
		}
		}
	}
}
