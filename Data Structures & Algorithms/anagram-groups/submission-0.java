class Solution {
    record Pair<First, Second>(First first, Second second) {}
    
    public List<List<String>> groupAnagrams(String[] strs) {
        List<Pair<List<String>, Map<Character, Integer>>> groups = new ArrayList<>();
        for (String str: strs) {
            var found = false;
            var map = buildMap(str);
            for (var pair: groups) {
                var group = pair.first();
                var groupMap = pair.second();
                if (groupMap.equals(map)) {
                    group.add(str);
                    found = true;
                    break;
                }
            }
            if (!found) {
                List<String> group = new ArrayList<>();
                group.add(str);
                groups.add(new Pair(group, map));
            }
        }
        return groups.stream()
            .map(Pair::first)
            .toList();
    }

    private Map<Character, Integer> buildMap(String s) {
        Map<Character, Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, Integer::sum);
        }
        return map;
    }
}
