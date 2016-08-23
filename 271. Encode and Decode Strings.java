public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuffer sb = new StringBuffer();
        for(String s : strs){
            sb.append(s.length() + "$" + s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> result = new ArrayList<String>();
        int start = 0;
        while(start < s.length()){
            int cur = s.indexOf("$",start);
            int size = Integer.valueOf(s.substring(start, cur));
            String sub = s.substring(cur+1,cur+1+size);
            result.add(sub);
            start = cur+1+size;
        }
        return result;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
