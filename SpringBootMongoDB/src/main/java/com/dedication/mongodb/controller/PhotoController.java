package com.dedication.mongodb.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dedication.mongodb.collection.Photo;
import com.dedication.mongodb.service.PhotoService;

@RestController
@RequestMapping("/photo")
public class PhotoController {

	@Autowired
	private PhotoService photoService;

	@PostMapping
	public String addPhoto(@RequestParam("image") MultipartFile image) throws IOException {

		String id = photoService.addPhoto(image.getOriginalFilename(), image);

		return id;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Resource> downloadPhoto(@PathVariable String id){
		
		Photo photo = photoService.getPhoto(id);
		
		Resource  resource
				=new ByteArrayResource(photo.getPhoto().getData());
		
		return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+photo.getTitle()+"\"")
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.body(resource);
	}
	
}