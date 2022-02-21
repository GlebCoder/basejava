package com.basejava.webapp.storage;

import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private final File directory;

    protected AbstractFileStorage(File directory) {
        this.directory = directory;
    }

    @Override
    protected Resume getBySearchKey(File searchKey) {
        try {
            return readResume(searchKey);
        } catch (IOException e) {
            throw new StorageException("Could not read the file", searchKey.getName(), e);
        }
    }

    @Override
    protected File getSearchKey(String pathname) {
        return new File(directory, pathname);
    }

    @Override
    protected boolean isExist(File searchKey) {
        return searchKey.exists();
    }

    @Override
    public void clear() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("The directory is already empty", directory.getName());
        }
        for (File file : files) {
            deleteResume(file);
        }
    }

    @Override
    protected void saveResume(File searchKey, Resume resume) {
        try {
            searchKey.createNewFile();
        } catch (IOException e) {
            throw new StorageException("The file at the address: " + searchKey.getAbsolutePath()
                    + " has not been created", searchKey.getName(), e);
        }
        updateResume(resume, searchKey);
    }

    @Override
    protected void updateResume(Resume resume, File searchKey) {
        try {
            writeResume(resume, searchKey);
        } catch (IOException e) {
            throw new StorageException("The resume has not been written in the file", searchKey.getName(), e);
        }
    }

    @Override
    public int size() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("The directory is empty", directory.getName());
        }
        return files.length;
    }

    @Override
    protected void deleteResume(File searchKey) {
        if (!searchKey.delete()) {
            throw new StorageException("The file has not been deleted", searchKey.getName());
        }
    }

    @Override
    protected List<Resume> getAll() {
        List<Resume> allResumes = new ArrayList<>();
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("Resume directory is empty", directory.getName());
        }
        for (File file : files) {
            allResumes.add(getBySearchKey(file));
        }
        return allResumes;
    }

    protected abstract Resume readResume(File file) throws IOException;

    protected abstract File writeResume(Resume resume, File file) throws IOException;
}
