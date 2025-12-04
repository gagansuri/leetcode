class TimeMap {
    Map<String,TreeMap<Integer,String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)) map.put(key, new TreeMap<>());
        
        TreeMap<Integer,String> innerMap = map.get(key);
        innerMap.put(timestamp, value);
        //map.put(key, innerMap);
       // System.out.println(" set:" + map);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

       TreeMap<Integer,String> inner = map.get(key);
        if(inner.containsKey(timestamp)) return inner.get(timestamp);
 /*
        System.out.println(" get:" + map + " innermap : "+inner.firstEntry().getValue() + " key : "+ key + " timestamp : "+ timestamp);
        return inner.firstEntry().getValue().toString();
*/
        Map.Entry<Integer,String> entry = inner.floorEntry(timestamp);

        return entry == null ? "" : entry.getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */