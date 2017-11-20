package controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import exceptions.BathroomNotFoundException;
import models.Bathroom;
import models.Photo;

@RestController
@RequestMapping("/bathroom")
public class BathroomController {
	private final BathroomRepository bathroomRepository;
	
	private final PhotoRepository photoRepository;
	
	private final StorageService storageService;
	
	@Autowired
	public BathroomController(BathroomRepository bathroomRepository, PhotoRepository photoRepository, StorageService storageService) {
		this.bathroomRepository = bathroomRepository;
		this.photoRepository = photoRepository;
		this.storageService = storageService;
	}
	
	@GetMapping
	public Iterable<Bathroom> readBathrooms() {
		return bathroomRepository.findAll();
	}
	
	@GetMapping(value = "/{bathroomId}")
	public Bathroom readBathroom(@PathVariable Integer id) {
		this.validateBathroomExists(id);
		return bathroomRepository.findById(id).get();
    }
	
	@GetMapping(value = "/{bathroomId}/photo")
	public Iterable<Photo> getPhotos(@PathVariable Integer bathroomId){
		this.validateBathroomExists(bathroomId);
		return this.photoRepository.findByBathroomId(bathroomId);
	}
	
	@PostMapping(value = "/{bathroomId}/photo")
	public Photo addPhoto(
			@PathVariable Integer bathroomId,
			@RequestBody Photo photo,
			@RequestParam("file") MultipartFile file
			) {
		
		String newFileName = "";
		File newFile = new File(newFileName);
		
		try {
			OutputStream fos = new FileOutputStream(newFile);
			IOUtils.copy(file.getInputStream(), fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		storageService.store(newFile);
		return photoRepository.save(photo);
	}
	
	@PostMapping
	Bathroom add(@RequestBody Bathroom bathroom) {
		Integer id = this.bathroomRepository.save(bathroom).getId();
		
		return this.bathroomRepository.findById(id).get();
	}
	
	private void validateBathroomExists(Integer id) {
		this.bathroomRepository.findById(id).orElseThrow(
				() -> new BathroomNotFoundException(id));
	}
    
}
