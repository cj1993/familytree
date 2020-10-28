package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.ParentException;

public class FamilyTree {

	Member father;
	Member mother;

	public FamilyTree(Member father, Member mother) {
		this.father = father;
		this.mother = mother;

		this.father.setSource(true);
		this.mother.setSource(true);
	}
	
	public void addChild(Member child, Member father, Member mother) throws ParentException {
		if (father.isMale() && !mother.isMale()) {
			father.addChild(child);
			mother.addChild(child);
			child.setFather(father);
			child.setMother(mother);
		} else {
			throw new ParentException("Parent gender mismatch.");
		}
	}
	
	public List<Member> listParentsForMember(Member member) {
		List<Member> parentsForMember = new ArrayList<Member>();
		
		if (!member.isSource()) {
			parentsForMember.add(member.getFather());
			parentsForMember.add(member.getMother());
		}
		
		return parentsForMember;
	}
	
	public List<Member> listChildrenForMember(Member member) {
		List<Member> childrenForMember = new ArrayList<Member>();
		
		if (member.hasChildren()) {
			for (Member child : member.getChildren()) {
				childrenForMember.add(child);
			}
		}
		
		return childrenForMember;
	}
}
