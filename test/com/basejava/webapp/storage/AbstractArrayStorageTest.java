package com.basejava.webapp.storage;

import com.basejava.webapp.exception.NotExistStorageException;
import com.basejava.webapp.exception.StorageException;
import com.basejava.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {
    private Storage storage;
    private final String UUID_1 = "uuid1";
    private final Resume RESUME1 =  new Resume(UUID_1);
    private final String UUID_2 = "uuid2";
    private final Resume RESUME2 = new Resume(UUID_2);
    private final String UUID_3 = "uuid3";
    private final Resume RESUME3 = new Resume(UUID_3);

    public AbstractArrayStorageTest(Storage storage) {
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
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void save() throws Exception {
        Resume resume = new Resume("uuid4");
        storage.save(resume);
        Assert.assertEquals(4, storage.size());
        Assert.assertEquals(resume, storage.get(resume.getUuid()));
    }

    @Test
    public void update() throws Exception {
        Resume resume = new Resume("uuid1");
        storage.update(resume);
        Assert.assertTrue(resume == storage.get("uuid1"));
    }

    @Test
    public void get() throws Exception {
        Assert.assertTrue(RESUME1 == storage.get(RESUME1.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        storage.delete(RESUME1.getUuid());
        Assert.assertEquals(2, storage.size());
        storage.get(RESUME1.getUuid());
    }

    @Test
    public void getAll() throws Exception {
        Resume[] allResumes = new Resume[3];
        allResumes[0] = RESUME1;
        allResumes[1] = RESUME2;
        allResumes[2] = RESUME3;
        Assert.assertArrayEquals(allResumes, storage.getAll());
    }

    @Test
    public void size() throws Exception {
        Assert.assertEquals(3, storage.size());
    }

    @Test(expected = StorageException.class)
    public void checkOverflow() {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT; i++) {
                Resume resume = new Resume();
                storage.save(resume);
            }
        } catch (StorageException e) {
            Assert.fail("The array overflow has happened prematurely!");
        }
        Resume resume = new Resume();
        storage.save(resume);
    }
}