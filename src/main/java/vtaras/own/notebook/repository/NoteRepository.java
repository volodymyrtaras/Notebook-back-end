package vtaras.own.notebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vtaras.own.notebook.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {}
