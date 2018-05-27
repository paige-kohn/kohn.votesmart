package kohn.votesmart;

import java.util.ArrayList;

public class List
{
	    private State state;
	    
	    public List(State state) {
	    	this.state = state;
	    }
	    public State getState(){
	        return this.state;
	    }
	


    @Override
    public String toString()
    {
        return "[state = "+state+"]";
    }
}
