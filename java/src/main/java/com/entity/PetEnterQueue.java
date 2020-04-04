package com.entity;

import com.entity.Pet;

import java.util.Queue;

/**
 * @author: John
 * @date: 2019-12-16 18:52
 * @description:
 **/
public class PetEnterQueue {
    private Pet pet;
    private long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public String getEnterPetType() {
        return this.pet.getType();
    }
}
