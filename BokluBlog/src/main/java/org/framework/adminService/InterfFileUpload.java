package org.framework.adminService;

import org.springframework.web.multipart.MultipartFile;

public interface InterfFileUpload {
   StringBuilder fileUpload(MultipartFile[] file,String imageFolder);
   boolean createDirectory(String newDirectory);
}
