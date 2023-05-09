package classPrograms;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import java.sql.*;

import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class SwingProject implements ActionListener {
	
	JButton btn, btn2, btn3, btn4, btn5, btn6;
	JFrame frame;
	
	public SwingProject() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(0, 0, 500, 500);
		Container container = frame.getContentPane();
		container.setLayout(null);
		
		JLabel label = new JLabel("Test");
		label.setText("Genre-Based Anime Recommendation");
		label.setBounds(140,5,250,30);
		frame.add(label);
		
		//Creating Buttons and adding their ActionListener
		
		// For Shounen
		btn = new JButton("Shounen");
		btn.setBounds(150, 50, 200, 40);
		container.add(btn);
		
		btn.addActionListener(this);
		
		
		// For Slice of Life
		btn2 = new JButton("Slice Of Life");
		btn2.setBounds(150, 110, 200, 40);
		container.add(btn2);
		
		btn2.addActionListener(this);
		
		
		// For Romance
		btn3 = new JButton("Romance");
		btn3.setBounds(150, 170, 200, 40);
		container.add(btn3);
		
		btn3.addActionListener(this);
		
		
		// For Drama
		btn4 = new JButton("Drama");
		btn4.setBounds(150, 230, 200, 40);
		container.add(btn4);
		
		btn4.addActionListener(this);
		
		
		// For Isekai
		btn5 = new JButton("Isekai");
		btn5.setBounds(150, 290, 200, 40);
		container.add(btn5);
		
		btn5.addActionListener(this);
		
		
		// For Comedy
		btn6 = new JButton("Comedy");
		btn6.setBounds(150, 350, 200, 40);
		container.add(btn6);
		
		btn6.addActionListener(this);
		
		frame.setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Random rand = new Random();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        
        //SQL Connection
        
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Create a connection to the MySQL database
            String conn_string = "jdbc:mysql://localhost/DATABASE_NAME";
            String user = "USER_NAME";
            String password = "PASSWORD";
            conn = DriverManager.getConnection(conn_string, user, password);

            stmt = conn.createStatement();
        }catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("SQLVendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} 
        
        //Button Functions
        
        
        	//Shounen 
		if (e.getSource() == btn) {
			try {
				rs = stmt.executeQuery("SELECT Name FROM Anime where GENRE = 'Shounen'");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			ArrayList<String> shounen = new ArrayList<>();
			try {
				while (rs.next()) {
					try {
						String AmimeName = rs.getString("Name");
						shounen.add(AmimeName);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			int size = shounen.size();
			int in = rand.nextInt(size); 
			JOptionPane.showMessageDialog(frame, shounen.get(in));
		}
		
		
		
		//Slice of Life
		if (e.getSource() == btn2) {
			try {
				rs = stmt.executeQuery("SELECT Name FROM Anime where GENRE = 'Slice of Life'");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			ArrayList<String> sol = new ArrayList<>();
			try {
				while (rs.next()) {
					try {
						String AmimeName = rs.getString("Name");
						sol.add(AmimeName);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			int size = sol.size();
			int in = rand.nextInt(size); 
			JOptionPane.showMessageDialog(frame, sol.get(in));
		}
		
		
		
		//Romance
		if (e.getSource() == btn3) {

			try {
				rs = stmt.executeQuery("SELECT Name FROM Anime where GENRE = 'Romance'");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			ArrayList<String> romance = new ArrayList<>();
			try {
				while (rs.next()) {
					try {
						String AmimeName = rs.getString("Name");
						romance.add(AmimeName);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			int size = romance.size();
			int in = rand.nextInt(size); 
			JOptionPane.showMessageDialog(frame, romance.get(in));
		}
						
		
		
		//Drama
		if (e.getSource() == btn4) {
			try {
				rs = stmt.executeQuery("SELECT Name FROM Anime where GENRE = 'Drama'");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			ArrayList<String> drama = new ArrayList<>();
			try {
				while (rs.next()) {
					try {
						String AmimeName = rs.getString("Name");
						drama.add(AmimeName);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			int size = drama.size();
			int in = rand.nextInt(size); 
			JOptionPane.showMessageDialog(frame, drama.get(in));
		}
		
		
		
		//Isekai
		if (e.getSource() == btn5) {
			try {
				rs = stmt.executeQuery("SELECT Name FROM Anime where GENRE = 'Isekai'");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			ArrayList<String> isekai = new ArrayList<>();
			try {
				while (rs.next()) {
					try {
						String AmimeName = rs.getString("Name");
						isekai.add(AmimeName);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			int size = isekai.size();
			int in = rand.nextInt(size); 
			JOptionPane.showMessageDialog(frame, isekai.get(in));
		}
		
		
		//Comedy
		if (e.getSource() == btn6) {
			try {
				rs = stmt.executeQuery("SELECT Name FROM Anime where GENRE = 'Comedy'");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			ArrayList<String> comedy = new ArrayList<>();
			try {
				while (rs.next()) {
					try {
						String AmimeName = rs.getString("Name");
						comedy.add(AmimeName);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			int size = comedy.size();
			int in = rand.nextInt(size); 
			JOptionPane.showMessageDialog(frame, comedy.get(in));
		}
		
	}
	
	
	//main
	public static void main(String args[]) throws ClassNotFoundException {
		
		SwingProject project = new SwingProject();		
	}
}
