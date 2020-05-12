package com.test.navent.service;

public interface IBumexMemcached {

    void set(String key, Object value);
    Object get(String key);
    void delete(String key);

}
