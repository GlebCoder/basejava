package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    public void insert(Resume resume) {
        int insertPoint = - (getIndex(resume.getUuid()) + 1);
        for (int i = size; i > insertPoint; i--) {
            storage[i] = storage[i - 1];
        }
        storage[insertPoint] = resume;
        size++;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    public void removeElement(String uuid) {
        int index = getIndex(uuid);
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
        storage[size - 1] = null;
        size--;
    }
}
