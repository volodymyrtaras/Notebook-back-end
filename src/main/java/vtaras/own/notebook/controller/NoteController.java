package vtaras.own.notebook.controller;

import java.util.List;
import javax.validation.Valid;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vtaras.own.notebook.repository.NoteRepository;
import vtaras.own.notebook.exception.ResourceNotFoundException;
import vtaras.own.notebook.model.Note;

@RestController
@RequestMapping("/")
public class NoteController {

    @Setter(onMethod = @__(@Autowired))
    private NoteRepository noteRepository;

    @PostMapping("/notes/update")
    public Note createNote(@Valid @RequestBody Note note) {
        return noteRepository.save(note);
    }

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> getNodeById(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        Note note = findNote(id);
        return ResponseEntity.ok().body(note);
    }

    @PutMapping("/notes/update/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable(name = "id") Long id,
                                           @RequestBody Note updatedNote) throws ResourceNotFoundException {
        Note note = findNote(id);
        note.setText(updatedNote.getText());
        noteRepository.save(note);
        return ResponseEntity.ok().body(note);
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(name = "id") Long id) throws ResourceNotFoundException {
        findNote(id);
        noteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    private Note findNote(Long id) throws ResourceNotFoundException {
        return noteRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Note with id " + id + " not found"));
    }
}
