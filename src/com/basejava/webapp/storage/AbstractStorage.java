package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

public abstract class AbstractStorage implements Storage{

    public void save(Resume resume) {
        Object searchKey = getIfNotExist(resume.getUuid());
        saveResume(searchKey, resume);
    }

    public void update(Resume resume) {
        Object searchKey = getIfExist(resume.getUuid());
        updateResume(resume, searchKey);
    }

    public Resume get(String uuid) {
        Object searchKey = getIfExist(uuid);
        return getBySearchKey(searchKey);
    }

    public void delete(String uuid) {
        Object searchKey = getIfExist(uuid);
        deleteResume(searchKey);
    }

    private Object getIfExist(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if(!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getIfNotExist(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if(isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    protected abstract Object getSearchKey(String uuid);

    protected abstract Resume getBySearchKey(Object searchkey);

    protected abstract void saveResume(Object searchkey, Resume resume);

    protected abstract void deleteResume(Object searchkey);

    protected abstract void updateResume(Resume resume, Object searchkey);

    protected abstract boolean isExist(Object searchkey);
}