package jobdu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test_1009 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in.nextLine();
		String str = in.nextLine();
		int[] initalArray = new int[str.length()];
		inputArray(initalArray, str);
		BSTNode initialBST = buildBST(initalArray);
		List<BSTNode> compareList = new ArrayList<BSTNode>();
		String compareStr = in.nextLine();
		while(!compareStr.equals("0")) {
			int[] compareArray = new int[compareStr.length()];
			inputArray(compareArray, compareStr);
			BSTNode compareBST = buildBST(compareArray);
			compareList.add(compareBST);
			compareStr = in.nextLine();
		}
		for(int i=0; i<compareList.size(); i++) {
			BSTNode compareBST = compareList.get(i);
			System.out.println(compareBST(initialBST, compareBST)?"YES":"NO");
		}		
	}
	
	public static void inputArray(int[] array, String str) {
		for(int i=0; i<str.length(); i++) {
			array[i] = str.charAt(i)-48;
		}
	}

	public static BSTNode buildBST(int[] array) {
		BSTNode root = null;
		BSTNode parent = root;
		for(int i=0; i<array.length; i++) {
			BSTNode node = new BSTNode(array[i]);
			parent = BSTSearch(root, array[i], parent);
			if(parent == null) {
				root = node;
				parent = node;				
			}
			else {
				if(node.getData() < parent.getData()) {
					parent.setLNode(node);
				}
				else if(node.getData() > parent.getData()) {
					parent.setRNode(node);
				}
			}
		}
//		midTraverse(root);
		return root;
	}
	
	public static BSTNode BSTSearch(BSTNode T, int key, BSTNode p) {
		if(T==null) {
			return p;
		}
		else if(key == T.getData()) {
			return T;
		}
		else if(key < T.getData()) {
			return BSTSearch(T.getLNode(), key, T);
		}
		else {
			return BSTSearch(T.getRNode(), key, T);
		}
	}
	
	public static boolean compareBST(BSTNode node1, BSTNode node2) {
		if(node1 != null && node2 != null) {
			if(node1.getData() == node2.getData()) {
				return compareBST(node1.getLNode(), node2.getLNode())
				&& compareBST(node1.getRNode(), node2.getRNode());
			}
			else {
				return false;
			}
		}
		else if(node1 == null && node2 == null)
			return true;
		else {
			return false;
		}
	}
	
	public static void midTraverse(BSTNode node) {
		if(node != null) {
			midTraverse(node.getLNode());
			System.out.print(node.getData());
			midTraverse(node.getRNode());
		}
	}
}

class BSTNode {
	private int data;
	private BSTNode lNode, rNode;
	public BSTNode(int data) {
		this.data = data;
		lNode = null;
		rNode = null;
	}
	public void setLNode(BSTNode node) {
		this.lNode = node;
	}
	public void setRNode(BSTNode node) {
		this.rNode = node;
	}
	public int getData() {
		return this.data;
	}
	public BSTNode getLNode() {
		return this.lNode;
	}
	public BSTNode getRNode() {
		return this.rNode;
	}
}
