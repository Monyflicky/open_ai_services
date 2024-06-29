package com.example.service.adoption;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DogRepository extends ListCrudRepository<Dog, Integer> {
}
