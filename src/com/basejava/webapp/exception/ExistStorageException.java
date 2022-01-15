package com.basejava.webapp.exception;

public class ExistStorageException extends StorageException {

    public ExistStorageException(String uuid) {
        super("The resume with uuid: " + uuid + " already exists in the storage", uuid);
    }
}
