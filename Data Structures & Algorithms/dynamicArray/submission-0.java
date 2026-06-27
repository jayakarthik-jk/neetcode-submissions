class DynamicArray {
    int[] inner;
    int length = 0;
    int capacity;
    public DynamicArray(int capacity) {
        this.capacity = capacity;
        inner = new int[capacity];
    }

    public int get(int i) {
        return inner[i];
    }

    public void set(int i, int n) {
        inner[i] = n;
    }

    public void pushback(int n) {
        if (length >= capacity) {
            resize();
        }
        inner[length++] = n;
    }

    public int popback() {
        return inner[length-- - 1];
    }

    private void resize() {
        capacity *= 2;
        int[] newInner = new int[capacity];
        for (int i = 0; i < length; i++) {
            newInner[i] = inner[i];
        }
        inner = newInner;
    }

    public int getSize() {
        return length;
    }

    public int getCapacity() {
        return capacity;
    }
}
