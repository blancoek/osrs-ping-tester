import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;

public class GUI {

	private String version="1.0";
	private String author="Velkoz Main";
	private JFrame frame;
	private Boolean members=true;
	private byte regions=0;
	private char worldtypes=0;
	private Tester tester;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	private void initialize() {
		int screenwidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenheight = Toolkit.getDefaultToolkit().getScreenSize().height;
		
		int framewidth = 450;
		int frameheight = 300;
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds((screenwidth-framewidth)/2, (screenheight-frameheight)/2, framewidth, frameheight);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("OSRS Ping Tester v"+version+" - By "+author);
		frame.getContentPane().setLayout(null);

		BufferedImage image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
		Graphics g = image.getGraphics();
		Font font = new Font("Tahoma",Font.PLAIN,11);
		g.setFont(font);
		FontMetrics fm = g.getFontMetrics();
		
		String regionText = "Choose your preferred regions";
		JLabel regionLabel = new JLabel(regionText);
		int sw = fm.stringWidth(regionText)+26;
		regionLabel.setBounds((framewidth-sw)/2, 10, sw, fm.getHeight());
		frame.getContentPane().add(regionLabel);
		
		int regionLine1w = 69+76+114; // Width of the first 3 buttons together
		
		JCheckBox regionCheckbox1 = new JCheckBox("Autralia");
		regionCheckbox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				regions ^= 1;
			}
		});
		JCheckBox regionCheckbox2 = new JCheckBox("Germany");
		regionCheckbox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				regions ^= 1<<1;
			}
		});
		JCheckBox regionCheckbox3 = new JCheckBox("United Kingdom");
		regionCheckbox3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				regions ^= 1<<2;
			}
		});
		
		regionCheckbox1.setBounds((frame.getWidth()-regionLine1w)/2, regionLabel.getHeight()+regionLabel.getY()+8, 69, fm.getHeight());
		regionCheckbox2.setBounds(regionCheckbox1.getX()+regionCheckbox1.getWidth(), regionCheckbox1.getY(), 76, fm.getHeight());
		regionCheckbox3.setBounds(regionCheckbox2.getX()+regionCheckbox2.getWidth(), regionCheckbox1.getY(), 114, fm.getHeight());
		
		int regionLine2w=137+142; // Width of the last 2 buttons together
		
		JCheckBox regionCheckbox4 = new JCheckBox("United States (East)");
		regionCheckbox4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				regions ^= 1<<3;
			}
		});
		JCheckBox regionCheckbox5 = new JCheckBox("United States (West)");
		regionCheckbox5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				regions ^= 1<<4;
			}
		});

		regionCheckbox4.setBounds((frame.getWidth()-regionLine2w)/2, regionCheckbox1.getY()+regionCheckbox1.getHeight()+5, 137, fm.getHeight());
		regionCheckbox5.setBounds(regionCheckbox4.getX()+regionCheckbox4.getWidth(), regionCheckbox1.getY()+regionCheckbox1.getHeight()+5, 142, fm.getHeight());
		
		frame.getContentPane().add(regionCheckbox1);
		frame.getContentPane().add(regionCheckbox2);
		frame.getContentPane().add(regionCheckbox3);
		frame.getContentPane().add(regionCheckbox4);
		frame.getContentPane().add(regionCheckbox5);
		
		String worldtypeText = "Choose your preferred world types";
		JLabel worldtypeLabel = new JLabel(worldtypeText);
		sw = fm.stringWidth(worldtypeText)+28;
		worldtypeLabel.setBounds((framewidth-sw)/2, regionCheckbox4.getY()+regionCheckbox4.getHeight()+8, sw, fm.getHeight());
		frame.getContentPane().add(worldtypeLabel);
		
		int worldtypeLine1w = 77+47+78+77+77;
		
		JCheckBox worldtypeCheckbox1 = new JCheckBox("Standard");
		worldtypeCheckbox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				worldtypes ^= 1;
			}
		});
		JCheckBox worldtypeCheckbox2 = new JCheckBox("PvP");
		worldtypeCheckbox2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				worldtypes ^= 1<<1;
			}
		});
		JCheckBox worldtypeCheckbox3 = new JCheckBox("High Risk");
		worldtypeCheckbox3.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				worldtypes ^= 1<<2;
			}
		});
		JCheckBox worldtypeCheckbox4 = new JCheckBox("500 Total");
		worldtypeCheckbox4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				worldtypes ^= 1<<3;
			}
		});
		JCheckBox worldtypeCheckbox5 = new JCheckBox("750 Total");
		worldtypeCheckbox5.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				worldtypes ^= 1<<4;
			}
		});
		
		worldtypeCheckbox1.setBounds((frame.getWidth()-worldtypeLine1w)/2, worldtypeLabel.getHeight()+worldtypeLabel.getY()+8, 77, fm.getHeight());
		worldtypeCheckbox2.setBounds(worldtypeCheckbox1.getX()+worldtypeCheckbox1.getWidth(), worldtypeCheckbox1.getY(), 47, fm.getHeight());
		worldtypeCheckbox3.setBounds(worldtypeCheckbox2.getX()+worldtypeCheckbox2.getWidth(), worldtypeCheckbox1.getY(), 78, fm.getHeight());
		worldtypeCheckbox4.setBounds(worldtypeCheckbox3.getX()+worldtypeCheckbox3.getWidth(), worldtypeCheckbox1.getY(), 77, fm.getHeight());
		worldtypeCheckbox5.setBounds(worldtypeCheckbox4.getX()+worldtypeCheckbox4.getWidth(), worldtypeCheckbox1.getY(), 77, fm.getHeight());
		
		int worldtypeLine2w = 84+84+84+84;
		
		JCheckBox worldtypeCheckbox6 = new JCheckBox("1250 Total");
		worldtypeCheckbox6.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				worldtypes ^= 1<<5;
			}
		});
		JCheckBox worldtypeCheckbox7 = new JCheckBox("1500 Total");
		worldtypeCheckbox7.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				worldtypes ^= 1<<6;
			}
		});
		JCheckBox worldtypeCheckbox8 = new JCheckBox("1750 Total");
		worldtypeCheckbox8.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				worldtypes ^= 1<<7;
			}
		});
		JCheckBox worldtypeCheckbox9 = new JCheckBox("2000 Total");
		worldtypeCheckbox9.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				worldtypes ^= 1<<8;
			}
		});
		
		worldtypeCheckbox6.setBounds((frame.getWidth()-worldtypeLine2w)/2, worldtypeCheckbox1.getHeight()+worldtypeCheckbox1.getY()+5, 84, fm.getHeight());
		worldtypeCheckbox7.setBounds(worldtypeCheckbox6.getX()+worldtypeCheckbox6.getWidth(), worldtypeCheckbox6.getY(), 84, fm.getHeight());	
		worldtypeCheckbox8.setBounds(worldtypeCheckbox7.getX()+worldtypeCheckbox7.getWidth(), worldtypeCheckbox6.getY(), 84, fm.getHeight());	
		worldtypeCheckbox9.setBounds(worldtypeCheckbox8.getX()+worldtypeCheckbox8.getWidth(), worldtypeCheckbox6.getY(), 84, fm.getHeight());	
		
		int worldtypeLine3w = 84+79+115+51;
		
		JCheckBox worldtypeCheckbox10 = new JCheckBox("2200 Total");
		worldtypeCheckbox10.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				worldtypes ^= 1<<9;
			}
		});
		JCheckBox worldtypeCheckbox11 = new JCheckBox("Deadman");
		worldtypeCheckbox11.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				worldtypes ^= 1<<10;
			}
		});
		JCheckBox worldtypeCheckbox12 = new JCheckBox("Twisted League");
		worldtypeCheckbox12.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				worldtypes ^= 1<<11;
			}
		});
		JCheckBox worldtypeCheckbox13 = new JCheckBox("Beta");
		worldtypeCheckbox13.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				worldtypes ^= 1<<12;
			}
		});
		
		worldtypeCheckbox10.setBounds((frame.getWidth()-worldtypeLine3w)/2, worldtypeCheckbox6.getHeight()+worldtypeCheckbox6.getY()+5, 84, fm.getHeight());
		worldtypeCheckbox11.setBounds(worldtypeCheckbox10.getX()+worldtypeCheckbox10.getWidth(), worldtypeCheckbox10.getY(), 79, fm.getHeight());
		worldtypeCheckbox12.setBounds(worldtypeCheckbox11.getX()+worldtypeCheckbox11.getWidth(), worldtypeCheckbox10.getY(), 115, fm.getHeight());
		worldtypeCheckbox13.setBounds(worldtypeCheckbox12.getX()+worldtypeCheckbox12.getWidth(), worldtypeCheckbox10.getY(), 51, fm.getHeight());

		frame.getContentPane().add(worldtypeCheckbox1);
		frame.getContentPane().add(worldtypeCheckbox2);
		frame.getContentPane().add(worldtypeCheckbox3);
		frame.getContentPane().add(worldtypeCheckbox4);
		frame.getContentPane().add(worldtypeCheckbox5);
		frame.getContentPane().add(worldtypeCheckbox6);
		frame.getContentPane().add(worldtypeCheckbox7);
		frame.getContentPane().add(worldtypeCheckbox8);
		frame.getContentPane().add(worldtypeCheckbox9);
		frame.getContentPane().add(worldtypeCheckbox10);
		frame.getContentPane().add(worldtypeCheckbox11);
		frame.getContentPane().add(worldtypeCheckbox12);
		frame.getContentPane().add(worldtypeCheckbox13);
		
		String membersText = "Choose membership type";
		JLabel membersLabel = new JLabel(membersText);
		sw = fm.stringWidth(membersText)+28;
		membersLabel.setBounds((framewidth-sw)/2, worldtypeCheckbox10.getY()+worldtypeCheckbox10.getHeight()+8, sw, fm.getHeight());
		frame.getContentPane().add(membersLabel);
		
		int membersLine = 79+105;	
		JRadioButton membersButton1 = new JRadioButton("Members");
		membersButton1.setSelected(true);
		membersButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				members=true;
			}
		});
		
		JRadioButton membersButton2 = new JRadioButton("Non-Members");
		membersButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				members=false;
			}
		});
		
		membersButton1.setBounds((frame.getWidth()-membersLine)/2, membersLabel.getY()+membersLabel.getHeight()+5, 79, fm.getHeight());
		membersButton2.setBounds(membersButton1.getX()+membersButton1.getWidth(), membersButton1.getY(), 105, fm.getHeight());		
		
		frame.getContentPane().add(membersButton1);
		frame.getContentPane().add(membersButton2);

		ButtonGroup membersGroup = new ButtonGroup();
		membersGroup.add(membersButton1);
		membersGroup.add(membersButton2);
		
		JButton btnNewButton = new JButton("Show best worlds");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tester.Search(worldtypes, regions, members);
			}
		});
		btnNewButton.setBounds((frame.getWidth()-136)/2, membersButton1.getY()+membersButton1.getHeight()+8, 136, 23);
		frame.getContentPane().add(btnNewButton);
		
	}
}
