package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage{
    List<Resume> storage = new ArrayList<>();

    @Override
    protected Integer getKeyOrIndex(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected Resume getByKeyOrIndex(Object keyOrIndex) {
        return storage.get((Integer) keyOrIndex);
    }

    @Override
    protected void saveIfNotExisting(Object keyOrIndex, Resume resume) {
        storage.add(resume);
    }

    @Override
    protected void deleteIfExisting(Object keyOrIndex) {
        storage.remove(((Integer) keyOrIndex).intValue());
    }

    @Override
    protected void updateIfExisting(Resume resume, Object keyOrIndex) {
        storage.set((Integer) keyOrIndex, resume);
    }

    @Override
    protected boolean isExisting(Object keyOrIndex) {
        if((Integer) keyOrIndex >= 0) {
            return true;
        } else {
            return false;
        }
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
