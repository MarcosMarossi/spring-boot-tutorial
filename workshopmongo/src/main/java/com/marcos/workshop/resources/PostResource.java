package com.marcos.workshop.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.marcos.workshop.model.Post;
import com.marcos.workshop.resources.util.URL;
import com.marcos.workshop.model.Post;
import com.marcos.workshop.services.PostService;

@RestController
@RequestMapping (value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@GetMapping (value = "/{id}")
	public ResponseEntity<Post> findById( @PathVariable String id ) {		
		Post post = service.findById(id);
		return ResponseEntity.ok().body(post);		
	}
	
	@GetMapping (value = "/fullsearch")
	public ResponseEntity<List<Post>> fullSearch ( 
			@RequestParam ( value = "text", defaultValue = "" )  String text,
			@RequestParam ( value = "minDate", defaultValue = "" )  String minDate,
			@RequestParam ( value = "maxDate", defaultValue = "" )  String maxDate) {	
		Date min = URL.convertDate(minDate, new Date(0L));
		Date max = URL.convertDate(maxDate, new Date());
		text = URL.decodeParam(text);
		List<Post> list = service.fullSearch(text, min, max);
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping (value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle ( @RequestParam ( value = "text", defaultValue = "" )  String text ) {		
		text = URL.decodeParam(text);
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);		
	}
}
