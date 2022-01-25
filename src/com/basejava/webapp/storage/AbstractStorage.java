package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage{

    public void save(Resume resume) {
        Object searchkey = getIfNotExist(resume.getUuid());
        saveResume(searchkey, resume);
    }

    public void update(Resume resume) {
        Object searchkey = getIfExist(resume.getUuid());
        updateResume(resume, searchkey);
    }

    public Resume get(String uuid) {
        Object searchkey = getIfExist(uuid);
        return getBySearchkey(searchkey);
    }

    public void delete(String uuid) {
        Object searchkey = getIfExist(uuid);
        deleteResume(searchkey);
    }

    private Object getIfExist(String uuid) {
        Object searchkey = getSearchkey(uuid);
        if(!isExist(searchkey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchkey;
    }

    private Object getIfNotExist(String uuid) {
        Object searchkey = getSearchkey(uuid);
        if(isExist(searchkey)) {
            throw new ExistStorageException(uuid);
        }
        return searchkey;
    }

    protected abstract Object getSearchkey(String uuid);

    protected abstract Resume getBySearchkey(Object searchkey);

    protected abstract void saveResume(Object searchkey, Resume resume);

    protected abstract void deleteResume(Object searchkey);

    protected abstract void updateResume(Resume resume, Object searchkey);

    protected abstract boolean isExist(Object searchkey);
}