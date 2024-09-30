public class Codec {
    public class HashGen {
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = "abcdefghijklmnopqrstuvwxyz";
        String nums = "0123456789";
        String all = upper + lower + nums;

        public HashGen() {

        }
        public String generate() {
            char[] str = new char[8];
            Random r = new Random();
            for(int i = 0; i < 8; i++) {
                str[i] = all.charAt(r.nextInt(all.length()));
            }
            return new String(str);
        }
    }
    HashMap<String, String> map = new HashMap<>();
    HashGen G = new HashGen();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String str = G.generate();
        map.put(str, longUrl);
        return str;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));