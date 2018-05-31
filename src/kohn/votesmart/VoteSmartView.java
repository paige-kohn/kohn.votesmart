package kohn.votesmart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;

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


	private JTextArea displayResults;

	private JButton candidateResults;
	private JButton electionResults;
	private JButton billsResults;
	private JButton stateOfficialResults;
	
	public VoteSmartView() {
		
		setLocation(240, 80);
		setSize(600, 420);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		JPanel menu = new JPanel();
	    GridLayout layout = new GridLayout(2,2);
	    layout.setHgap(30);
	    layout.setVgap(30);
	    menu.setLayout(layout);
		JButton searchCandidates = new JButton("Search Local Candidates By Zip Code");
		JButton searchBills = new JButton("Search most recent bills passed");
		JButton searchElections = new JButton("Search upcoming elections by Zip Code");
		JButton searchOfficials = new JButton("Lookup officials by State");
		searchCandidates.setFont(new Font("", Font.PLAIN, 10));
		menu.add(searchCandidates);
		menu.add(searchBills);
		menu.add(searchElections);
		menu.add(searchOfficials);
		menu.setBackground((new Color(8, 13, 10)));		

		menu.setFont(new Font("Courier New", Font.ITALIC, 16));
		
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
		searchOfficials.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = displayStateOfficials();
				dialog.setSize(new Dimension(800,500));
				dialog.setVisible(true);
			    dialog.setLocation(340, 120);
				
			}
			
		});
	}
	public JDialog displayStateOfficials() {
		JDialog stateOfficialsPanel = new JDialog();
		 GridLayout layout = new GridLayout(1,0);
		   layout.setHgap(20);
		    layout.setVgap(10);
		JPanel entries = new JPanel(layout);
		JPanel results = new JPanel(new GridLayout(0,1));
		stateIDField = new JTextField();
		stateIDLabel = new JLabel("Enter the State ID: ");
		stateIDLabel.setForeground(Color.white);
		stateOfficialResults = new JButton("OK");
		stateOfficialResults.addActionListener(this);
		stateOfficialResults.setPreferredSize(new Dimension(20,31));

		Border buttonBorder = BorderFactory.createEtchedBorder(Color.BLACK, Color.white);

		stateOfficialResults.setBorderPainted(true);
		stateOfficialResults.setBorder(buttonBorder);
		stateOfficialResults.setForeground(Color.white);
		Border border = BorderFactory.createEmptyBorder(40, 40, 40, 40);

		entries.setBorder(border);
		entries.add(stateIDLabel);
		entries.add(stateIDField);
		entries.add(new JLabel(""));
		entries.add(stateOfficialResults);
		entries.setBackground(Color.black);		
		
		displayResults = new JTextArea();
		displayResults.setWrapStyleWord(true);
		displayResults.setEditable(false);
		displayResults.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(displayResults);
		results.setBorder(border);
		results.add(scrollPane);
		stateOfficialsPanel.add(entries, BorderLayout.BEFORE_FIRST_LINE);
		stateOfficialsPanel.add(results, BorderLayout.CENTER);
		return stateOfficialsPanel;
	}

	public JDialog displayElectionsByZip() {
		JDialog electionPanel = new JDialog();
		JPanel entries = new JPanel(new GridLayout(1,0));
		JPanel results = new JPanel(new GridLayout(0,1));
		zipLabel = new JLabel("Zip code: ");		
		zip5Field = new JTextField(SwingConstants.CENTER);	
		zip4Field = new JTextField(SwingConstants.RIGHT);
		electionResults = new JButton("OK");
		zipLabel.setForeground(Color.WHITE);
		electionResults.setForeground(Color.WHITE);
		Border buttonBorder = BorderFactory.createEtchedBorder(Color.white, (new Color(209, 142, 113)));
		
		electionResults.setBorderPainted(true);
		electionResults.setBorder(buttonBorder);
		electionResults.setPreferredSize(new Dimension(20,31));
		electionResults.addActionListener(this);

		displayResults = new JTextArea();
		displayResults.setWrapStyleWord(true);
		displayResults.setEditable(false);
		displayResults.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(displayResults);
		Border border = BorderFactory.createEmptyBorder(40, 40, 40, 40);
		entries.add(zipLabel);
		entries.add(zip5Field);
		entries.add(new JLabel(""));
		entries.add(electionResults);
		entries.setBorder(border);
		results.setBorder(border);		
		entries.setBackground(Color.black);		

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
		stateIDLabel.setForeground(Color.WHITE);
		yearField = new JTextField();
		yearLabel = new JLabel(" Enter a year: ");
		yearLabel.setForeground(Color.WHITE);
		billsResults = new JButton("OK");
		billsResults.setForeground(Color.WHITE);
		Border buttonBorder = BorderFactory.createEtchedBorder(Color.white, (new Color(209, 142, 113)));
		billsResults.setBorderPainted(true);
		billsResults.setBorder(buttonBorder);
		billsResults.setPreferredSize(new Dimension(20,31));
		billsResults.addActionListener(this);

		displayResults = new JTextArea();
		displayResults.setWrapStyleWord(true);
		displayResults.setEditable(false);
		displayResults.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(displayResults);
		Border border = BorderFactory.createEmptyBorder(40, 40, 40, 40);
		
		
		entries.setBorder(border);
		results.setBorder(border);
		entries.add(stateIDLabel);
		entries.add(stateIDField);
		entries.add(yearLabel);
		entries.add(yearField);
		entries.add(new JLabel(""));
		entries.add(billsResults);
		entries.setBackground(Color.black);		

		results.add(scrollPane);
		billsPanel.add(entries, BorderLayout.BEFORE_FIRST_LINE);
		billsPanel.add(results, BorderLayout.CENTER);
		return billsPanel;

	}
	
	public JDialog displayCandidatesbyZip() {
		JDialog candidatePanel = new JDialog();
		JPanel entries = new JPanel(new GridLayout(1,0));
		JPanel results = new JPanel(new GridLayout(0,1));
		
		zipLabel = new JLabel("Zip code:");		
		zip5Field = new JTextField(SwingConstants.LEFT);	
		zip4Field = new JTextField(SwingConstants.LEFT);
		zipLabel.setForeground(Color.WHITE);

		candidateResults = new JButton("OK");
		candidateResults.setPreferredSize(new Dimension(42,31));
		candidateResults.setForeground(Color.white);
		displayResults = new JTextArea();
		displayResults.setWrapStyleWord(true);
		displayResults.setEditable(false);
		displayResults.setLineWrap(true);
		
		JScrollPane scrollPane = new JScrollPane(displayResults);
		entries.setBackground(Color.black);		

		entries.add(zipLabel);
		entries.add(zip5Field);
		entries.add(new JLabel("-"));
		entries.add(zip4Field);
		entries.add(new JLabel(" "));
		entries.add(candidateResults);
		results.add(scrollPane);
		
                                   
		candidateResults.addActionListener(this);
		
		Border buttonBorder = BorderFactory.createEtchedBorder(Color.WHITE, Color.RED);
		candidateResults.setBorderPainted(true);
		candidateResults.setBorder(buttonBorder);	
		Border border = BorderFactory.createEmptyBorder(40, 40, 40, 40);
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
		if(e.getSource().equals(candidateResults)) {
			controller.requestCandidateData();
		}
		if(e.getSource().equals(electionResults)) {
			controller.requestElectionData();
		}
		if(e.getSource().equals(billsResults)) {
			controller.requestBillsData();
		}
		if(e.getSource().equals(stateOfficialResults)){
			controller.requestStateOfficialsData();
		}
		
	}
	
	
	public static void main (String [] args) {
		new VoteSmartView().setVisible(true);
	}
	
	
	
}
