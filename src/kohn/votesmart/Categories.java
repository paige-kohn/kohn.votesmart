package kohn.votesmart;

import java.util.ArrayList;

import org.votesmart.data.CandidateRating.Rating.Category;

public class Categories
{
    private ArrayList<Category> category;
    private GeneralInfo generalInfo;

    public ArrayList<Category> getCategory ()
    {
        return category;
    }



    @Override
    public String toString()
    {
    	StringBuilder sb = new StringBuilder();
    	sb.append("\n").append(category);
    	return sb.toString();
    }
}
	
