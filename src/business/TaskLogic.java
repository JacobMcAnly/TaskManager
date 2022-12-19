package business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.stream.Collectors;

import data.TaskRepository;
import model.Task;

public class TaskLogic {
	public static ArrayList<Task> getAllTasks() throws SQLException {
		return TaskRepository.getAllTasks();
	}
	
	public static ArrayList<Task> getAllTasksByList(int listId) throws SQLException{
		ArrayList<Task> filteredList = (ArrayList<Task>) TaskRepository.getAllTasks().stream().filter(task -> task.getListId() == listId).collect(Collectors.toList());
		
		return filteredList;
	}
	
	public static Task getTaskById(int id) throws SQLException {
		return TaskRepository.getTaskById(id);
	}
}