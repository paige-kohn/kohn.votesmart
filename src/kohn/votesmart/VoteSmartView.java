package kohn.votesmart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Popup;
import javax.swing.PopupFactory;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.JTextComponent;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressWarnings("serial")

public class VoteSmartView extends JFrame implements ActionListener {
	
    
	private JLabel stateIDLabel;
	private JLabel yearLabel;
	private JTextField stateIDField;
	private JTextField yearField;
		

	private JTextField zip5Field;
	private JTextField zip4Field;
	private JLabel zipLabel;
	private String zipCode = "";
	private String zip4 = "0000";

	private JTextArea displayResults;

	private JButton resultButton;
	private JButton electionResults;
	
	public VoteSmartView() {
		
		setLocation(240, 80);
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		JPanel menu = new JPanel();
	    GridLayout layout = new GridLayout(2,2);
	    layout.setHgap(20);
	    layout.setVgap(20);
	    menu.setLayout(layout);
		JButton searchCandidates = new JButton("Search Local Candidates by Zip Code");
		JButton searchBills = new JButton("Search most recent bills passed");
		JButton searchElections = new JButton("Search upcoming elections by Zip Code");

		menu.add(searchCandidates);
		menu.add(searchBills);
		menu.add(searchElections);
		Border buttonBorder = BorderFactory.createEtchedBorder(Color.GRAY, Color.GRAY);
		searchCandidates.setBorderPainted(true);
		searchCandidates.setBorder(buttonBorder);	
		
		Border border = BorderFactory.createEmptyBorder(50, 50, 50, 50);
		menu.setBorder(border);
		add(menu);
		searchCandidates.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = displayCandidatesbyZip();
                dialog.setSize(new Dimension(800,500));
				dialog.setVisible(true);
			    dialog.setLocation(340, 120);
			}
		});
		
		searchBills.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = displayBillsByState() ;
				dialog.setSize(new Dimension(800,500));
				dialog.setVisible(true);
			    dialog.setLocation(340, 120);
			}		
		});
		
		searchElections.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = displayElectionsByZip() ;
				dialog.setSize(new Dimension(800,500));
				dialog.setVisible(true);
			    dialog.setLocation(340, 120);
			    
			}			
		});		
	}
	

	public JDialog displayElectionsByZip() {
		JDialog electionPanel = new JDialog();
		JPanel entries = new JPanel(new GridLayout(1,0));
		JPanel results = new JPanel(new GridLayout(0,1));
		zipLabel = new JLabel("Enter your zip code: ");		
		zip5Field = new JTextField(SwingConstants.LEFT);	
		zip4Field = new JTextField(SwingConstants.RIGHT);
		electionResults = new JButton("OK");
		
		Border buttonBorder = BorderFactory.createEtchedBorder(Color.BLACK, Color.gray);
		
		electionResults.setBorderPainted(true);
		electionResults.setBorder(buttonBorder);
		electionResults.setPreferredSize(new Dimension(20,31));
		electionResults.addActionListener(this);

		displayResults = new JTextArea();
		displayResults.setWrapStyleWord(true);
		displayResults.setEditable(false);
		displayResults.setLineWrap(true);
		displayResults.setPreferredSize(new Dimension(200, 250));
		JScrollPane scrollPane = new JScrollPane(displayResults);
		Border border = BorderFactory.createEmptyBorder(10, 40, 20, 40);
		entries.add(zipLabel);
		entries.add(zip5Field);
		entries.add(new JLabel(""));
		entries.add(electionResults);
		entries.setBorder(border);
		results.setBorder(border);		
		entries.setBackground((new Color(68, 113, 181)));		

		results.add(scrollPane);
		electionPanel.add(entries, BorderLayout.PAGE_START);
		electionPanel.add(results, BorderLayout.CENTER);
		return electionPanel;
	}
	
	public JDialog displayBillsByState() {
		JDialog billsPanel = new JDialog();
		JPanel entries = new JPanel(new GridLayout(1,0));
		JPanel results = new JPanel(new GridLayout(0,1));
		stateIDField = new JTextField();
		stateIDLabel = new JLabel("Enter the State ID: ");
		yearField = new JTextField();
		yearLabel = new JLabel(" Enter a year: ");
		resultButton = new JButton("OK");
		
		Border buttonBorder = BorderFactory.createEtchedBorder(Color.white, (new Color(209, 142, 13)));
		resultButton.setBorderPainted(true);
		resultButton.setBorder(buttonBorder);
		resultButton.setPreferredSize(new Dimension(20,31));
		resultButton.addActionListener(this);

		displayResults = new JTextArea();
		displayResults.setWrapStyleWord(true);
		displayResults.setEditable(false);
		displayResults.setLineWrap(true);
		displayResults.setPreferredSize(new Dimension(200, 250));
		JScrollPane scrollPane = new JScrollPane(displayResults);
		Border border = BorderFactory.createEmptyBorder(10, 40, 20, 40);
		
		
		entries.setBorder(border);
		results.setBorder(border);
		entries.add(stateIDLabel);
		entries.add(stateIDField);
		entries.add(yearLabel);
		entries.add(yearField);
		entries.add(new JLabel(""));
		entries.add(resultButton);
		entries.setBackground((new Color(128, 128, 128)));		

		results.add(scrollPane);
		billsPanel.add(entries, BorderLayout.BEFORE_FIRST_LINE);
		billsPanel.add(results, BorderLayout.CENTER);
		return billsPanel;

	}
	
	public JDialog displayCandidatesbyZip() {
		JDialog candidatePanel = new JDialog();
		JPanel entries = new JPanel(new GridLayout(1,0));
		JPanel results = new JPanel(new GridLayout(0,1));
		
		zipLabel = new JLabel("Enter your zip code:");		
		zip5Field = new JTextField(SwingConstants.LEFT);	
		zip4Field = new JTextField(SwingConstants.RIGHT);


		zip5Field.setPreferredSize(new Dimension(100,32));
		zip4Field.setPreferredSize( new Dimension(120,32));

		resultButton = new JButton("OK");
		resultButton.setPreferredSize(new Dimension(42,31));
		displayResults = new JTextArea();
		displayResults.setWrapStyleWord(true);
		displayResults.setEditable(false);
		displayResults.setLineWrap(true);
		displayResults.setPreferredSize(new Dimension(200, 250));

		JScrollPane scrollPane = new JScrollPane(displayResults);

		entries.add(zipLabel);
		entries.add(zip5Field);
		entries.add(new JLabel("-"));
		entries.add(zip4Field);
		entries.add(new JLabel(" "));
		entries.add(resultButton);
		results.add(scrollPane);
		
                                   
		resultButton.addActionListener(this);
		
		Border buttonBorder = BorderFactory.createEtchedBorder(Color.WHITE, Color.RED);
		resultButton.setBorderPainted(true);
		resultButton.setBorder(buttonBorder);	
		Border border = BorderFactory.createEmptyBorder(12, 12, 12, 12);
		results.setBorder(border);
		entries.setBorder(border);
		candidatePanel.add(entries, BorderLayout.BEFORE_FIRST_LINE);
		candidatePanel.add(results, BorderLayout.CENTER);
	
		candidatePanel.setBackground((new Color(239, 242, 193)));		

		return candidatePanel;
	}
	
	
	
	
	public JTextComponent getCandidatebyZip() {
		return displayResults;
	}
	
	public JTextComponent getResults() {
		return displayResults;
	}
	
	public String getYear() {
		return yearField.getText();
	}
	
	public String getStateID() {
		return stateIDField.getText();
	}
	public String getZip5() {
		
		return zip5Field.getText().substring(0, 5);
	}
	
	public String getZip4() {
		
		return zip4Field.getText();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
	
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://api.votesmart.org")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		VoteSmartService service = retrofit.create(VoteSmartService.class);
		
		VoteSmartController controller = new VoteSmartController(this, service);
		if(e.getSource().equals(getCandidatebyZip())) {
			controller.requestCandidateData();
		}
		if(e.getSource().equals(electionResults)) {
			controller.requestElectionData();
		}
		
	}
	
	
	public static void main (String [] args) {
		new VoteSmartView().setVisible(true);
	}
	
	
	
}
