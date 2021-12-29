import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int size;

    void clear() {
        Arrays.fill(storage, 0, size(), null);
    }

    void save(Resume r) {
        storage[size()] = r;
        size++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        Resume[] tempArray = new Resume[storage.length - 1];
        int index = getIndexByUuid(uuid);
        System.arraycopy(storage, 0, tempArray, 0, index);
        System.arraycopy(storage, index + 1, tempArray, index, storage.length - index - 1);
        storage = tempArray;
        size--;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size());
    }

// Determines amount of Resumes in storage
    int size() {
        return size;
    }

    int getIndexByUuid(String uuid) {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

}
