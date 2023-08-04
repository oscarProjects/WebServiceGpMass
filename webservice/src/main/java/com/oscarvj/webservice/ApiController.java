package com.oscarvj.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.oscarvj.webservice.model.Note;
import com.oscarvj.webservice.model.ResponseModel;
import com.oscarvj.webservice.repository.NoteRepository;

@RestController()
@RequestMapping("/api/v1")
public class ApiController {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/hello")
    public ResponseModel sayHello() {
    	ResponseModel response = new ResponseModel();
    	response.setSuccess(true);
    	response.setNoteSaved(null);
    	response.setListNotes(null);
    	response.setMessage("Message");
        return response;
    }

	@GetMapping("/all-notes")
    public ResponseModel getAllNotes() {
		List<Note> listNotes = noteRepository.findAll();
		ResponseModel response = new ResponseModel();
		if(listNotes.size() > 0) {
			response.setSuccess(true);
			response.setNoteSaved(null);
	    	response.setListNotes(listNotes);
	    	response.setMessage("Ok");
		}else {
			response.setSuccess(false);
			response.setNoteSaved(null);
	    	response.setListNotes(null);
	    	response.setMessage("Error");
		}
        return response;
    }

    @GetMapping("/{id}")
    public Note getNoteById(@PathVariable Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    @PostMapping("/add-note")
    public ResponseModel addNote(@RequestBody Note note) {
    	Note noteSaved = noteRepository.save(note);
    	ResponseModel response = new ResponseModel();
    	response.setSuccess(true);
    	response.setNoteSaved(noteSaved);
    	response.setListNotes(null);
    	response.setMessage("Ok");
        return response;
    }


    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
    	noteRepository.deleteById(id);
    }
}