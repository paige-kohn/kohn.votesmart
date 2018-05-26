package kohn.votesmart;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressWarnings("serial")

public class VoteSmartView extends JFrame {
	
	private JTextArea stateID;
	private JTextField stateIDField;
	private JTextField zipField;
	private JTextArea candidate;
	
	Call<VoteSmartModel>call;

	public VoteSmartView() {
		setLocation(240, 80);
		setSize(980, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		stateIDField = new JTextField();
		 
		stateIDField.setText("StateId=NY");
		stateID = new JTextArea();
		zipField = new JTextField();
		//zipField.setText("11230");
		candidate = new JTextArea();
		candidate.setWrapStyleWord(true);

		JPanel display = new JPanel(new GridLayout(1,0));
		//display.add(stateID);
		//display.add(stateIDField);
		display.add(zipField);
		display.add(candidate);
		Border border = BorderFactory.createEmptyBorder(20, 20, 20, 20);
		display.setBorder(border);
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://api.votesmart.org")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		VoteSmartService service = retrofit.create(VoteSmartService.class);
		
		VoteSmartController controller = new VoteSmartController(this, service);
		controller.requestStateData();
		add(display);
	}
	public JTextComponent getStateID() {
		return stateIDField;
	}
	public JTextComponent getCandidatebyZip() {
		return candidate;
	}
	
	public String getZipEntry() {
		return "zip5=11230&zip4=3341";
	}
	public static void main (String [] args) {
		new VoteSmartView().setVisible(true);
	}
	
	
}
