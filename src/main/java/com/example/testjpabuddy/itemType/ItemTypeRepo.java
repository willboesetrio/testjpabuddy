package com.example.testjpabuddy.itemType;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemTypeRepo extends JpaRepository<ItemType, String> {

    public ItemType getItemTypeById(String id);
}
