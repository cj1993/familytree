package app;

import exceptions.ParentException;
import model.FamilyTree;
import model.Member;

public class App {

	public static void main( String[] args )
	{
		Member father = new Member("Luke", true);
		Member mother = new Member("Laura", false);

		FamilyTree familyTree = new FamilyTree(father, mother);

		Member son = new Member("Sam", true);
		Member daughter = new Member("Sammie", false);

		try {
			familyTree.addChild(son, father, mother);
			familyTree.addChild(daughter, father, mother);
		} catch (ParentException e) {
			e.printStackTrace();
		}
		
		familyTree.listParentsForMember(son);
		familyTree.listChildrenForMember(father);
	}
}
