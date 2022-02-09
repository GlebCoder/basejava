package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void saveResume(Object searchkey, Resume resume) {
        if (size < STORAGE_LIMIT) {
            insertElement((Integer) searchkey, resume);
            size++;
        } else {
            throw new StorageException("The operation can not be done because of the storage overflow", resume.getUuid());
        }
    }

    public void updateResume(Resume resume, Object searchkey) {
        storage[(Integer) searchkey] = resume;
    }

    public Resume getBySearchKey(Object searchkey) {
        return storage[(Integer) searchkey];
    }

    public void deleteResume(Object searchkey) {
        removeElement((Integer) searchkey);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected boolean isExist(Object searchkey) {
        return (Integer) searchkey >= 0;
    }

    @Override
    public List<Resume> getAll() {
        return Arrays.asList(Arrays.copyOf(storage, size));
    }

    public int size() {
        return size;
    }

    abstract protected void insertElement(Integer index, Resume resume);

    abstract protected void removeElement(Integer index);
}
