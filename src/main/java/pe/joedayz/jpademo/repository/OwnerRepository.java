package pe.joedayz.jpademo.repository;

import pe.joedayz.jpademo.domain.Owner;

import org.springframework.data.repository.CrudRepository;

public interface OwnerRepository extends CrudRepository<Owner, Long> {
}
