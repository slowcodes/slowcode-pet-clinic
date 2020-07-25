package ng.com.bitsystems.slowcodepetclinic.services.map;

import ng.com.bitsystems.slowcodepetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {

    OwnerServiceMap ownerServiceMap;
    Long ownerId = 2l;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetServiceMap(), new PetTypeServiceMap());
        Owner owner = new Owner();
        owner.setId(ownerId);
        owner.setLastName("smith");
        ownerServiceMap.add(owner);
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1,owners.size());
    }

    @Test
    void findByID() {
        Owner owner = ownerServiceMap.findByID(ownerId);
        assertEquals(ownerId,owner.getId());
    }

    @Test
    void add() {
        Owner owner = new Owner();
        owner.setId(3l);
        owner.setFirstName("Afam");
        Owner onwer2 =ownerServiceMap.add(owner);
        assertEquals(owner, onwer2);
        assertNotNull(onwer2);
    }

    @Test
    void delete() {
        Owner owner = new Owner();
        owner.setId(3l);
        owner.setFirstName("Afam");
        ownerServiceMap.delete(owner);
        Owner owner2 = ownerServiceMap.findByID(3l);
        assertNull(owner2);
    }

    @Test
    void deleteById() {
        Owner newOwner = new Owner();
        newOwner.setId(3l);
        newOwner.setFirstName("Afam");
        ownerServiceMap.deleteById(3l);
        Owner deletedOwner = ownerServiceMap.findByID(3l);
        assertNull(deletedOwner);
    }

    @Test
    void findByLastName() {
        Owner lastNameOwner = ownerServiceMap.findByLastName("smith");
        assertNotNull(lastNameOwner);

        Owner lastNameOwnerNotFound = ownerServiceMap.findByLastName("foo");
        assertNull(lastNameOwnerNotFound);
    }
}