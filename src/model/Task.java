package model;

import java.time.LocalDateTime;

public class Task {
	private int id;
	private int listId;
	private String description;
	private int priority;
	private int difficulty;
	private LocalDateTime dueDate;
	
	public Task() {
		
	}
	
	
	
	public Task(int id, int listId, String description, int priority, int difficulty, LocalDateTime dueDate) {
		this.id = id;
		this.listId = listId;
		this.description = description;
		this.priority = priority;
		this.difficulty = difficulty;
		this.dueDate = dueDate;
	}



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getListId() {
		return listId;
	}
	public void setListId(int listId) {
		this.listId = listId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	public LocalDateTime getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}



	@Override
	public String toString() {
		return "Task [id=" + id + ", listId=" + listId + ", description=" + description + ", priority=" + priority
				+ ", difficulty=" + difficulty + ", dueDate=" + dueDate + "]";
	}
	
}
