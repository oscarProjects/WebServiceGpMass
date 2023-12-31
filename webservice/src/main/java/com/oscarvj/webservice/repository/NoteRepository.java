package com.oscarvj.webservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oscarvj.webservice.model.Note;

public interface NoteRepository extends JpaRepository<Note, Long> {

}