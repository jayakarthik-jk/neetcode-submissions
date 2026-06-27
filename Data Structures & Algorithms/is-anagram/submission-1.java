class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        var smap = buildMap(s);
        var tmap = buildMap(t);
        if (smap.keySet().size() != tmap.keySet().size()) {
            return false;
        }
        return smap.equals(tmap);
    }

    private static Map<Character, Integer> buildMap(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }
}
