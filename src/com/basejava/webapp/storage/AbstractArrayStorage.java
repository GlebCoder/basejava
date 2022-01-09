package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage{

    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            System.out.println("The resume with uuid: " + resume.getUuid() + " already exists in the storage");
        } else if (size < storage.length) {
            insert(resume);
        } else {
            System.out.println("The operation can not be done because of the storage overflow");
        }
    };

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index != -1) {
            storage[index] = resume;
        } else {
            System.out.println("The resume with uuid: " + resume.getUuid() + " does not exist in the storage");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            return storage[index];
        }
        System.out.println("There is no resume with uuid: " + uuid);
        return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index >= 0) {
            removeElement(uuid);
        } else {
            System.out.println("The resume with uuid: " + uuid + " has not been found.");
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    abstract protected int getIndex(String uuid);

    abstract protected void insert(Resume resume);

    abstract protected void removeElement(String uuid);
}
