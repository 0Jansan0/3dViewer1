package Viewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSlider;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class ViewrWB {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewrWB window = new ViewrWB();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		

	}

	/**
	 * Create the application.
	 */
	public ViewrWB() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	static JLabel LabelY,LabelX;
	static JSlider sliderY,sliderX;
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.SOUTH);
		
		LabelY = new JLabel("");
		panel.add(LabelY);
	
		sliderY = new JSlider();
		sliderY.setValue(0);
		panel.add(sliderY);
		
		sliderX = new JSlider();
		sliderX.setValue(0);
		panel.add(sliderX);
		
		LabelX = new JLabel("");
		panel.add(LabelX);
		

		panel1 Panel1 = new panel1();
		//FlowLayout fl_panel1 = (FlowLayout) panel1.getLayout();
		frame.getContentPane().add(Panel1, BorderLayout.CENTER);
		Panel1.startHiloJuego();

		
		JLabel lblNewLabel = new JLabel("3D VIEWER");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
		
	}
	


}
