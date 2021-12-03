package com.bridgelabz;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.bridgelabz.FileUtils.deleteFiles;

public class EmployeePayrollServiceTest {
    @Test
    public void givenPathShouldCheckTheFileExist() throws IOException {
        //Check the file exist
        Path checkPath = Paths.get("C:\\Assignments");
        Assert.assertTrue(Files.exists(checkPath));

        Path createFilePath = Paths.get("C:\\Assignments\\file");
        Files.createFile(createFilePath);
        Assert.assertTrue(Files.exists(createFilePath));

        //Delete the file and check it is not EXIST
        Path deletePath = Paths.get("C:\\Assignments\\file");
        if (Files.exists(deletePath)) {
            deleteFiles(deletePath.toFile());
        }
        Assert.assertTrue(Files.notExists(deletePath));

        //create Directory
        Path path1 = Paths.get("C:\\Assignments\\Directory");
        Files.createDirectory(path1);

    }
}
