package co.istad.thymaleaf.thywepapp.service;

import co.istad.thymaleaf.thywepapp.model.FileUpload;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    FileUpload uploadSingle(MultipartFile file);
}
