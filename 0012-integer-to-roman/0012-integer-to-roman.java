class Solution {
    public String intToRoman(int num) {
        int temp = num, i = 1;
        StringBuilder str = new StringBuilder("");
        while(temp > 0) {
            int last = (temp % 10) * i;
            temp /= 10;
            i *= 10;
            if(last == 0) {
                continue;
            }
            else if(last < 10) {
                if(last >= 5) {
                    if(last <= 8) {
                        for(int j = 0; j < last - 5; j++) {
                            str.append('I');
                        }
                        str.append('V');
                    }
                    else {
                        str.append("XI");
                    }
                }
                else {
                    if(last < 4) {
                        for(int j = 0; j < last; j++) {
                            str.append('I');
                        }
                    }
                    else {
                        str.append("VI");
                    }
                }
            }
            else if(last < 100) {
                if(last >= 50) {
                    if(last <= 80) {
                        for(int j = 0; j < last - 50; j += 10) {
                            str.append('X');
                        }
                        str.append('L');
                    }
                    else {
                        str.append("CX");
                    }
                }
                else {
                    if(last < 40) {
                        for(int j = 0; j < last; j += 10) {
                            str.append('X');
                        }
                    }
                    else {
                        str.append("LX");
                    }
                }
            }
            else if(last < 1000) {
                if(last >= 500) {
                    if(last <= 800) {
                        for(int j = 0; j < last - 500; j += 100) {
                            str.append('C');
                        }
                        str.append('D');
                    }
                    else {
                        str.append("MC");
                    }
                }
                else {
                    if(last < 400) {
                        for(int j = 0; j < last; j += 100) {
                            str.append('C');
                        }
                    }
                    else {
                        str.append("DC");
                    }
                }
            }
            else {
                for(int j = 0; j < last; j += 1000) {
                    str.append('M');
                }
            }
        }
        return str.reverse().toString();
    }
}