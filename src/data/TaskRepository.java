package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import model.Task;

public class TaskRepository {
	
	private static Connection getConnection() throws SQLException {
		String host = "localhost";
		String sqlInstance = "LAPTOP-C2M2SNG5\\SQLEXPRESS";
		String sqlDatabase = "TaskManager";
		String sqlUser = "TaskMangerLogin";
		String sqlPassword = "music1234";
		
		String jdbcConnection = String.format("jdbc:sqlserver://%s:1433;instance=%s;databaseName=%s;encrypt=true;trustServerCertificate=true",
				host,
				sqlInstance,
				sqlDatabase);
		
		Connection connection = DriverManager.getConnection(jdbcConnection, sqlUser, sqlPassword);
		System.out.println("Connection to database successful!");
		
		return connection;
	}
	
	/*
	 * CRUD Operations
	 * 
	 * (C)reate - creates a new Task
	 * (R)ead - get a single Task or multiple Tasks
	 * (U)pdate - updates a Task
	 * (D)elete - delete a Task
	 */
	
	// method that returns all the tasks in our database
	public static ArrayList<Task> getAllTasks()throws SQLException{
		Statement statement = getConnection().createStatement();
		String sql = "SELECT * FROM Task";
		ArrayList<Task> allTasks = new ArrayList<Task>();
		
		ResultSet resultSet = statement.executeQuery(sql);
		
		// Loop throw each row in the result set
		while (resultSet.next()) {
			// for each result, create a new Task object using column values
			Task taskToAdd = new Task(
					resultSet.getInt("ID"), 
					resultSet.getInt("ListId"), 
					resultSet.getString("Description"), 
					resultSet.getInt("Priority"), 
					resultSet.getInt("Difficulty"), 
					resultSet.getString("DueDate") != null
					? LocalDateTime.parse(resultSet.getString("DueDate"))
							: null
					);
			
			// add the Task to the list	
					allTasks.add(taskToAdd);
		}
		
		return allTasks;
	}
	// method that returns all of the tasks by list
	public static Task getTaskById(int id) throws SQLException {
		Statement statement = getConnection().createStatement();
		String sql = "SELECT * FROM Task WHERE ID = " + id;
		
		ResultSet resultSet = statement.executeQuery(sql);
		resultSet.next();
		
		Task task = new Task(
				resultSet.getInt("ID"), 
				resultSet.getInt("ListId"), 
				resultSet.getString("Description"), 
				resultSet.getInt("Priority"), 
				resultSet.getInt("Difficulty"), 
				resultSet.getString("DueDate") != null
				? LocalDateTime.parse(resultSet.getString("DueDate"))
						: null);
		
		return task;
		
	}
	
	// method that returns a single task
	
	// method that adds a new task
	
	// method that deletes a task
	
	// method that updates a task

}
