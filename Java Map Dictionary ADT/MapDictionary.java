//
//  Name:       Casuga, Joshua
//  Homework:   #1
//  Due:        11/9/2022
//  Course:     cs-2400-01-f22
//
//  Description:
//              MapDictionary class that implements the DictionaryInterface.
//              Implementation of DictionaryInterface methods was done using HashMap
//              methods.

import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class MapDictionary<K,V> implements DictionaryInterface<K,V>{
    private Map<K,V> dictMap;

    public MapDictionary(){
        dictMap = new HashMap<>();
    }

    public V add(K key, V value) {
        return dictMap.put(key, value);
    }

    public V remove(K key) {
        return dictMap.remove(key);
    }

    public V getValue(K key) {
        return dictMap.get(key);
    }

    public boolean contains(K key) {
        return dictMap.containsKey(key);
    }

    public Iterator getKeyIterator() {
        return dictMap.keySet().iterator();
    }

    public boolean isEmpty() {
        return dictMap.isEmpty();
    }

    public int getSize() {
        return dictMap.size();
    }

    public void clear() {
        dictMap.clear();
    }

    public Iterator getValueIterator() { //not implemented
        throw new UnsupportedOperationException("Not Implemented.");
    }
}
