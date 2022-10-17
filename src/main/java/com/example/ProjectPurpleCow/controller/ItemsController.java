package com.example.ProjectPurpleCow.controller;

import com.example.ProjectPurpleCow.entities.Item;
import com.example.ProjectPurpleCow.repositories.ItemRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ItemsController {
    private final ItemRepository itemRepository;

    public ItemsController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/items")
    public Iterable<Item> getAllItems() {
        return this.itemRepository.findAll();
    }

    @GetMapping("/items/{id}")
    public Optional<Item> getItemById(@PathVariable("id") Integer id) {
        return this.itemRepository.findById(id);
    }

    @PostMapping("/items")
    public Item createNewPlant(@RequestBody Item item) {
        return this.itemRepository.save(item);
    }

    @PutMapping("/items/{id}")
    public Item updateItem(
            @PathVariable("id") Integer id,
            @RequestBody Item i
    ) {
        Optional<Item> itemToUpdateOptional = this.itemRepository.findById(id);
        if (!itemToUpdateOptional.isPresent()) {
            return null;
        }
        Item itemToUpdate = itemToUpdateOptional.get();
        if (i.getName() != null) {
            itemToUpdate.setName(i.getName());
        }

        Item updatedItem = this.itemRepository.save(itemToUpdate);
        return updatedItem;
    }

    @DeleteMapping("/items/{id}")
    public Item deleteItem(@PathVariable("id") Integer id) {
        Optional<Item> itemToDeleteOptional = this.itemRepository.findById(id);
        if (!itemToDeleteOptional.isPresent()) {
            return null;
        }
        Item itemToDelete = itemToDeleteOptional.get();
        this.itemRepository.delete(itemToDelete);
        return itemToDelete;
    }


}
