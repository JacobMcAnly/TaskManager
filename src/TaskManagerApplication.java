import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import business.TaskLogic;
import model.Task;

public class TaskManagerApplication {

	public static void main(String[] args) throws SQLException {
		
		// loop through all the tasks in our database
		for(Task task : TaskLogic.getAllTasksByList(0)) {
			System.out.println(task);
		}
	
		System.out.println(TaskLogic.getTaskById(1));
	
	}
}
