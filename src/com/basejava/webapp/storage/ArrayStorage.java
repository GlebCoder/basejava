package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index != -1) {
            System.out.println("The resume already exists in the storage");
        } else if (size < storage.length){
            storage[size] = r;
            size++;
        } else {
            System.out.println("The operation can not be done because of the storage overflow");
        }
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index != -1) {
            storage[index] = r;
        } else {
            System.out.println("The resume does not exist in the storage");
        }

    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("There is no resume with uuid: " + uuid);
            return null;
        } else {
            return storage[index];
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index == -1) {
            System.out.println("The resume with uuid: " + uuid + " has not been found.");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    // Determines amount of Resumes in storage
    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isPresent(Resume r) {
        int index = getIndex(r.getUuid());
        if (index == -1) {
            return false;
        }
        return true;
    }
}
