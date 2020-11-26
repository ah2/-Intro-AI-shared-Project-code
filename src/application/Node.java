package application;

public class Node {

	int x;
	int y;
	Node left;
	Node down;
	Node up;
	Node right;
	
	void setPosition(int y, int x) {
		this.x= x;
		this.y= y;
	}
	
	Node(int y, int x) {
		this.x= x;
		this.y= y;
		 left=null;
		 down=null;
		 up=null;
		 right=null;
	}
	Node() {
		 left=null;
		 down=null;
		 up=null;
		 right=null;
	}
}
