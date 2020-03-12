package vtaras.own.spring.crudapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vtaras.own.spring.crudapp.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {}
