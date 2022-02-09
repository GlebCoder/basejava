package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = (resume1, resume2) -> resume1.getUuid().compareTo(resume2.getUuid());

    @Override
    public void insertElement(Integer index, Resume resume) {
        int insertPoint = -(index + 1);
        System.arraycopy(storage, insertPoint, storage, insertPoint + 1, size - insertPoint);
        storage[insertPoint] = resume;
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        Resume searchKey = new Resume(uuid, "Name");
        return Arrays.binarySearch(storage, 0, size, searchKey, RESUME_COMPARATOR);
    }

    @Override
    public void removeElement(Integer index) {
        System.arraycopy(storage, index + 1, storage, index, size - index);
    }
}
