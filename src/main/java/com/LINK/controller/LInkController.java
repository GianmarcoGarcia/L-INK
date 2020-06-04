package com.LINK.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LINK.Entity.User;
import com.LINK.Service.IService;
import com.LINK.ServiceGateway.ImageReponse;
import com.LINK.ServiceGateway.UserReponse;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
//@RequestMapping("/link")
public class LInkController {
	@Autowired
	private IService iSevicioStub;
/*
	@PostMapping(value="/uploadImage",consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
	public String uploadImage(@RequestParam(value="image")MultipartFile image) throws IOException {
		iSevicioStub.saveImage(image);
		return "Imagen guardada";
	}
	  @GetMapping("/Users")
	  List<User> allUsers() {
	    return iSevicioStub.getAllUser();
	  }
	
	@GetMapping("/Users/{id}")
	EntityModel<User> oneUser(@PathVariable Long id) {

		User user = iSevicioStub.getUser(id);

		  return new EntityModel<>(user,
		    linkTo(methodOn(LInkController.class).oneUser(id)).withSelfRel(),
		    linkTo(methodOn(LInkController.class).allUsers()).withRel("Users"));
		}
  */
	  @GetMapping("/users")
	  List<User> showUsers() {
	    return iSevicioStub.getAllUser();
	  }
		
	@GetMapping("/users/{userName}")
	ResponseEntity<EntityModel<UserReponse>> oneUser(@PathVariable String userName) {
	
			UserReponse user = iSevicioStub.getUser(userName);
			EntityModel <UserReponse> userLinks=new EntityModel<>(user,
				    linkTo(methodOn(LInkController.class).oneUser(userName)).withSelfRel(),
				    linkTo(methodOn(LInkController.class).showUsers()).withRel("users"));
			
		 List<ImageReponse> a=iSevicioStub.getImages(userName);
		 Iterator<ImageReponse> i =a.iterator();
		while(i.hasNext()) {
			 userLinks.add(linkTo(methodOn(LInkController.class)
                     .oneImage( i.next().getId())).withRel("Images"));
		}
	
   
			  return ResponseEntity.ok(userLinks);
			}
	@GetMapping("/images/{id_image}")
	ResponseEntity<EntityModel<ImageReponse>>oneImage(@PathVariable Long id_image) {

		ImageReponse image = iSevicioStub.getImage(id_image);
			EntityModel <ImageReponse> imageInfo=new EntityModel<>(image,
				    linkTo(methodOn(LInkController.class).oneImage(id_image)).withSelfRel(),
				    linkTo(methodOn(LInkController.class).oneUser(image.getUserName())).withRel("user"));


			    return ResponseEntity.ok(imageInfo);
			}
	
	  @GetMapping("/images")
	  List<ImageReponse> showImages() {
	    return iSevicioStub.getAllImages();
	  }
	  
}

