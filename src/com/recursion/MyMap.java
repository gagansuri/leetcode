/*
package com.recursion;

public class MyMap {

    public class MyMap<MapEntry<K,V>> {
        List<List<MapEntry>> mBuckets;

        // MapEntry[] mEntry;
        int size = 10;
        class MapEntry<K,V>{
            K key;
            V value;
        }
        public MyMap<K,V>(){
            mBuckets = new ArrayList<>();
        }

        public void set(int key, Object value) {
            //hash the key
            int location = key % size;
            if(mBuckets.get(location) == null) {
                List<MapEntry> mp = new ArrayList<>();
                MapEntry mapEntry = new MapEntry();
                mapEntry.key = key;
                mapEntry.value = value;
                mp.add(mapEntry);
                mBuckets.add(mp);
            } else {
                List<MapEntry> list = mBuckets.get(location);
                int i = 0 ;
                MapEntry mapEntry = new MapEntry();
                mapEntry.key = key;
                mapEntry.value = value;
                for(; i< list.size();i++) {

                }
                list.add(i, mapEntry);
            }
        }


    }

//implement a map
// get and set operations

// get(<K> key)
//set(<T>T, <V> value)

// if on get , there is nothing - return null

// not a map , no hashing DS

// key is unique - overrite
// adding the object - -- later - expandable like a normal map

//get and set ~ O(1)

// key : array for keys and hashing the array% count of array
// object : array values, location would be same as key hash



}
 */