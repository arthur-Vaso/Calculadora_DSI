package controler;

import view.MainWindow;

public class Calculate {

	private MainWindow window;

	public Calculate(MainWindow window, int i) {
		this.window = window;
		numberPressed(i);
	}
	
	public void numberPressed(int i) {
			System.out.println(i);
			window.setFldScrean("TESTE");
	}

}
