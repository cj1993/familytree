package model;

import java.util.List;

public class Member {

	private String name;
	private boolean isMale;
	private List<Member> children;
	private Member father;
	private Member mother;
	private boolean source;
	
	public Member(String name, boolean isMale) {
		this.name = name;
		this.isMale = isMale;
		this.source = false;
	}
	
	public Member(String name, boolean isMale, boolean source) {
		this.name = name;
		this.isMale = isMale;
		this.source = source;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isMale() {
		return isMale;
	}
	
	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	
	public List<Member> getChildren() {
		return children;
	}
	
	public void setChildren(List<Member> children) {
		this.children = children;
	}
	
	public Member getFather() {
		return father;
	}
	
	public void setFather(Member father) {
		this.father = father;
	}
	
	public Member getMother() {
		return mother;
	}
	
	public void setMother(Member mother) {
		this.mother = mother;
	}
	
	public boolean isSource() {
		return source;
	}
	
	public void setSource(boolean source) {
		this.source = source;
	}
}
