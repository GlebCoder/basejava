package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private Map<Object, Resume> storage = new HashMap<>();

    @Override
    protected String getSearchkey(String uuid) {
        return uuid;
    }

    @Override
    protected Resume getBySearchkey(Object searchkey) {
        return storage.get(searchkey);
    }

    @Override
    protected void saveResume(Object searchkey, Resume resume) {
        storage.put(searchkey, resume);
    }

    @Override
    protected void deleteResume(Object searchkey) {
        storage.remove(searchkey);
    }

    @Override
    protected void updateResume(Resume resume, Object searchkey) {
        storage.put(searchkey, resume);
    }

    @Override
    protected boolean isExist(Object searchkey) {
        return storage.containsKey(searchkey);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[storage.size()]);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
