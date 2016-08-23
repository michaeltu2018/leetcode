public class ValidWordAbbr {
    Map<String, String> map = new HashMap<String, String>();
    public ValidWordAbbr(String[] dictionary) {
        for(String s : dictionary){
            String abbr = genAbbr(s);
            if(!map.containsKey(abbr)){
                map.put(abbr, s);
            }
            else{
                if(!map.get(abbr).equals(s))map.put(abbr, "");
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = genAbbr(word);
        return (!map.containsKey(abbr)) ||  (map.get(abbr).equals(word));
    }
    
    String genAbbr(String s){
        if(s.length() <= 2){
            return s;
        }
        return s.charAt(0) + Integer.toString(s.length()-2) + s.charAt(s.length()-1);
    }
    
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
