package week12;
//Veraendern Sie diese Datei nicht!

public class Node {
	
	private Node left, right;
	
	public Node(Node left, Node right) {
		this.setLeft(left);
		this.setRight(right);
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}