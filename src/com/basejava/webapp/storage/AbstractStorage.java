package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<T> implements Storage {
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    public void save(Resume resume) {
        LOG.info("Save " + resume);
        T searchKey = getIfNotExist(resume.getUuid());
        saveResume(searchKey, resume);
    }

    public void update(Resume resume) {
        LOG.info("Update " + resume);
        T searchKey = getIfExist(resume.getUuid());
        updateResume(resume, searchKey);
    }

    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        T searchKey = getIfExist(uuid);
        return getBySearchKey(searchKey);
    }

    public void delete(String uuid) {
        LOG.info("Delete " + uuid);
        T searchKey = getIfExist(uuid);
        deleteResume(searchKey);
    }

    private T getIfExist(String uuid) {
        T searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            LOG.warning("Resume with " + uuid + " does not exist");
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private T getIfNotExist(String uuid) {
        T searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            LOG.warning("Resume with " + uuid + " already exists");
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    public List<Resume> getAllSorted() {
        LOG.info("GetAllSorted");
        List<Resume> allResumes = getAll();
        Collections.sort(allResumes);
        return allResumes;
    }

    protected abstract List<Resume> getAll();

    protected abstract T getSearchKey(String uuid);

    protected abstract Resume getBySearchKey(T searchKey);

    protected abstract void saveResume(T searchKey, Resume resume);

    protected abstract void deleteResume(T searchKey);

    protected abstract void updateResume(Resume resume, T searchKey);

    protected abstract boolean isExist(T searchKey);
}