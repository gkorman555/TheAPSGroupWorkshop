package com.activiti.extension.bean.service;
import java.util.List;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.activiti.domain.idm.User;
import com.activiti.service.api.UserService;

@Component("workManagementService")
public class WorkManagementService {
	
    //Logger
    private static Logger logger = LoggerFactory.getLogger(WorkManagementService.class);
	
	@Autowired
	protected UserService userService;
	
	@Autowired
	protected TaskService taskService;
	
	/**
	 * Re-assigns Tasks from one User to another User.
	 * @param 	reassignFrom
	 * 				the ID of the User from which Tasks should be re-assigned
	 * @param 	reassignTo
	 * 				the ID of the User to which Tasks should be re-assigned
	 * 	
	 */
	public void reassignUserTasks(final Long reassignFrom, final Long reassignTo) {
		
		//Obtain the Users
		final User reassignFromUser = userService.findUser(reassignFrom);
		final User reassignToUser = userService.findUser(reassignTo);
		logger.debug("Re-assigning tasks from " + reassignFromUser.getFullName() + " to " + reassignToUser.getFullName());
		
		//Obtain all Task assigned to the User
		final List<Task> theTasks = taskService.createTaskQuery()
										.active()
										.taskAssignee(reassignFromUser.getId().toString())
										.list();
		
		//Process the Tasks
		logger.debug("Obtained " + theTasks.size() + " tasks to be re-assigned to " + reassignToUser.getFullName());
		for (final Task theTask : theTasks){
			
			//Assign the Task
			taskService.setAssignee(theTask.getId(), reassignToUser.getId().toString());
			logger.debug("Reassigned Task " + theTask.getId() + " to " + reassignToUser.getFullName());
		}
	}
}
