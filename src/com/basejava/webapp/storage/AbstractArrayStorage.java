package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {

    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void saveResume(Integer searchKey, Resume resume) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("The operation can not be done because of the storage overflow", resume.getUuid());
        }
        insertElement(searchKey, resume);
        size++;
    }

    public void updateResume(Resume resume, Integer searchKey) {
        storage[searchKey] = resume;
    }

    public Resume getBySearchKey(Integer searchKey) {
        return storage[searchKey];
    }

    public void deleteResume(Integer searchKey) {
        removeElement(searchKey);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey >= 0;
    }

    @Override
    public List<Resume> getAll() {
        return Arrays.asList(Arrays.copyOf(storage, size));
    }

    public int size() {
        return size;
    }

    abstract protected void insertElement(int index, Resume resume);

    abstract protected void removeElement(int index);
}
