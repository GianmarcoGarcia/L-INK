package com.LINK.Converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.LINK.Entity.User;
import com.LINK.ServiceGateway.UserReponse;

@Component
public class UserToUserReponse implements Converter<User, UserReponse>{

	@Override
	public UserReponse convert(User source) {
		// TODO Auto-generated method stub
		UserReponse userReponse=new UserReponse();
		userReponse.setInfo(source.getInfo());
		userReponse.setUserName(source.getUserName());
		return userReponse;
	}

}
