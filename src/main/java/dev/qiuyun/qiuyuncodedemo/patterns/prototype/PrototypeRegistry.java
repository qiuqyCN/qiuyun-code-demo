package dev.qiuyun.qiuyuncodedemo.patterns.prototype;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 原型注册表
 * 管理和提供预先生成的原型对象
 */
class PrototypeRegistry {
    private Map<String, Prototype> prototypes = new HashMap<>();

    public void register(String key, Prototype prototype) {
        prototypes.put(key, prototype);
        System.out.println("原型 " + key + " 已注册");
    }

    public Prototype get(String key) {
        Prototype prototype = prototypes.get(key);
        if (prototype == null) {
            System.out.println("原型 " + key + " 不存在");
            return null;
        }
        return prototype.clone();
    }

    public Prototype getRaw(String key) {
        return prototypes.get(key);
    }

    public Set<String> listPrototypes() {
        return prototypes.keySet();
    }

    public void remove(String key) {
        prototypes.remove(key);
    }
}
