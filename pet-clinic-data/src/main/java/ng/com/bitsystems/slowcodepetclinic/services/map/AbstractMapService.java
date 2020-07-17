package ng.com.bitsystems.slowcodepetclinic.services.map;

import ng.com.bitsystems.slowcodepetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<Long, T>();

    Set<T> findAll(){

        return new HashSet<>(map.values());
    }

    T findById(ID id){
        return map.get(id);
    }

    T add (T object){

        if(object != null){
            if(object.getId() ==null){
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }
        else{
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    void delete(T object){
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    void deleteById(Long id){
        map.entrySet().removeIf(entry -> entry.getKey().equals(id));
    }

    private Long getNextId(){
        Long nextId =null;
        try {
            nextId = Collections.max(map.keySet()) +1;
        }
        catch (NoSuchElementException e){
            nextId = 1L;
        }
        return nextId;
    }
}
