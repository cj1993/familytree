package app;

import model.FamilyTree;
import model.Member;

public class App {

	public static void main( String[] args )
    {
    	Member father = new Member("Luke", true);
    	Member mother = new Member("Laura", false);
    	
        FamilyTree familyTree = new FamilyTree(father, mother);
        
        
    }
}
