package kohn.votesmart;

import java.util.ArrayList;

import kohn.votesmart.InternalList.State.GeneralInfo;

public class Bills {
	
	private ArrayList<Bill> bill;
    private GeneralInfo generalInfo;
    	
	public Bills(ArrayList<Bill> bill) {
		this.bill = bill;
	}
	
	public ArrayList<Bill> getBill() {
		return bill;
	}	

	public GeneralInfo getGeneralInfo() {
		return generalInfo;
	}

	@Override
	public String toString() {
		return "\n" + this.bill;

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
			return	"\n" +"Bill No. " +this.billNumber+", "+this.title;			 
		}
	}

}
