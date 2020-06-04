package com.LINK.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.LINK.Entity.User;
import com.LINK.ServiceGateway.ImageReponse;
import com.LINK.ServiceGateway.UserReponse;

public interface IService {

	boolean saveImage(MultipartFile image) throws IOException;
	List<User> getAllUser();
	UserReponse getUser(String  userId);
	ImageReponse getImage(Long id);
	List<ImageReponse>getImages(String userName);
	List<ImageReponse> getAllImages();
}