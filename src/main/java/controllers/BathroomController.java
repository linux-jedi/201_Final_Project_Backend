package controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exceptions.BathroomNotFoundException;
import models.Bathroom;
import models.Photo;

@RestController
@RequestMapping("/bathroom")
public class BathroomController {
	private BathroomRepository bathroomRepository;
	private PhotoRepository photoRepository;
	
	@GetMapping
	public Iterable<Bathroom> readBathrooms() {
		return bathroomRepository.findAll();
	}
	
	@GetMapping(value = "/{bathroomId}")
	public Bathroom readBathroom(@PathVariable Integer id) {
		this.validateBathroomExists(id);
		return bathroomRepository.findById(id).get();
    }
	
	@GetMapping(value = "/{bathroomId}/photos")
	public Iterable<Photo> getPhotos(@PathVariable Integer bathroomId){
		this.validateBathroomExists(bathroomId);
		return this.photoRepository.findByBathroomId(bathroomId);
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
