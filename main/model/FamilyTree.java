package model;

import java.util.ArrayList;
import java.util.List;

import exceptions.ParentException;

public class FamilyTree {

	private Member father;
	private Member mother;

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
	
	public List<Member> listAllDescendantsForMember(Member member) {
		List<Member> descendants = new ArrayList<Member>();
		
		this.getDescendantsRecursive(member, descendants);
		
		return descendants;
	}
	
	public List<Member> listAllAncestorsForMember(Member member) {
		List<Member> ancestors = new ArrayList<Member>();
		
		this.getAncestorsRecursive(member, ancestors);
		
		return ancestors;
	}
	
	private List<Member> getAncestorsRecursive(Member member, List<Member> ancestors) {		
		for (Member m : member.getParents()) {
			if (m.isSource()) {
				ancestors.add(m);
			} else {
				ancestors.add(m);
				this.getAncestorsRecursive(m, ancestors);
			}
		}
		
		return ancestors;
	}
	
	private List<Member> getDescendantsRecursive(Member member, List<Member> descendants) {		
		for (Member m : member.getChildren()) {
			if (m.hasChildren()) {
				descendants.add(m);
				this.getDescendantsRecursive(m, descendants);
			} else {
				descendants.add(m);
			}
		}
		
		return descendants;
	}
}
