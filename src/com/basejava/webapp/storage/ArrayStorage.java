package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {

    @Override
    public void insertElement (Integer index, Resume resume) {
        storage[size] = resume;
    }

    @Override
    protected Integer getSearchkey(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void removeElement(Integer index) {
        storage[index] = storage[size - 1];
    }
}
