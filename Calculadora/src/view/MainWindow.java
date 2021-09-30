package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controler.ReadEntry;
import model.Memory;

/**
 *
 * @author Arthur Vaso
 */
public class MainWindow extends JFrame{

	private JPanel panelMain;
	
    private JPanel panelScreen;
    private JTextField fldScreen;
    
	private JPanel panelBtnNums;
    private JButton btn_0;
    private JButton btn_1;
    private JButton btn_2;
    private JButton btn_3;
    private JButton btn_4;    
    private JButton btn_5;
    private JButton btn_6;
    private JButton btn_7;
    private JButton btn_8;
    private JButton btn_9;
    private JButton btn_iqual;
    private JButton btn_dot;
    
    private JPanel panelBtnOperators;
    private JButton btn_plus;
    private JButton btn_minus;
    private JButton btn_times;
    private JButton btn_div;
    private JButton btn_clear;

    private GridBagLayout gridBag;
    private GridBagConstraints gbc;

	private ReadEntry calc;
	private Memory memory;
	private boolean operatorPressed = false;
	private String operator;

	private String screen;
    
	public MainWindow() {
        createWindow();
        loadWindow();
        
        memory = new Memory();
    }
    
    private void createWindow() {
    	gridBag = new GridBagLayout();
        gbc = new GridBagConstraints();
    	
        panelMain = new JPanel(gridBag);
        
        Font fontSize = new Font("Arial", 0, 20);
        
        panelScreen = new JPanel(gridBag);
        fldScreen = new JTextField(10);
        fldScreen.setFont(fontSize);
        fldScreen.setEditable(false);
        fldScreen.setBackground(new Color(180, 180, 180));;
        
        panelBtnNums = new JPanel(gridBag);
        btn_7 = new JButton("7");
        btn_7.addActionListener((e) -> {
            calc = new ReadEntry(this, 7);
        });
        btn_7.setFont(fontSize);
        
        btn_8 = new JButton("8");
        btn_8.addActionListener((e) -> {
        	calc = new ReadEntry(this, 8);
        });
        btn_8.setFont(fontSize);

        btn_9 = new JButton("9");
        btn_9.addActionListener((e) -> {
        	calc = new ReadEntry(this, 9);
        });
        btn_9.setFont(fontSize);
        
        btn_4 = new JButton("4");
        btn_4.addActionListener((e) -> {
        	calc = new ReadEntry(this, 4);
        });
        btn_4.setFont(fontSize);

        btn_5 = new JButton("5");
        btn_5.addActionListener((e) -> {
        	calc = new ReadEntry(this, 5);
        });
        btn_5.setFont(fontSize);

        btn_6 = new JButton("6");
        btn_6.addActionListener((e) -> {
        	calc = new ReadEntry(this, 6);
        });
        btn_6.setFont(fontSize);

        btn_1 = new JButton("1");
        btn_1.addActionListener((e) -> {
        	calc = new ReadEntry(this, 1);
        });
        btn_1.setFont(fontSize);

        btn_2 = new JButton("2");
        btn_2.addActionListener((e) -> {
        	calc = new ReadEntry(this, 2);
        });
        btn_2.setFont(fontSize);

        btn_3 = new JButton("3");
        btn_3.addActionListener((e) -> {
        	calc = new ReadEntry(this, 3);
        });
        btn_3.setFont(fontSize);

        btn_0 = new JButton("0");
        btn_0.addActionListener((e) -> {
        	calc = new ReadEntry(this, 0);
        });
        btn_0.setFont(fontSize);
        
        btn_dot = new JButton(".");
        btn_dot.addActionListener((e) -> {
        	calc = new ReadEntry(this, ".");
        });
        btn_dot.setFont(fontSize);
        
        btn_iqual = new JButton("=");
        btn_iqual.addActionListener((e) -> {
        	calc = new ReadEntry(this, "=");
        });
        btn_iqual.setFont(fontSize);
                
        panelBtnOperators = new JPanel(gridBag);
        btn_plus = new JButton("+");
        btn_plus.addActionListener((e) -> {
        	calc = new ReadEntry(this, "+");
        });
        btn_plus.setFont(fontSize);
        
        btn_minus = new JButton("-");
        btn_minus.addActionListener((e) -> {
        	calc = new ReadEntry(this, "-");
        });
        btn_minus.setFont(fontSize);
        
        btn_times = new JButton("x");
        btn_times.addActionListener((e) -> {
        	calc = new ReadEntry(this, "*");
        });
        btn_times.setFont(fontSize);
        
        btn_div = new JButton("/");
        btn_div.addActionListener((e) -> {
        	calc = new ReadEntry(this, "/");
        });
        
        btn_div.setFont(fontSize);
        
        btn_clear = new JButton("CL");
        btn_clear.addActionListener((e) -> {
        	calc = new ReadEntry(this, "c");
        });
        btn_clear.setFont(fontSize);
        
        loadComponents();
    }
    
