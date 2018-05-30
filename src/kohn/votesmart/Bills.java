package kohn.votesmart;

import java.util.ArrayList;

public class Bills {
	
	private ArrayList<Bill> bill;
    private GeneralInfo generalInfo;
    	
	public Bills(ArrayList<Bill> bill) {
		this.bill = bill;
	}
	
	public ArrayList<Bill> getBill() {
		return bill;
	}	
	   public GeneralInfo getGeneralInfo ()
	    {
	        return generalInfo;
	    }

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("\n").append(this.bill);
		return sb.toString();

	}

	public class Bill {
		private String title;
		private String billNumber;
		private String billId;
		private String type;

		public Bill(String title, String billNumber, String billId, String type) {
			this.title = title;
			this.billNumber = billNumber;
			this.billId = billId;
			this.type = type;
		}

		public String getTitle() {
			return title;
		}

		public String getBillNumber() {
			return billNumber;
		}

		public String getBillId() {
			return billId;
		}

		public String getType() {
			return type;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("\n").append("Bill No. ").append(this.billNumber).append(", ").append(this.title);

			return sb.toString();
		}

		

	}

}
