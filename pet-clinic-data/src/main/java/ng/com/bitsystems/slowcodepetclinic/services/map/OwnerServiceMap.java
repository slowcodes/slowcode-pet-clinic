package ng.com.bitsystems.slowcodepetclinic.services.map;

import ng.com.bitsystems.slowcodepetclinic.model.Owner;
import ng.com.bitsystems.slowcodepetclinic.services.CrudService;

import java.util.Set;

public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements CrudService<Owner, Long> {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public Owner findByID(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner add(Owner object) {
        super.add(object.getId(), object);
        return object;
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
