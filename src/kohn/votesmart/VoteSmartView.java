package kohn.votesmart;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.text.JTextComponent;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@SuppressWarnings("serial")

public class VoteSmartView extends JFrame {
	
	private JTextArea stateID;
	
	String stateIDField = "NY";
	public VoteSmartView() {
		setLocation(240, 80);
		setSize(980, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JTextArea stateID = new JTextArea(stateIDField);
		
		JPanel display = new JPanel();
		display.add(stateID);
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl("http://api.votesmart.org")
				.addConverterFactory(GsonConverterFactory.create())
				.build();
		VoteSmartService service = retrofit.create(VoteSmartService.class);
		
		VoteSmartController controller = new VoteSmartController(this, service);
		controller.requestStateData();
	}
	public JTextComponent getStateID() {
		return stateID;
	}
	public static void main (String [] args) {
		new VoteSmartView().setVisible(true);
	}
}
