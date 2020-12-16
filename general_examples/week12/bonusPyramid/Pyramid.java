package bonusPyramid;
/*
 * Author: Jean Marc Mueller; Autumn 2020
 * Einfuehrung in die Programmierung - Series 10
 * Implement "public static boolean isPyramid(Node node) {...}" method.
 */


public class Pyramid {

	public static void main(String[] args) {
		Node pyramid = new Node(
			new Node(null, null),
			new Node(null, null));
        System.out.println("result: " + isPyramid(pyramid));
	}
	
	
	public static boolean isPyramid(Node node) {
		// throw exception if parameter is "null"
		if (node == null)
			throw new IllegalArgumentException("Input parameter must not "
					+ "point to \"null\"!");
		
		// check levels of supposed pyramid recursively
		Node[] firstLvl = new Node[] {node};
		return checkNextLvl(firstLvl);
	}
	
	
	public static boolean checkNextLvl(Node[] thisLvl) {
		// (for all levels k >= 1: thisLvl.length = k)
		// check if level thisLvl.length has thisLvl.length different nodes,
		// that do not point to null ((thisLvl[0] != null) is already verified)
		for (int j = 0; j < thisLvl.length - 1; j++) {
			for (int k = j + 1; k < thisLvl.length; k++) {
				if (thisLvl[k] == null || thisLvl[j] == thisLvl[k])
					return false;
			}
		}
		
		if (thisLvl[0].getLeft() == null) {
			// this level is supposed to be the last level
			// ( => #levels = thisLvl.length)
			// check if all subnodes of this level are null
			for (int k = 0; k < thisLvl.length; k++) {
				if (thisLvl[k].getLeft() != null || 
						thisLvl[k].getRight() != null)
					return false;
			}
			
			return true;
		} else {
			// there is at least 1 more level
			// ( => #levels >= thisLvl.length + 1)
			// create array for next level and check if
			// (thisLvl[k].right == thisLvl[k + 1].left) holds for all nodes
			Node[] nextLvl = new Node[thisLvl.length + 1];
			nextLvl[0] = thisLvl[0].getLeft();

			for (int k = 0; k < thisLvl.length; k++) {
				nextLvl[k + 1] = thisLvl[k].getRight();
				
				if (k + 1 < thisLvl.length && nextLvl[k + 1] != 
						thisLvl[k + 1].getLeft())
					return false;
			}
			
			// this level seems fine, check next level of supposed pyramid
			return checkNextLvl(nextLvl);
		}
	}
}
