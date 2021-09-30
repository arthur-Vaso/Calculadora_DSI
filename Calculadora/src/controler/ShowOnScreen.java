package controler;

import view.MainWindow;

public class ShowOnScreen {
	private MainWindow window;

	public ShowOnScreen(MainWindow window, String screen, boolean dot, boolean minus) {
		this.window = window;
		
		showScreen(screen, dot, minus);
	}
	
	private void showScreen(String screen, boolean dot, boolean minus) {
		if (screen == null) {
			window.setScreen("Err");
			window.getMemory().setresult(null);
		}
		if (screen != null && screen.equals("c")) {
			window.setScreen(null);
		} else {
			if (window.getScreen() != null) {
				if (window.getScreen().equals("-") && dot) {
					window.setScreen(window.getScreen().concat("0."));
				} else if (screen != null) {
					window.setScreen(window.getScreen().concat(screen));
				}
			} else if (dot) {
				window.setScreen("0.");
			} else if (minus) {
				window.setScreen("-");
			} else {
				window.setScreen(screen);
			}
		}

	}
}
