public class BinaryTreeArray {
    private String[] tree;
    private int lastUsedIndex;

    public BinaryTreeArray(int size) {
        tree = new String[size + 1];
        lastUsedIndex = 0;
        System.out.println("Binary Tree of size " + size + " has been created.");
    }

    public void insert(String value) {
        if (lastUsedIndex == tree.length - 1) {
            System.out.println("Binary Tree is full.");
            return;
        }
        lastUsedIndex++;
        tree[lastUsedIndex] = value;
        System.out.println("Inserted " + value + " at index " + lastUsedIndex);
    }

    public void populateTree() {
        if (tree.length - 1 < 9) {
            System.out.println("Tree array is too small to populate the given tree structure.");
            return;
        }

        tree[1] = "b";
        tree[2] = "i";
        tree[3] = "n";
        tree[4] = "-";
        tree[5] = "a";
        tree[6] = "r";
        tree[7] = "-";
        tree[8] = "-";
        tree[9] = "y";
        lastUsedIndex = 9;
        System.out.println("Tree populated with initial values.");
    }

    public String[] getChildren(String value) {
        int index = -1;
        for (int i = 1; i <= lastUsedIndex; i++) {
            if (tree[i] != null && tree[i].equals(value)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            return new String[] {};
        }

        String leftChild = null;
        String rightChild = null;

        int leftChildIndex = 2 * index;
        int rightChildIndex = 2 * index + 1;

        if (leftChildIndex <= lastUsedIndex && tree[leftChildIndex] != null && !tree[leftChildIndex].equals("-")) {
            leftChild = tree[leftChildIndex];
        }
        if (rightChildIndex <= lastUsedIndex && tree[rightChildIndex] != null && !tree[rightChildIndex].equals("-")) {
            rightChild = tree[rightChildIndex];
        }

        if (leftChild == null && rightChild == null) {
            return new String[] {};
        } else if (leftChild == null) {
            return new String[] { rightChild };
        } else if (rightChild == null) {
            return new String[] { leftChild };
        } else {
            return new String[] { leftChild, rightChild };
        }
    }

    public String getParent(String value) {
        int index = -1;
        for (int i = 1; i <= lastUsedIndex; i++) {
            if (tree[i] != null && tree[i].equals(value)) {
                index = i;
                break;
            }
        }

        if (index == -1 || index == 1) {
            return null;
        }

        int parentIndex = index / 2;
        return tree[parentIndex];
    }

    public void setRightChild(String parentValue, String newChildValue) {
        int parentIndex = -1;
        for (int i = 1; i <= lastUsedIndex; i++) {
            if (tree[i] != null && tree[i].equals(parentValue)) {
                parentIndex = i;
                break;
            }
        }

        if (parentIndex == -1) {
            System.out.println("Parent node '" + parentValue + "' not found.");
            return;
        }

        int rightChildIndex = 2 * parentIndex + 1;
        if (rightChildIndex >= tree.length) {
            System.out.println("Cannot set right child. Array is too small.");
            return;
        }
        tree[rightChildIndex] = newChildValue;
        if (rightChildIndex > lastUsedIndex) {
            lastUsedIndex = rightChildIndex;
        }
        System.out.println("Set right child of '" + parentValue + "' as '" + newChildValue + "'.");
    }

    public void setParent(String childValue, String newParentValue) {
        int childIndex = -1;
        for (int i = 1; i <= lastUsedIndex; i++) {
            if (tree[i] != null && tree[i].equals(childValue)) {
                childIndex = i;
                break;
            }
        }

        if (childIndex == -1) {
            System.out.println("Child node '" + childValue + "' not found.");
            return;
        }
        if (childIndex == 1) {
            System.out.println("Cannot set parent for root node.");
            return;
        }

        int parentIndex = childIndex / 2;
        String currentParentValue = tree[parentIndex];
        System.out.println("Current parent of '" + childValue + "' is '" + currentParentValue + "'.");
        tree[parentIndex] = newParentValue;
        System.out.println(
                "Set parent of '" + childValue + "' (at index " + parentIndex + ") as '" + newParentValue + "'.");
    }

    public int getHeight() {
        if (lastUsedIndex == 0) {
            return 0;
        }
        return (int) (Math.log(lastUsedIndex) / Math.log(2)) + 1;
    }

    public int getSize() {
        return lastUsedIndex;
    }

    public void printTree() {
        System.out.print("Tree elements: ");
        for (int i = 1; i <= lastUsedIndex; i++) {
            System.out.print(tree[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        BinaryTreeArray tree = new BinaryTreeArray(15);
        tree.populateTree();
        tree.printTree();

        System.out.println();

        // 1. Get the children of 'y'
        String[] childrenOfY = tree.getChildren("y");
        System.out.print("Children of 'y': ");
        if (childrenOfY.length == 0) {
            System.out.println("None");
        } else {
            for (String child : childrenOfY) {
                System.out.print(child + " ");
            }
            System.out.println();
        }

        // 2. Get the parent of 'r'
        String parentOfR = tree.getParent("r");
        System.out.println("Parent of 'r': " + (parentOfR != null ? parentOfR : "None"));

        // 3. Set the right child of 'n' as 'o'
        tree.setRightChild("n", "o");
        tree.printTree();

        // 4. Set the parent of 'y' as 'g'
        tree.setParent("y", "g");
        tree.printTree();

        // 5. Find the height of the Tree
        System.out.println("Height of the Tree: " + tree.getHeight());

        // 6. Find the size of the entire Tree
        System.out.println("Size of the entire Tree: " + tree.getSize());
    }
}