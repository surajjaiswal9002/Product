package com.Target.Product.DSA;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyRedis {

    // Normal Redis key-value store
    private final ConcurrentHashMap<String, Object> store = new ConcurrentHashMap<>();

    // Redis Hash store (HSET, HGET)
    private final ConcurrentHashMap<String, Map<String, Object>> hashStore = new ConcurrentHashMap<>();

    // =============================
    //  STRING OPERATIONS
    // =============================

    // SET key value
    public void set(String key, Object value) {
        store.put(key, value);
    }

    // GET key
    public Object get(String key) {
        return store.get(key);
    }

    // DEL key
    public void del(String key) {
        store.remove(key);
    }

    // =============================
    //  HASH OPERATIONS (HSET, HGET)
    // =============================

    // HSET key field value
    public void hset(String key, String field, Object value) {
        hashStore.computeIfAbsent(key, k -> new ConcurrentHashMap<>()).put(field, value);
    }

    // HGET key field
    public Object hget(String key, String field) {
        Map<String, Object> map = hashStore.get(key);
        if (map == null) return null;
        return map.get(field);
    }

    // HGETALL key
    public Map<String, Object> hgetAll(String key) {
        return hashStore.get(key);
    }

    // HDEL key
    public void hdel(String key) {
        hashStore.remove(key);
    }

    // For Testing
    public static void main(String[] args) {
        MyRedis redis = new MyRedis();

        // ----------------------------
        // STRING EXAMPLE
        // ----------------------------
        redis.set("name", "Suraj");
        System.out.println("name = " + redis.get("name")); // Suraj

        // ----------------------------
        // HASH EXAMPLE
        // ----------------------------
        redis.hset("user:1001", "name", "Suraj");
        redis.hset("user:1001", "role", "SDE2");
        redis.hset("user:1001", "location", "Bangalore");

        System.out.println("HGET: " + redis.hget("user:1001", "role"));   // SDE2
        System.out.println("HGETALL: " + redis.hgetAll("user:1001"));     // all fields
    }
}
