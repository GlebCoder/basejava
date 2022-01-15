package com.basejava.webapp;

import com.basejava.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume resume = new Resume();
        System.out.println(resume);
        Field[] fields = resume.getClass().getDeclaredFields();
        System.out.println(Arrays.toString(fields));
        Field field = fields[0];
        System.out.println(field.getName());
        field.setAccessible(true);
        System.out.println(field.get(resume));
        field.set(resume, "new_uuid");
        System.out.println(field.get(resume));

        Method method = resume.getClass().getMethod("toString");
        System.out.println(method.invoke(resume));
    }
}
