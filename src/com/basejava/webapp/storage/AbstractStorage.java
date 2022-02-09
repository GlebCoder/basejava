package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

import java.util.Collections;
import java.util.List;

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

   public List<Resume> getAllSorted() {
        List<Resume> allResumes = getAll();
       Collections.sort(allResumes);
       return allResumes;
   }

    protected abstract List<Resume> getAll();

    protected abstract Object getSearchKey(String uuid);

    protected abstract Resume getBySearchKey(Object searchKey);

    protected abstract void saveResume(Object searchKey, Resume resume);

    protected abstract void deleteResume(Object searchKey);

    protected abstract void updateResume(Resume resume, Object searchKey);

    protected abstract boolean isExist(Object searchKey);
}