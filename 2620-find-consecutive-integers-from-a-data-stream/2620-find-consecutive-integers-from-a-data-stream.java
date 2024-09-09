class DataStream {
    int value;
    int k;
    int problem = 0;
    int stream = 0;
    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
    }
    
    public boolean consec(int num) {
        stream++;
        if(num != value) {
            problem = 1;
        }
        else if(problem != 0){
            problem++;
        }
        if(stream < k) {
            return false;
        }
        if(problem > k || problem == 0) {
            return true;
        }
        return false;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */