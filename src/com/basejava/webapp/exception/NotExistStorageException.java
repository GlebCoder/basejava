package com.basejava.webapp.exception;

public class NotExistStorageException extends StorageException {

    public NotExistStorageException(String uuid) {
        super("The resume with uuid: " + uuid + " has not been found", uuid);
    }
}
