package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage{
    private List<Resume> storage = new ArrayList<>();

    @Override
    protected Integer getSearchkey(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected Resume getBySearchkey(Object searchkey) {
        return storage.get((Integer) searchkey);
    }

    @Override
    protected void saveResume(Object searchkey, Resume resume) {
        storage.add(resume);
    }

    @Override
    protected void deleteResume(Object searchkey) {
        storage.remove(((Integer) searchkey).intValue());
    }

    @Override
    protected void updateResume(Resume resume, Object searchkey) {
        storage.set((Integer) searchkey, resume);
    }

    @Override
    protected boolean isExist(Object searchkey) {
        return (Integer) searchkey >= 0;
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[storage.size()]);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
