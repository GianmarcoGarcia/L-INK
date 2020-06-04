package com.LINK.Converter;



import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.LINK.Entity.Image;
import com.LINK.ServiceGateway.ImageReponse;


@Component
public class ImageToImageReponse implements Converter<Image, ImageReponse>{

	@Override
	public ImageReponse convert(Image source) {
		ImageReponse imageReponse=new ImageReponse();
		imageReponse.setDescription(source.getDescription());
		imageReponse.setUserName(source.getUserName());
		imageReponse.setId(source.getId());
		imageReponse.setUrl(source.getUrl());
		return imageReponse;
	}

}
