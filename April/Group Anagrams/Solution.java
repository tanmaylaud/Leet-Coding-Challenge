class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anaTypes = new ArrayList();
        Map<String, List<String>> map = new HashMap();

        for (int i = 0; i < strs.length; i++) {
            addToMap(map, strs[i].toCharArray(), strs[i]);
        }
        for (String key : map.keySet()) {
            List<String> ana = map.get(key);
            anaTypes.add(ana);
        }
        return anaTypes;
    }

    public void addToMap(Map<String, List<String>> map, char[] chars, String string) {
        Arrays.sort(chars);
        String sorted = new String(chars);
        List<String> list;
        if (map.containsKey(sorted)) {
            list = map.get(sorted);
        } else
            list = new ArrayList();

        list.add(string);
        map.put(sorted, list);
    }

}