public class WordDistance {
    Map<String, List<Integer>> map;
    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for(int i=0;i<words.length;i++){
            if(map.containsKey(words[i])){
                map.get(words[i]).add(i);
            }
            else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(words[i], list);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int res = Integer.MAX_VALUE;
        for(int i=0, j=0; i<list1.size()&&j<list2.size();){
            int index1 = list1.get(i);
            int index2 = list2.get(j);
            if(index1 < index2){
                res = Math.min(res, index2 - index1);
                i++;
            }
            else{
                res = Math.min(res, index1 - index2);
                j++;
            }
        }
        return res;
    }
}

// Your WordDistance object will be instantiated and called as such:
// WordDistance wordDistance = new WordDistance(words);
// wordDistance.shortest("word1", "word2");
// wordDistance.shortest("anotherWord1", "anotherWord2");
