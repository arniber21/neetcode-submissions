class DynamicArray {
    // Internal
    private int[] array;
    
    // How many elements we store
    private int length;

    public DynamicArray(int capacity) {
        array = new int[capacity];
        length = 0;
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
    }

    public void pushback(int n) {
        if(length >= array.length) resize();
        array[length] = n;
        length++;
    }

    public int popback() {
        length--;
        return array[length];
    }

    private void resize() {
        int newSize = array.length * 2;
        int[] newArr = new int[newSize];
        for(int i = 0; i < array.length; i++) {
            newArr[i] = array[i];
        }
        array = newArr;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return array.length;
    }
}
