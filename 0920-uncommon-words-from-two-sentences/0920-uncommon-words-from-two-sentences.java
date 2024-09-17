class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        int m = s1.length(), n = s2.length();
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < m; i++) {
            if (s1.charAt(i) == ' ') {
                if (map1.containsKey(str.toString())) {
                    map1.remove(str.toString());
                    map1.put(str.toString(), 2);
                } else {
                    map1.put(str.toString(), 1);
                }
                str.setLength(0);
            } else {
                str.append(s1.charAt(i));
            }
        }
        if (map1.containsKey(str.toString())) {
            map1.remove(str.toString());
            map1.put(str.toString(), 2);
        } else {
            map1.put(str.toString(), 1);
        }
        str.setLength(0);
        for (int i = 0; i < n; i++) {
            if (s2.charAt(i) == ' ') {
                if (map2.containsKey(str.toString())) {
                    map2.remove(str.toString());
                    map2.put(str.toString(), 2);
                } else {
                    map2.put(str.toString(), 1);
                }
                str.setLength(0);
            } else {
                str.append(s2.charAt(i));
            }
        }
        if (map2.containsKey(str.toString())) {
            map2.remove(str.toString());
            map2.put(str.toString(), 2);
        } else {
            map2.put(str.toString(), 1);
        }
        str.setLength(0);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (s1.charAt(i) == ' ') {
                if (map1.get(str.toString()) == 1 && !map2.containsKey(str.toString())) {
                    list.add(str.toString());
                }
                str.setLength(0);
            } else {
                str.append(s1.charAt(i));
            }
        }
        if (map1.get(str.toString()) == 1 && !map2.containsKey(str.toString())) {
            list.add(str.toString());
        }
        str.setLength(0);
        for (int i = 0; i < n; i++) {
            if (s2.charAt(i) == ' ') {
                if (map2.get(str.toString()) == 1 && !map1.containsKey(str.toString())) {
                    list.add(str.toString());
                }
                str.setLength(0);
            } else {
                str.append(s2.charAt(i));
            }
        }
        if (map2.get(str.toString()) == 1 && !map1.containsKey(str.toString())) {
            list.add(str.toString());
        }
        str.setLength(0);
        return list.toArray(new String[0]);
    }
}