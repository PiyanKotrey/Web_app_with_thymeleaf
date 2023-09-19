package co.istad.thymaleaf.thywepapp.service.imp;

import co.istad.thymaleaf.thywepapp.model.FileUpload;
import co.istad.thymaleaf.thywepapp.service.FileUploadService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    @Value("${file.server-path}")
    private String fileServerPath;


    @Override
    public FileUpload uploadSingle(MultipartFile file) {
        int dotLastIndex = file.getOriginalFilename().lastIndexOf(".");
        String ext=file.getOriginalFilename().substring(dotLastIndex + 1);
        String uuid = UUID.randomUUID().toString();
        String newFileNew = String.format("%s%s%s", uuid, ".", ext);

        Path paths = Paths.get(fileServerPath+newFileNew);
        try {
            Files.copy(file.getInputStream(),paths);
        }catch (IOException e){
            throw new RuntimeException(e);
        }
        return new FileUpload(newFileNew,true);
    }
}
