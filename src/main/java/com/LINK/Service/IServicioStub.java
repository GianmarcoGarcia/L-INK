package com.LINK.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.LINK.Converter.ImageToImageReponse;
import com.LINK.Converter.UserToUserReponse;
import com.LINK.Entity.Image;
import com.LINK.Entity.User;
import com.LINK.Repository.IImageRepository;
import com.LINK.Repository.IUserRepository;
import com.LINK.ServiceGateway.ImageReponse;
import com.LINK.ServiceGateway.UserReponse;

@Service
@Component
public class IServicioStub implements IService {
	@Autowired
	IUserRepository iUserRepository;
	@Autowired
	UserToUserReponse userToUserReponse;
	@Autowired
	IImageRepository iImageRepository;
	@Autowired
	ImageToImageReponse imageToImageReponse;

	@Override
	public boolean saveImage(MultipartFile image) throws IOException {
		// TODO Auto-generated method stub
		String folder ="C:/photos/";
		byte [] bytes=image.getBytes();

		File a =new File(folder+image.getOriginalFilename());
		a.createNewFile();
		FileOutputStream b=new FileOutputStream(a);
		b.write(bytes);
		return true;
	}

	@Override
	public UserReponse getUser(String userName) {
		Optional<User> optionalUser=iUserRepository.findByuserName(userName);
		UserReponse userReponse=null;
		if(optionalUser!=null) {
			userReponse=userToUserReponse.convert(optionalUser.get());
		}

		return userReponse;
	}

	@Override
	public List<User> getAllUser() {
		// TODO Auto-generated method stub
		List<User>listUsers= (List<User>) iUserRepository.findAll();
		return listUsers;
	}

	@Override
	public ImageReponse getImage(Long id) {
		Optional<Image> optionalImage=iImageRepository.findById(id);
		ImageReponse imageReponse=null;
		if(optionalImage!=null) {
			imageReponse=imageToImageReponse.convert(optionalImage.get());
		}

		return imageReponse;

	}



	@Override
	public List<ImageReponse> getImages(String userName) {

		List<ImageReponse> listImagesReponses=new ArrayList();;
		List<Image> optionalImages=new ArrayList();
		optionalImages.addAll(iImageRepository.findByuserName(userName));
		if(optionalImages!=null) {

			Iterator<Image> iterator = optionalImages.iterator();
			while(iterator.hasNext()) {
				listImagesReponses.add(imageToImageReponse.convert( iterator.next()));
			}
		}

		return listImagesReponses;
	}



	@Override
	public List<ImageReponse> getAllImages() {

		List<ImageReponse> listImagesReponses=new ArrayList();;
		List<Image> optionalImages=new ArrayList();
		Iterable<Image> it = iImageRepository.findAll();
		for(Image i : it) {
			optionalImages.add(i);
		}
		//optionalImages.addAll(iImageRepository.findAll());
		if(optionalImages!=null) {

			Iterator<Image> iterator = optionalImages.iterator();
			while(iterator.hasNext()) {
				listImagesReponses.add(imageToImageReponse.convert( iterator.next()));
			}
		}

		return listImagesReponses;
	}




}
