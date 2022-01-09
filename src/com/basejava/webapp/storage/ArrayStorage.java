package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public void insert(Resume resume) {
        storage[size] = resume;
        size++;
    }

    @Override
    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void removeElement(String uuid) {
        int index = getIndex(uuid);
        storage[index] = storage[size - 1];
        storage[size - 1] = null;
        size--;
    }
}
