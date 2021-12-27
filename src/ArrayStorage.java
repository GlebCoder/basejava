import java.util.Arrays;
import java.util.Comparator;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, 0, size(), null);
    }

    void save(Resume r) {
        storage[size()] = r;
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
        for (int i = 0; i < storage.length; i++) {
            if (storage[i].uuid.equals(uuid)) {
                storage[i] = null;
                break;
            }
        }

        Arrays.sort(storage, new Comparator<Resume>() {
            @Override
            public int compare(Resume resume, Resume t1) {
                if (resume == null && t1 == null) {
                    return 0;
                }
                if(resume == null) {
                    return 1;
                }
                if(t1 == null) {
                    return -1;
                }
                return resume.uuid.compareTo(t1.uuid);
            }
        });
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size());
    }

// Determines amount of Resumes in storage
    int size() {
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] == null) {
                return i;
            }
        }
        return storage.length;
    }

}
