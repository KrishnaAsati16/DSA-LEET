class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s, 0, 0, "", ans);
        return ans;
    }

    void backtrack(String s, int index, int count, String ip, List<String> ans) {

        if (count == 4 && index == s.length()) {
            ans.add(ip.substring(0, ip.length() - 1));
            return;
        }

        if (count == 4 || index == s.length()) {
            return;
        }

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {

            String part = s.substring(index, index + len);

        
            if (part.length() > 1 && part.charAt(0) == '0') {
                continue;
            }
            if (Integer.parseInt(part) > 255) {
                continue;
            }

            backtrack(s, index + len, count + 1, ip + part + ".", ans);
        }
    }
}