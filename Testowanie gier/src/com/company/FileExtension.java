package com.company;

import org.junit.jupiter.api.extension.*;
import org.junit.jupiter.api.extension.Extension;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.Annotation;
import java.util.Scanner;

public class FileExtension implements ParameterResolver {

    @Retention(RetentionPolicy.RUNTIME)
    public @interface File {
        String path();
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext,
                                     ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == String.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext,
                                   ExtensionContext extensionContext) throws ParameterResolutionException {
        File file = parameterContext.getParameter().getAnnotation(File.class);
        String filepath = file.path();
        java.io.File realfile = new java.io.File(filepath);
        Scanner scanner = null;
        try {
            scanner = new Scanner(realfile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder result = new StringBuilder();

        while (scanner.hasNext()){
            result.append(scanner.nextLine());
        }
        scanner.close();

        return result.toString();
    }
}
