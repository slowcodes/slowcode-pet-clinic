package ng.com.bitsystems.slowcodepetclinic.services;

import ng.com.bitsystems.slowcodepetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String name);
}
