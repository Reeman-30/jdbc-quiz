package com.ibik.praktikum;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ibik.praktikum.app.FormMhs;
import com.ibik.praktikum.app.TableMhs;
import com.ibik.praktikum.db.ConnectionDB;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;

public class MainApps extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton connBtn, formBtn, showBtn;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApps frame = new MainApps();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainApps() {
		setTitle("JDBC Project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 256, 350);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 0, 0, 0));
		
		connBtn = new JButton("Connect DB");
		contentPane.add(connBtn);
		
		formBtn = new JButton("Add Data");
		contentPane.add(formBtn);
		
		showBtn = new JButton("Show Database");
		contentPane.add(showBtn);

		connBtn.addActionListener(this);
		formBtn.addActionListener(this);
		showBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == connBtn) {
			ConnectionDB connDB = new ConnectionDB();

				try {
					if (connDB.connect() != null) {
					  JOptionPane.showMessageDialog(contentPane, "Connected to Database");
					}
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "ERROR!", JOptionPane.ERROR_MESSAGE);
				}
		} else if(e.getSource() == formBtn) {
			new FormMhs().setVisible(true);
		} else {
			new TableMhs().setVisible(true);
		}
	}

}