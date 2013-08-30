package quickfind

class UFQuickFind {

    private final static int DEFAULT_SIZE = 10

    final int size

    final int[] objects

    def UFQuickFind(size) {
        this.size = size
        objects = new int[this.size]
        for (i in 0..this.size - 1) {
            objects[i] = i
        }
    }

    def UFQuickFind() {
        this(DEFAULT_SIZE)
    }

    def union(int first, int second) {
        int firstObject = objects[first]
        int secondObject = objects[second]

        for (i in 0..size - 1) {
            if (objects[i] == firstObject) {
                objects[i] = secondObject
            }
        }
    }

    def connected(int first, int second) {
        objects[first] == objects[second]
    }


    @Override
    public String toString() {
        return com.google.common.base.Objects.toStringHelper(this)
                .add("size", size)
                .add("objects", Arrays.toString(objects))
                .toString();
    }
}
