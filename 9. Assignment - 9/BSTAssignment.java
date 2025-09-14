/* Fundamental data structures and their applications: Trees

Implement a Binary Search Tree using a linked list to insert the elements:  50,30,70,20,40,60,80
Display the elements using inorder, preorder, postorder
Search for the elements 40, 90
Find the minimum value in the above BST
Find the maximum value in the above BST
Delete 80,70,30 from the BST
Display again the elements in any of the traversal methods. */

class Node{
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data = data ;
		this.left = null;
		this.right = null;
	}
}
class BSTADT{
	Node root;
	public BSTADT(){
		this.root = null;
	}
	public boolean isEmpty(){
		return root == null;
	}
	public Node insert(Node cNode , int data){
		if(cNode == null){
			cNode = new Node(data);
			return cNode;
		}else{
			if(data < cNode.data){
				cNode.left = insert(cNode.left , data);
				return cNode;
			}else{
				cNode.right = insert(cNode.right , data);
				return cNode;
				
			}
		}
	}
	public void inOrderTraversal(Node cNode){
		if(cNode != null){
			inOrderTraversal(cNode.left);
			System.out.print(cNode.data + " ");
			inOrderTraversal(cNode .right);
		}
	}
	public void preOrderTraversal(Node cNode){
		if(cNode != null){
			System.out.print(cNode.data + " ");
			preOrderTraversal(cNode.left);
			preOrderTraversal(cNode.right);
		}
	}
	public void postOrderTraversal(Node cNode){
		if(cNode != null){
			postOrderTraversal(cNode.left);
			postOrderTraversal(cNode.right);
			System.out.print(cNode.data + " ");
			
		}
	}
	public boolean search(Node cNode , int data){
		if(cNode == null){
			return false;
		}else{
			if(data == cNode.data){
				return true;
			}
			else if(data < cNode.data){
				return search(cNode.left , data);
			}else{
				return search(cNode.right , data);
			}
		}
	}
	public Node searchNode(Node cNode ,  int data){
		if(cNode == null){
			return cNode;
		}else{
			if(cNode.data == data){
				return cNode;
			}else if(data < cNode.data){
				return searchNode(cNode.left , data);
				
			}else{
				return searchNode(cNode.right , data);
				
			}
		}
	}
	public int findMin(Node cNode){
		if(cNode.left == null & cNode.right == null){
			return cNode.data;
		}else{
			return findMin(cNode.left);
		}
	}
	public int findMax(Node cNode){
		if(cNode.left == null & cNode.right == null){
			return cNode.data;
		}else{
			return findMax(cNode.right);
		}
	}
	
	public Node delete(Node cNode , int data) {
    if (cNode == null) {
        System.out.println("Element not found. Cannot delete.");
        return null;
    }

    if (data < cNode.data) {
        cNode.left = delete(cNode.left, data);
    } else if (data > cNode.data) {
        cNode.right = delete(cNode.right, data);
    } else {
       
        if (cNode.left == null && cNode.right == null) {
            return null;
        } else if (cNode.left == null) {
            return cNode.right;
        } else if (cNode.right == null) {
            return cNode.left;
        } else {
            int minValue = findMin(cNode.right);
            cNode.data = minValue;
            cNode.right = delete(cNode.right, minValue);
        }
    }
    return cNode;
}

	
}
public class BSTAssignment{
	public static void main(String args[]){
		BSTADT bst = new BSTADT();
		
		bst.root = bst.insert(bst.root , 50);
		bst.root = bst.insert(bst.root , 30);
		bst.root = bst.insert(bst.root , 70);
		bst.root = bst.insert(bst.root , 20);
		bst.root = bst.insert(bst.root , 40);
		bst.root = bst.insert(bst.root , 60);
		bst.root = bst.insert(bst.root , 80);
		
		System.out.print("Inorder Traversal : ");
		bst.inOrderTraversal(bst.root);
		System.out.println();
		
		System.out.print("Preorder Traversal : ");
		bst.preOrderTraversal(bst.root);
		System.out.println();
		
		System.out.print("Post order Traversal : ");
		bst.postOrderTraversal(bst.root);
		System.out.println();
		
		System.out.println("Is 40 in array? : " + bst.search(bst.root , 40));
		System.out.println("Is 90 in array? : " + bst.search(bst.root , 90));
		
		System.out.println("Minimum value : " + bst.findMin(bst.root));
		System.out.println("Maximum value : " + bst.findMax(bst.root));
		
		bst.delete(bst.root , 80);
		System.out.print("Inorder Traversal : ");
		bst.inOrderTraversal(bst.root);
		System.out.println();
		bst.delete(bst.root , 70);
		bst.delete(bst.root , 30);
		
		System.out.print("Inorder Traversal : ");
		bst.inOrderTraversal(bst.root);
		System.out.println();
		
	}
}