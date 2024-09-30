class CustomStack {
    List<Integer> stack;
    int size = 0;
    int capacity;

    public CustomStack(int maxSize) {
        this.capacity = maxSize;
        stack = new ArrayList<>();
    }

    public void push(int x) {
        if(size < capacity) {
            size++;
            stack.add(x);
        }
    }

    public int pop() {
        if(size == 0) {
            return -1;
        }
        int temp = stack.get(size - 1);
        stack.remove(size - 1);
        size--;
        return temp;
    }

    public void increment(int k, int val) {
        int i = 0;
        while(i < k && i < size) {
            stack.set(i, stack.get(i) + val);
            i++;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */