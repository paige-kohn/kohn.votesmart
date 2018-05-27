package kohn.votesmart;

import java.util.List;

public class StateList {
	
	 private GeneralInfo generalInfo;
	 private State list;
	
	 
	 public StateList(State list, GeneralInfo generalInfo) {
		 this.list = list;
		 this.generalInfo = generalInfo;
	 }
	 public StateList() {
	 }
	 
	    public GeneralInfo getGeneralInfo ()
	    {
	        return generalInfo;
	    }
	    public State getList ()
	    {
	        return list;
	    }

	    @Override
	    public String toString()
	    {
	        return "["+list+"]";
	    }
	}
 class GeneralInfo
{
    private String title;
    private String linkBack;

    
    public String getTitle ()
    {
        return title;
    }


    public String getLinkBack ()
    {
        return linkBack;
    }

  
    @Override
    public String toString()
    {
        return " [title = "+title+", linkBack = "+linkBack+"]";
    }

		
}
