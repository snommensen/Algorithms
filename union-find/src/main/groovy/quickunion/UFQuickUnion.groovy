package quickunion

class UFQuickUnion {

    private final static int DEFAULT_SIZE = 10

    final int size

    final int[] objects
    final int[] noOfObjectsInTree

    def UFQuickUnion(size) {
        this.size = size
        objects = new int[this.size]
        for (i in 0..this.size - 1) {
            objects[i] = i
        }
        noOfObjectsInTree = new int[this.size - 1]
    }

    def UFQuickUnion() {
        this(DEFAULT_SIZE)
    }

    def root(int i) {
        while (i != objects[i]) {
            objects[i] = objects[objects[i]]
            i = objects[i]
        }
        i
    }

    def union(int first, int second) {
        int firstRoot = root(first)
        int secondRoot = root(second)
        if (noOfObjectsInTree[firstRoot] < noOfObjectsInTree[secondRoot]) {
            objects[firstRoot] = secondRoot
            noOfObjectsInTree[secondRoot] += noOfObjectsInTree[firstRoot]
        } else {
            objects[secondRoot] = firstRoot
            noOfObjectsInTree[firstRoot] += noOfObjectsInTree[secondRoot]
        }
    }

    def connected(int first, int second) {
        root(first) == root(second)
    }

    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("size", size)
                .add("objects", Arrays.toString(objects))
                .toString();
    }
}
