package com.basejava.webapp.storage;

import com.basejava.webapp.exception.ExistStorageException;
import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.model.Resume;
import com.basejava.webapp.model.ResumeTestData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {
    protected Storage storage;
    private final String UUID_1 = "uuid1";
    private final Resume RESUME1 = ResumeTestData.makeResume(UUID_1, "Name1");
    private final String UUID_2 = "uuid2";
    private final Resume RESUME2 = ResumeTestData.makeResume(UUID_2, "Name2");
    private final String UUID_3 = "uuid3";
    private final Resume RESUME3 = ResumeTestData.makeResume(UUID_3, "Name3");
    private final String UUID_4 = "uuid4";
    private final Resume RESUME4 = ResumeTestData.makeResume(UUID_4, "Name4");

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME1);
        storage.save(RESUME2);
        storage.save(RESUME3);
    }


    @Test
    public void clear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void save() throws Exception {
        storage.save(RESUME4);
        assertEquals(4, storage.size());
        assertEquals(RESUME4, storage.get(UUID_4));
    }

    @Test(expected = ExistStorageException.class)
    public void saveExistingResume() throws Exception {
        storage.save(RESUME1);
    }

    @Test
    public void update() throws Exception {
        Resume resume = new Resume(UUID_1, "Name1");
        storage.update(resume);
        assertEquals(resume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExistingResume() {
        storage.update(RESUME4);
    }

    @Test
    public void get() throws Exception {
        assertEquals(RESUME1, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(UUID_1);
        assertEquals(2, storage.size());
        storage.get(UUID_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExistingResume() throws Exception {
        storage.delete(UUID_4);
    }

    @Test
    public void getAllSorted() throws Exception {
        List<Resume> expectedResumes = new ArrayList<>(List.of(RESUME1, RESUME2, RESUME3));
        List<Resume> actualResumes = storage.getAllSorted();
        Collections.sort(expectedResumes);
        Assert.assertEquals(expectedResumes, actualResumes);
    }

    @Test
    public void size() throws Exception {
        assertEquals(3, storage.size());
    }
}