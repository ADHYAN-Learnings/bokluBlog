package org.framework.adminService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService extends HttpServlet implements InterfFileUpload  {
	
	private static final long serialVersionUID = 1L;

	private final static String UPLOAD_DIRECTORY = "/resources/images/";

	HttpServletRequest request;
	
	public FileUploadService(HttpServletRequest request) {
		super();
		this.request = request;
	}
	private static final Logger logger = LoggerFactory.getLogger(FileUploadService.class);


	public StringBuilder fileUpload(MultipartFile[] files,String imageFolder) {
		logger.debug(":::FileUploadService:::::fileUpload::");
		StringBuilder fileNames = new StringBuilder();
		try {
			ServletContext servletContext = request.getServletContext();
			String directoryPath = servletContext.getRealPath(UPLOAD_DIRECTORY+imageFolder+"/");
		
			for(MultipartFile file: files) {
			 Path fileNameAndPath = Paths.get(directoryPath,file.getOriginalFilename());
			 fileNames.append(file.getOriginalFilename()+" ");
			 Files.write(fileNameAndPath, file.getBytes());
			}
		} catch(IOException e) {
		 e.printStackTrace();	
		}
		return fileNames;
	}


	@Override
	public boolean createDirectory(String newDirectory) {
		  boolean createDirectory = false;
		try {
			ServletContext servletContext = request.getServletContext();
			String directoryPath = servletContext.getRealPath(UPLOAD_DIRECTORY)+newDirectory+"/";
			createDirectory = new File(directoryPath).mkdir();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return createDirectory;
	}	
	


}
