package controler;

import view.MainWindow;

public class Calculate {

	private MainWindow window;
	private boolean dot = false;
	private boolean minus = false;

	public Calculate(MainWindow window, int num) {
		this.window = window;
		numberPressed(num);
	}

	public Calculate(MainWindow window, String sign) {
		this.window = window;
		signPressed(sign);
	}

	private void showScrean(String screan) {
		if (window.getScrean() != null) {
			if (window.getScrean().equals("-") && dot) {
				window.setScrean(window.getScrean().concat("0."));
			} else {
				window.setScrean(window.getScrean().concat(screan));
			}
		} else if (dot) {
			window.setScrean("0.");
		} else if (minus) {
			window.setScrean("-");
		} else {
			window.setScrean(screan);
		}
	}

	private void signPressed(String sign) {
		switch (sign) {
		case ".": {
			dot = true;
			if (window.getMemory().getFirstNumber() == null) {
				window.getMemory().setFirstNumber("0.");
				showScrean(sign);
			} else if (!window.getMemory().getFirstNumber().contains(sign)) {
				window.getMemory().setFirstNumber(window.getMemory().getFirstNumber().concat(sign));
				showScrean(sign);
			}
			if (window.getMemory().getSecondNumber() == null && window.isOperatorPressed()) {
				System.out.println("segundo if");
				window.getMemory().setSecondNumber("0.");
				showScrean("0" + sign);
			} else if (window.isOperatorPressed() && !window.getMemory().getSecondNumber().contains(sign)) {
				System.out.println("segundo else if");
				window.getMemory().setSecondNumber(window.getMemory().getSecondNumber().concat(sign));
				showScrean(sign);
			}
			break;
		}
		case "+", "*": {
			if (window.getMemory().getFirstNumber() != null && !window.isOperatorPressed()) {
				window.setOperatorPressed(true);
				window.getMemory().setOperator(sign);
				showScrean(sign);
			} else if (window.getMemory().getOperator() != null && window.isOperatorPressed()) {
				calculate(sign);
				window.getMemory().setOperator(sign);
			}
			break;
		}
		case "-": {
			minus = true;
			if (window.getMemory().getFirstNumber() == null) {
				window.getMemory().setFirstNumber("-");
				showScrean(sign);
			} else if (window.getMemory().getOperator() != null && window.isOperatorPressed()) {
				calculate(sign);
				window.getMemory().setOperator(sign);
			} else {
				minus = true;
				window.setOperatorPressed(true);
				window.getMemory().setOperator(sign);
				showScrean(sign);
			}
			break;
		}
		case "/": {
			if (window.getMemory().getFirstNumber() != null && !window.isOperatorPressed()) {
				window.setOperatorPressed(true);
				window.getMemory().setOperator(sign);
				showScrean(sign);
			} else if (window.getMemory().getOperator() != null && window.isOperatorPressed()) {
				calculate(sign);
				window.getMemory().setOperator(sign);
			}
			break;
		}
		case "=": {
			if (window.getMemory().getFirstNumber() != null && window.getMemory().getSecondNumber() != null
					&& window.isOperatorPressed()) {
				calculate(sign);
				window.getMemory().setOperator(sign);
				calculate(sign);
			} else if (window.getMemory().getOperator() != null) {
				calculate(sign);
				window.getMemory().setOperator(sign);
			}
			break;
		}
		}
	}

	private void calculate(String sign) {
		System.out.println(sign + ">>>>>"+ window.getMemory().getOperator());
		window.setScrean("");
		switch (window.getMemory().getOperator()) {
		case "+": {

			window.getMemory().setresult(String.valueOf(Double.parseDouble(window.getMemory().getFirstNumber())
					+ Double.parseDouble(window.getMemory().getSecondNumber())));
			showScrean(window.getMemory().getresult() + sign);
			window.getMemory().setFirstNumber(window.getMemory().getresult());
			window.getMemory().setSecondNumber("0");
			break;
		}
		case "-": {

			window.getMemory().setresult(String.valueOf(Double.parseDouble(window.getMemory().getFirstNumber())
					- Double.parseDouble(window.getMemory().getSecondNumber())));
			showScrean(window.getMemory().getresult() + sign);
			window.getMemory().setFirstNumber(window.getMemory().getresult());
			window.getMemory().setSecondNumber("0");
			break;
		}
		case "*": {

			window.getMemory().setresult(String.valueOf(Double.parseDouble(window.getMemory().getFirstNumber())
					* Double.parseDouble(window.getMemory().getSecondNumber())));
			showScrean(window.getMemory().getresult() + sign);
			window.getMemory().setFirstNumber(window.getMemory().getresult());
			window.getMemory().setSecondNumber("0");
			break;
		}
		case "/": {
			if (window.getMemory().getSecondNumber() != null) {
				if (Double.parseDouble(window.getMemory().getSecondNumber()) == 0.0) {
					showScrean("Err");
				} else {
					window.getMemory().setresult(String.valueOf(Double.parseDouble(window.getMemory().getFirstNumber())
							/ Double.parseDouble(window.getMemory().getSecondNumber())));
					showScrean(window.getMemory().getresult() + sign);
					window.getMemory().setFirstNumber(window.getMemory().getresult());
					window.getMemory().setSecondNumber("0");
				}
			}
			break;
		}
		case "=": {
			showScrean(window.getMemory().getresult());
			window.getMemory().setFirstNumber(window.getMemory().getresult());
			window.getMemory().setSecondNumber("0");
			window.setOperatorPressed(false);
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
		showScrean(String.valueOf(i));
	}

}
