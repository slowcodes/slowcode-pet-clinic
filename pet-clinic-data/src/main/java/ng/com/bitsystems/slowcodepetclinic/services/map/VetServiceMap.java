package ng.com.bitsystems.slowcodepetclinic.services.map;

import ng.com.bitsystems.slowcodepetclinic.model.Vet;
import ng.com.bitsystems.slowcodepetclinic.services.VetService;

import java.util.Set;

public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet findByID(Long id) {
        return super.findById(id);
    }

    @Override
    public Vet add(Vet object) {
        return super.add(object.getId(),object);
    }
}
