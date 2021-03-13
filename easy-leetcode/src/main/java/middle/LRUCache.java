package middle;

import java.util.LinkedHashMap;

/**
 * @Author: <a href="mailto:">jiaxue.pjx@alibaba-inc.com</a>
 * @Description:
 * @Date: Created in 下午8:37 2021/3/13
 */
public class LRUCache {

    LinkedHashMap<Integer, Integer> map;
    int capacity;

    public LRUCache(int capacity) {
        map = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        }
        while (map.size() >= capacity) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
        map.put(key, value);
    }
}
