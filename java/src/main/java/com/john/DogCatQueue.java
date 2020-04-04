package com.john;

import com.entity.Cat;
import com.entity.Dog;
import com.entity.Pet;
import com.entity.PetEnterQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: John
 * @date: 2019-12-16 19:02
 * @description:
 **/
public class DogCatQueue {
    private Queue<PetEnterQueue> dogQ;
    private Queue<PetEnterQueue> catQ;
    private long count;

    public DogCatQueue(Queue<PetEnterQueue> dogQ, Queue<PetEnterQueue> catQ) {
        this.dogQ = dogQ;
        this.catQ = catQ;
    }

    public DogCatQueue() {
        this.dogQ = new LinkedList<>();
        this.catQ = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getType().equals("dog")) {
            this.dogQ.add(new PetEnterQueue(pet, this.count++));
        } else if (pet.getType().equals("cat")) {
            this.catQ.add(new PetEnterQueue(pet, this.count++));
        } else {
            System.out.println("error type");
        }
    }

    public Pet pollAll() {
       if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
           if (this.dogQ.peek().getCount() > this.catQ.peek().getCount()) {
               return this.dogQ.poll().getPet();
           } else {
               return this.catQ.poll().getPet();
           }
       } else if (!this.dogQ.isEmpty()) {
           return this.dogQ.poll().getPet();
       } else if (!this.catQ.isEmpty()) {
           return this.catQ.poll().getPet();
       } else {
           return null;
       }
    }

    public Dog pollDog() {
        if (!isDogQueueEmpty()) {
            return (Dog) this.dogQ.poll().getPet();
        }
        return null;
    }

    public Cat pollCat() {
        if(!isCatQueueEmpty()) {
            return (Cat) this.catQ.poll().getPet();
        }
        return null;
    }

    public boolean isDogQueueEmpty() {
        return this.dogQ.isEmpty();
    }

    public boolean isCatQueueEmpty() {
        return this.catQ.isEmpty();
    }
}
