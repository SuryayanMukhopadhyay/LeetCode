class Spreadsheet {
    HashMap<String, Integer> map;

    public Spreadsheet(int rows) {
        map = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        if(map.containsKey(cell)) {
            map.remove(cell);
        }
        map.put(cell, value);
    }
    
    public void resetCell(String cell) {
        if(map.containsKey(cell)) {
            map.remove(cell);
        }
        map.put(cell, 0);
    }
    
    public int getValue(String formula) {
        StringBuilder str1 = new StringBuilder("");
        int i = 1;
        while(formula.charAt(i) != '+') {
            str1.append(formula.charAt(i));
            i++;
        }
        int n = formula.length();
        i++;
        StringBuilder str2 = new StringBuilder("");
        while(i < n) {
            str2.append(formula.charAt(i));
            i++;
        }
        int num1 = 0;
        if(str1.charAt(0) >= 'A' && str1.charAt(0) <= 'Z') {
            if(map.containsKey(str1.toString()))
                num1 = map.get(str1.toString());
            else 
                num1 = 0;
        }
        else {
            num1 = Integer.parseInt(str1.toString());
        }
        int num2 = 0;
        if(str2.charAt(0) >= 'A' && str2.charAt(0) <= 'Z') {
            if(map.containsKey(str2.toString()))
                num2 = map.get(str2.toString());
            else 
                num2 = 0;
        }
        else {
            num2 = Integer.parseInt(str2.toString());
        }
        return num1 + num2;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */