package kohn.votesmart;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
	private JTextField stateIDField;
	private String stateEntry = "";
	private JTextArea stateResults;

	private JTextField zip5Field;
	private JTextField zip4Field;
	private JLabel zipLabel;
	private String zipCode = "";
	private String zip4 = "0000";

	private JTextArea candidateResults;

	private JButton resultButton;

	public VoteSmartView() {
		
		setLocation(240, 80);
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	
	    
		JPanel entries = new JPanel(new GridBagLayout());
		JPanel results = new JPanel(new GridLayout(0,1));
		stateIDLabel = new JLabel("Enter your state ID: ");
		stateIDField = new JTextField();		
		stateIDField.setText(stateEntry);
		
		zipLabel = new JLabel("Enter your zip code:");		
		zip5Field = new JTextField(SwingConstants.LEFT);	
		zip4Field = new JTextField(SwingConstants.RIGHT);

		zip5Field.setPreferredSize(new Dimension(100,32));

		zip4Field.setPreferredSize( new Dimension(120,32));

		resultButton = new JButton("OK");
		resultButton.setPreferredSize(new Dimension(42,31));
		candidateResults = new JTextArea();
		candidateResults.setWrapStyleWord(true);
		candidateResults.setEditable(false);
		candidateResults.setLineWrap(true);
		candidateResults.setPreferredSize(new Dimension(200, 250));

		JScrollPane scrollPane = new JScrollPane(candidateResults);
		
		results.add(scrollPane);
		GridBagConstraints gbc = new GridBagConstraints();
	    gbc.weightx = gbc.weighty = 10.0;
	    gbc.fill = gbc.gridy;
		
		zip5Field.setText(zipCode);
		zip4Field.setText(zip4);
        gbc.insets = new Insets(82, 13, 2, 3);

		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.gridx = 2;	
		gbc.gridy = 2;
		entries.add(zipLabel, gbc);
		gbc.gridx = 2;	
		gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(2, 4, 2, 4);

		entries.add(zip5Field, gbc);
		
		gbc.gridx = 4;
		gbc.gridy = 3;	
		entries.add(new JLabel("-"), gbc);
		gbc.gridx = 5;
		gbc.gridy = 3;	
        gbc.gridwidth = GridBagConstraints.REMAINDER;

		entries.add(zip4Field, gbc);
		gbc.gridx = 5;
		gbc.gridy = 4;
		gbc.gridwidth = 4;
		gbc.anchor = GridBagConstraints.CENTER;
		entries.add(resultButton, gbc);
                                   
		resultButton.addActionListener(this);
		
		//entries.add(stateIDLabel);
		//entries.add(stateIDField);
		//entries.setLayout(layout);
		
		
			
		Border buttonBorder = BorderFactory.createEtchedBorder(Color.WHITE, Color.gray);
		resultButton.setBorderPainted(true);
		resultButton.setBorder(buttonBorder);	
		Border border = BorderFactory.createEmptyBorder(12, 12, 12, 12);
		results.setBorder(border);
		entries.setBorder(border);
		add(entries,  BorderLayout.EAST);
		add(results, BorderLayout.CENTER);
	
		
	}
	public JTextComponent getStateID() {
		return stateIDField;
	}
	public JTextComponent getCandidatebyZip() {
		return candidateResults;
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
		controller.requestCandidateData();
	}
	
	public static void main (String [] args) {
		new VoteSmartView().setVisible(true);
	}
	
	
	
}
