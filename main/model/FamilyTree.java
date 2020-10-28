package model;

public class FamilyTree {

	Member father;
	Member mother;
	
	public FamilyTree(Member father, Member mother) {
		this.father = father;
		this.mother = mother;
		
		this.father.setSource(true);
		this.mother.setSource(true);
	}
}
