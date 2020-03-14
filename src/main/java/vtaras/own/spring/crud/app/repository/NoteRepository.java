package vtaras.own.spring.crud.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vtaras.own.spring.crud.app.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {}
