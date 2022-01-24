package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void saveIfNotExisting(Object keyOrIndex, Resume resume) {
        if (size < STORAGE_LIMIT) {
            insertElement((Integer) keyOrIndex, resume);
            size++;
        } else {
            throw new StorageException("The operation can not be done because of the storage overflow", resume.getUuid());
        }
    }

    public void updateIfExisting(Resume resume, Object keyOrIndex) {
        storage[(Integer) keyOrIndex] = resume;
    }

    public Resume getByKeyOrIndex(Object keyOrIndex) {
        return storage[(Integer) keyOrIndex];
    }

    public void deleteIfExisting(Object keyOrIndex) {
        removeElement((Integer) keyOrIndex);
        storage[size - 1] = null;
        size--;
    }

    protected boolean isExisting(Object keyOrIndex) {
        return (Integer) keyOrIndex >= 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    abstract protected void insertElement(Integer index, Resume resume);

    abstract protected void removeElement(Integer index);
}
