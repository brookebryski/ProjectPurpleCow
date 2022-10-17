package com.example.ProjectPurpleCow.repositories;

import com.example.ProjectPurpleCow.entities.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends
        CrudRepository<Item, Integer> {
}
