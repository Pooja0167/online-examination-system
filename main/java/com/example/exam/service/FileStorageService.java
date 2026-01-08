package com.example.exam.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

@Service
public class FileStorageService {

    private final Path root = Paths.get("uploads");

    public void init() {
        try {
            if (!Files.exists(root)) {
                Files.createDirectory(root);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize upload folder");
        }
    }

    public String save(MultipartFile file) {
        try {
            Files.copy(
                    file.getInputStream(),
                    root.resolve(file.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING
            );
            return file.getOriginalFilename();
        } catch (Exception e) {
            throw new RuntimeException("File upload failed");
        }
    }
}
