package com.test.navent.service;

public class BumexMemcached implements IBumexMemcached {

    private static BumexMemcached instance;

    private BumexMemcached() {}

    public static BumexMemcached getInstance() {
        if (instance == null) {
            instance = new BumexMemcached();
        }
        return instance;
    }

    @Override
    public void set(String key, Object value) {
        // implementar
    }

    @Override
    public Object get(String key) {
        // implementar
        return null;
    }

    @Override
    public void delete(String key) {
        // implementar
    }
}
