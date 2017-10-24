import java.util.Stack;


public class BSTree {
	class BSTNode{
		private String data;
		private BSTNode left;
		private BSTNode right;
	}
	private BSTNode root;
	public BSTree(){
		root = null;
	}
	public boolean find(String value){
		return find(value, root);
	}
	
	//preorder method with global vairable to hold string
	public String POstring = "";
	public void PreOrder(BSTNode node){
		//System.out.println(node.data);
		if(node != null){
			
			POstring += node.data + " ";
			PreOrder(node.right);
			PreOrder(node.left);
		}
	}
	//method to return string
	public String toStringPreOrder(){
		
		PreOrder(root);
		//System.out.println("here");
		//System.out.println("values: "+  POstring);
		return POstring.trim();
		
	}
	//inorder traversal with global variable
	public String IOstring = "";
	public void InOrder(BSTNode node){
		if(node != null){
			InOrder(node.right);
			IOstring += node.data + " ";
			InOrder(node.left);
		}
	}
	//method to return string
	public String toStringInOrder(){
		InOrder(root);
		//System.out.println(IOstring);
		return IOstring.trim();
	}
	//find method
	public boolean find(String value, BSTNode node){
		if(node == null)
			return false;
		if(node.data.compareTo(value) == 0){
			return true;
		}
		else if(node.data.compareTo(value) < 0){
			return find(value, node.left);
		}
		else{return find(value, node.right);}
	}
	//insert call
	public void insert(String data) {
		root = insert(data, root);
	}
	//insert method
	private BSTNode insert(String data, BSTNode node) {
		if(node == null){
			node = new BSTNode();
			node.data = data;
			return node;
		}
		if(node.data.compareTo(data) <= 0){
			node.left = insert(data, node.left);
		}
		else if(node.data.compareTo(data) > 0){
			node.right = insert(data, node.right);
		}
		return node;
	}
	public void delete(String string) {
		root = delete(string, root);
	}
	//delete method
	private BSTNode delete(String string, BSTNode node) {
		if(node == null)
			return null;
		if(node.data.compareTo(string) == 0){
			if(node.left == null)
				return node.right;
			else if(node.right == null)
				return node.left;
			else{
				if(node.right.left == null){
					node.data = node.right.data;
					node.right = node.right.right;
					return node;
				}
				else{
					node.data = removesmallest(node.right);
					return node;
				}
			}
		}
		else if(string.compareTo(node.data) < 0)
			node.left = delete(string, node.left);
		else if(string.compareTo(node.data) > 0)
			node.right = delete(string, node.right);
		return node;
	}
	//removesmallest method
	public String removesmallest(BSTNode node){
		if(node.left.left == null){
			String smallest = node.left.data;
			node.left = node.left.right;
			return smallest;
		}
		
		else{return removesmallest(node.left);}
	}
	
	}

