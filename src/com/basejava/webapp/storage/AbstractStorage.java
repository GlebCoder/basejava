package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage{

    public void save(Resume resume) {
        Object keyOrIndex = getIfNotExisting(resume.getUuid());
        saveIfNotExisting(keyOrIndex, resume);
    }

    public void update(Resume resume) {
        Object keyOrIndex = getIfExisting(resume.getUuid());
        updateIfExisting(resume, keyOrIndex);
    }

    public Resume get(String uuid) {
        Object keyOrIndex = getIfExisting(uuid);
        return getByKeyOrIndex(keyOrIndex);
    }

    public void delete(String uuid) {
        Object keyOrIndex = getIfExisting(uuid);
        deleteIfExisting(keyOrIndex);
    }

    private Object getIfExisting(String uuid) {
        Object keyOrIndex = getKeyOrIndex(uuid);
        if(!isExisting(keyOrIndex)) {
            throw new NotExistStorageException(uuid);
        } else {
            return keyOrIndex;
        }
    }

    private Object getIfNotExisting(String uuid) {
        Object keyOrIndex = getKeyOrIndex(uuid);
        if(isExisting(keyOrIndex)) {
            throw new ExistStorageException(uuid);
        } else {
            return keyOrIndex;
        }
    }

    protected abstract Object getKeyOrIndex(String uuid);

    protected abstract Resume getByKeyOrIndex(Object keyOrIndex);

    protected abstract void saveIfNotExisting(Object keyOrIndex, Resume resume);

    protected abstract void deleteIfExisting(Object keyOrIndex);

    protected abstract void updateIfExisting(Resume resume, Object keyOrIndex);

    protected abstract boolean isExisting(Object keyOrIndex);
}