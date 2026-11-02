class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        
        for (String str : strs) {
            Arrays.fill(count, 0);
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                if (count[i] != 0) {
                    sb.append((char)(i + 'a')).append(count[i]);
                }
            }
            String flag = sb.toString();
            if (!map.containsKey(flag)) {
                map.put(flag, new ArrayList<>());
            }
            map.get(flag).add(str);
        }
        return new ArrayList<>(map.values());
    }
}