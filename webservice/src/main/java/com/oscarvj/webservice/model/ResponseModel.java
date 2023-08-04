package com.oscarvj.webservice.model;

import java.util.List;

import lombok.Data;

@Data
public class ResponseModel {
	private boolean success;
	private Note noteSaved;
	private String message;
	private List<Note> listNotes;
}
