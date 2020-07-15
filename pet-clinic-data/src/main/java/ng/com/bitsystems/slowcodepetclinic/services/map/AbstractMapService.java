package ng.com.bitsystems.slowcodepetclinic.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractMapService<T, ID> {

    protected Map<ID, T> map = new HashMap<ID, T>();

    Set<T> findAll(){

        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T add (ID id, T object){
        map.put(id, object);
        return object;
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    void deleteById(Long id){
        map.entrySet().removeIf(entry -> entry.getKey().equals(id));
    }
}
