class Solution {
    public int longestConsecutive(int[] nums) {
        UnionFind<Integer> uf = new UnionFind<>();

        // Add each unique number.
        for (int num : nums) {
            uf.add(num);
        }

        // Connect neighboring values if they exist.
        for (int num : nums) {
            if (uf.contains(num - 1)) {
                uf.union(num, num - 1);
            }

            if (uf.contains(num + 1)) {
                uf.union(num, num + 1);
            }
        }

        return uf.getLargestComponentSize();
    }

    private static class UnionFind<T> {
        private final Map<T, T> parent = new HashMap<>();
        private final Map<T, Integer> size = new HashMap<>();
        private int largestComponentSize = 0;

        public void add(T item) {
            if (parent.containsKey(item)) {
                return;
            }

            parent.put(item, item);
            size.put(item, 1);
            largestComponentSize = Math.max(largestComponentSize, 1);
        }

        public boolean contains(T item) {
            return parent.containsKey(item);
        }

        public T find(T item) {
            T currentParent = parent.get(item);

            if (!currentParent.equals(item)) {
                T root = find(currentParent);
                parent.put(item, root); // Path compression
                return root;
            }

            return item;
        }

        public void union(T a, T b) {
            T rootA = find(a);
            T rootB = find(b);

            if (rootA.equals(rootB)) {
                return;
            }

            int sizeA = size.get(rootA);
            int sizeB = size.get(rootB);

            // Union by size.
            if (sizeA < sizeB) {
                T tempRoot = rootA;
                rootA = rootB;
                rootB = tempRoot;

                int tempSize = sizeA;
                sizeA = sizeB;
                sizeB = tempSize;
            }

            parent.put(rootB, rootA);
            size.put(rootA, sizeA + sizeB);

            largestComponentSize =
                Math.max(largestComponentSize, sizeA + sizeB);
        }

        public int getLargestComponentSize() {
            return largestComponentSize;
        }
    }
}
