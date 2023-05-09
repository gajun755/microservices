package com.dedication.mongodb.service;

import java.io.IOException;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dedication.mongodb.collection.Photo;
import com.dedication.mongodb.repository.PhotoRepository;

@Service
public class PhotoService {

	@Autowired
	private PhotoRepository photoRepository;
	
	public String addPhoto(String originalFilename, MultipartFile image) throws IOException {
		
		Photo photo=new Photo();
		photo.setPhoto(new Binary(BsonBinarySubType.BINARY,image.getBytes()));
		return photoRepository.save(photo).getId();
	}

	public Photo getPhoto(String id) {
		
		return photoRepository.findById(id).get();
	}

		
}