    private void loadComponents() {
    	constraints(panelScreen, fldScreen, 0, 0, 1, 1, 130, 10, GridBagConstraints.CENTER);
    	
    	constraints(panelBtnNums, btn_0, 3, 0, 2, 0, 59, 10, GridBagConstraints.CENTER);
    	constraints(panelBtnNums, btn_dot, 3, 2, 1, 0, 10, 10, GridBagConstraints.CENTER);
    	constraints(panelBtnNums, btn_1, 2, 0, 1, 1, 5, 10, GridBagConstraints.CENTER);
    	constraints(panelBtnNums, btn_2, 2, 1, 1, 1, 5, 10, GridBagConstraints.CENTER);
    	constraints(panelBtnNums, btn_3, 2, 2, 1, 1, 5, 10, GridBagConstraints.CENTER);
    	constraints(panelBtnNums, btn_4, 1, 0, 1, 1, 5, 10, GridBagConstraints.CENTER);
    	constraints(panelBtnNums, btn_5, 1, 1, 1, 1, 5, 10, GridBagConstraints.CENTER);
    	constraints(panelBtnNums, btn_6, 1, 2, 1, 1, 5, 10, GridBagConstraints.CENTER);
    	constraints(panelBtnNums, btn_7, 0, 0, 1, 1, 5, 10, GridBagConstraints.CENTER);
    	constraints(panelBtnNums, btn_8, 0, 1, 1, 1, 5, 10, GridBagConstraints.CENTER);
    	constraints(panelBtnNums, btn_9, 0, 2, 1, 1, 5, 10, GridBagConstraints.CENTER);
    	           
    	constraints(panelBtnOperators, btn_clear, 0, 0, 2, 1, 60, 10, GridBagConstraints.CENTER);
    	constraints(panelBtnOperators, btn_div, 1, 1, 1, 1, 24, 10, GridBagConstraints.CENTER);
    	constraints(panelBtnOperators, btn_times, 1, 0, 1, 1, 8, 10, GridBagConstraints.CENTER);
    	constraints(panelBtnOperators, btn_plus, 2, 0, 1, 1, 5, 10, GridBagConstraints.CENTER);
    	constraints(panelBtnOperators, btn_minus, 2, 1, 1, 1, 23, 10, GridBagConstraints.CENTER);
    	constraints(panelBtnOperators, btn_iqual, 3, 0, 2, 1, 75, 10, GridBagConstraints.CENTER);
        
    	
        constraints(panelMain, panelScreen, 0, 0, 2, 1, 5, 10, GridBagConstraints.CENTER);
        constraints(panelMain, panelBtnNums, 1, 0, 1, 1, 5, 10, GridBagConstraints.WEST);
        constraints(panelMain, panelBtnOperators, 1, 1, 1, 1, 5, 10, GridBagConstraints.EAST);
        
        add(panelMain);
    }
    
    private void loadWindow() {
        setTitle("Calculadora");
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
    }
    
    private void constraints(Container container, JComponent component,
            int row, int col, int width, int height, int spaceX, int spaceY,
            int anchor) {

        final int INSET = 2;

        gbc.gridy = row;
        gbc.gridx = col;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.ipadx = spaceX;
        gbc.ipady = spaceY;
        gbc.anchor = anchor;
        gbc.insets.left = INSET;
        gbc.insets.right = INSET;
        gbc.insets.top = INSET;
        gbc.insets.bottom = INSET;

        gridBag.setConstraints(component, gbc);

        container.add(component);
    }


    public JTextField getFldScreen() {
		return fldScreen;
	}

	public void setFldScreen(String screen) {
		this.fldScreen.setText(screen);;
	}
    
	public Memory getMemory() {
		return memory;
	}

	public boolean isOperatorPressed() {
		return operatorPressed;
	}

	public void setOperatorPressed(boolean operatorPressed) {
		this.operatorPressed = operatorPressed;
	}
	

    public String getScreen() {
		return screen;
	}

	public void setScreen(String screen) {
		this.screen = screen;
		fldScreen.setText(screen);
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}
}
