package familytree;

import junit.framework.TestCase;
import model.FamilyTree;
import model.Member;
import exceptions.ParentException;

import java.util.List;

import org.junit.*;
import org.junit.runner.RunWith;

import junit.framework.TestCase;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class TestApp extends TestCase {

	private Member father;
	private Member mother;
	private FamilyTree familyTree;
	
	@Before
    public void createFamilyTree() {
    	father = new Member("Luke", true);
    	mother = new Member("Laura", false);
        familyTree = new FamilyTree(father, mother);
    }
	
	@Test
    public void testAddChildToFamilyTree() {
		Member son = new Member("Sam", true);
		
		try {
			familyTree.addChild(son, father, mother);
		} catch (ParentException e) {
			e.printStackTrace();
		}
		
		for (Member m : father.getChildren()) {
			assertEquals(son, m);
		}
		
		for (Member m : mother.getChildren()) {
			assertEquals(son, m);
		}
	}
	
	@Test
	public void testListParentsForFamilyMember() {
		Member son = new Member("Sam", true);
		
		try {
			familyTree.addChild(son, father, mother);
		} catch (ParentException e) {
			e.printStackTrace();
		}
		
		List<Member> parents = familyTree.listParentsForMember(son);
		
		for (Member parent : parents) {
			if (parent.isMale()) {
				assertEquals(parent, father);
			} else {
				assertEquals(parent, mother);
			}
		}
	}
	
	@Test
	public void testListChildrenForFamilyMember() {
		Member son = new Member("Sam", true);
		Member daughter = new Member("Sammie", false);
		
		try {
			familyTree.addChild(son, father, mother);
			familyTree.addChild(daughter, father, mother);
		} catch (ParentException e) {
			e.printStackTrace();
		}
		
		List<Member> children = familyTree.listChildrenForMember(father);
		
		for (Member child : children) {
			assertEquals(child.getFather(), father);
		}
	}
}
