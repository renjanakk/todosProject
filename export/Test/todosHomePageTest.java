package Test;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.baseClass;
import Controller.todosHomePageController;
import Model.todosHomePageModel;
import View.todosHomePageView;

public class todosHomePageTest extends baseClass {
	private todosHomePageController todoshomePageController;
	todosHomePageView todoshomePageView;
	todosHomePageModel todoshomePageModel;
	
	public todosHomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		initialization();
		todoshomePageModel = new todosHomePageModel(driver.getCurrentUrl());
		todoshomePageView = new todosHomePageView();
		todoshomePageController = new todosHomePageController(todoshomePageModel, todoshomePageView);
	}
	
	@Test //verify page title display
	public void todoshomePageTitleTest() {
		String pageTitle=todoshomePageController.gettodosHomePageTitle();
		Assert.assertEquals("TodoMVC: React",pageTitle,"todosHomePage Title is not matching");
		todoshomePageView.displaytodosHomePageTitle(pageTitle);
	}
	
	@Test //verify page header display
	public void todoshomePageHeaderTest() {
		Assert.assertEquals(todoshomePageController.verifytodosHomePageHeader(), true, "todosHomePage Header is not displayed");
		todoshomePageView.displaytodosHomePageHeader(todoshomePageController.gettodosHomePageHeader());
	}
	
	@Test //Scenario 1:To add a new task
	public void todoshomePageAddNewTaskTest() {
		todoshomePageController.verifytodosHomePageAddNewTask(prop.getProperty("Task1"));
		String newTask=todoshomePageController.verifytodosHomePageReadTask();
		Assert.assertEquals(prop.getProperty("Task1"), newTask,"todosHomePage new task is not in task list");

		todoshomePageController.verifytodosHomePageAddNewTask(prop.getProperty("Task2"));
		newTask=todoshomePageController.verifytodosHomePageReadTask();
		Assert.assertEquals(prop.getProperty("Task2"), newTask,"todosHomePage new task is not in task list");

		todoshomePageController.verifytodosHomePageAddNewTask(prop.getProperty("Task3"));
		newTask=todoshomePageController.verifytodosHomePageReadTask();
		Assert.assertEquals(prop.getProperty("Task3"), newTask,"todosHomePage new task is not in task list");
		todoshomePageController.verifytodosHomePageAddNewTaskTextBox();
		
		Assert.assertEquals(todoshomePageController.verifytodosHomePageTaskCheckBox(),true,"todosHomePage new task checkbox is not displayed");
		

		Assert.assertEquals(todoshomePageController.verifytodoHomePageNewTaskTxtBox(), true,"todosHomePage new task textbox is not displayed");
		Assert.assertEquals(todoshomePageController.verifytodoHomePageDownArrowInNewTaskDisplay(),true,"todosHomePage new task downarrow is not displayed");
		todoshomePageController.verifytodoHomePageDownArrowInNewTaskDisplay();
		Assert.assertEquals(todoshomePageController.verifyTodoCount(),3,"todosHomePage task count is not matching");
		
		Assert.assertTrue(todoshomePageController.verifytodoHomePageAllTaskLinkDisplay(), "todosHomePage All Button is not displayed");
		Assert.assertTrue(todoshomePageController.verifytodoHomePageActiveTaskLinkDisplay(), "todosHomePage Active Button is not displayed");
		Assert.assertTrue(todoshomePageController.verifytodoHomePageCompletedTaskLinkDisplay(), "todosHomePage Completed Button is not displayed");
		Assert.assertTrue(todoshomePageController.verifytodoHomePageClearCompletedTaskButtonDisplay(), "todosHomePage Clear Completed Link is not displayed");
		
	}
	
	@Test //Scenario 2:To edit a task
	public void todoshomePageEditTaskTest() {
		todoshomePageController.verifytodosHomePageAddNewTask(prop.getProperty("Task1"));
		todoshomePageController.verifytodosHomePageAddNewTask(prop.getProperty("Task2"));
		todoshomePageController.verifytodosHomePageAddNewTask(prop.getProperty("Task3"));
		todoshomePageController.verifytodosHomePageEditTask(prop.getProperty("editedtask"));
		String editedTask=todoshomePageController.verifytodosHomePageReadTask();
		Assert.assertEquals(prop.getProperty("Task3") + " edited", editedTask,"todosHomePage task is not edited");
		
	}
	@Test //Scenario 3:To mark an individual task as completed and view it
	public void todoshomePageMarkOneTaskCompletedTest() {
		todoshomePageController.verifytodosHomePageAddNewTask(prop.getProperty("Task1"));
		todoshomePageController.verifytodosHomePageAddNewTask(prop.getProperty("Task2"));
		todoshomePageController.verifytodosHomePageAddNewTask(prop.getProperty("Task3"));
		
		todoshomePageController.verifytodosHomePageMarkOneTaskCompleted();
		todoshomePageController.verifytodoHomePageCompletedTaskListDisplay();
		
		Assert.assertTrue(todoshomePageController.verifytodosHomePageCompletedTaskCheckBoxSelected(), "todosHomePage Completed task is not selected");
		
		todoshomePageController.verifytodosHomePageAllTaskDisplay();
		
		todoshomePageController.verifytodosHomePageFullTaskList();
	}
	
	@Test //Scenario 4:To view all Active tasks
	public void todoshomePageViewActiveTaskTest() {
		todoshomePageController.verifytodosHomePageAddNewTask(prop.getProperty("Task1"));
		todoshomePageController.verifytodosHomePageAddNewTask(prop.getProperty("Task2"));
		todoshomePageController.verifytodosHomePageAddNewTask(prop.getProperty("Task3"));
		
		todoshomePageController.verifytodosHomePageMarkOneTaskCompleted();
		todoshomePageController.verifytodosHomePageActiveTaskListDisplay();
		todoshomePageController.verifytodosHomePageFullTaskList();
		Assert.assertFalse(false,"todosHomePage All listed tasks are not active");
	}
	@Test //Scenario 5:To mark all tasks as completed
	public void todoshomePageMarkAllTaskCompletedTest() {
		todoshomePageController.verifytodosHomePageAddNewTask(prop.getProperty("Task1"));
		todoshomePageController.verifytodosHomePageAddNewTask(prop.getProperty("Task2"));
		todoshomePageController.verifytodosHomePageAddNewTask(prop.getProperty("Task3"));
		todoshomePageController.verifytodosHomePageAddNewTaskTextBox();
		
		todoshomePageController.verifytodosHomePageMarkAllTaskCompletedDisplay();
	
		todoshomePageController.verifytodoHomePageCompletedTaskListDisplay();
		todoshomePageController.verifytodosHomePageFullTaskList();
		Assert.assertTrue(true,"todosHomePage All listed tasks are not marked completed");
		todoshomePageController.verifytodosHomePageMarkAllTaskCompletedDisplay();
		todoshomePageController.verifytodosHomePageActiveTaskListDisplay();
		todoshomePageController.verifytodosHomePageFullTaskList();
		Assert.assertFalse(false,"todosHomePage All listed tasks are marked completed");
	}
	@Test //Scenario 6:To delete an individual task
	public void todoshomePageDeleteTaskTest() {
		todoshomePageController.verifytodosHomePageAddNewTask(prop.getProperty("Task1"));
		todoshomePageController.verifytodosHomePageAddNewTask(prop.getProperty("Task2"));
		todoshomePageController.verifytodosHomePageAddNewTask(prop.getProperty("Task3"));
		
		int todosListCount=todoshomePageController.verifytodosHomePageDeleteTask();
		todoshomePageController.verifytodosHomePageAllTaskDisplay();
		
		Assert.assertEquals(2, todosListCount,"todosHomePage selected task is not deleted");
		todoshomePageView.displaytodosHomePageTaskListCount(todosListCount);
	}
	@Test //Scenario 7:To delete all Completed tasks from the list
	public void todoshomePageDeleteCompletedTaskTest() {
		todoshomePageController.verifytodosHomePageAddNewTask(prop.getProperty("Task1"));
		todoshomePageController.verifytodosHomePageAddNewTask(prop.getProperty("Task2"));
		todoshomePageController.verifytodosHomePageAddNewTask(prop.getProperty("Task3"));
		todoshomePageController.verifytodosHomePageDeleteTask();
		int todosListCount=todoshomePageController.verifytodosHomePageDeleteTask();
		todoshomePageController.verifytodosHomePageAllTaskDisplay();
		
		Assert.assertEquals(1, todosListCount,"todosHomePage selected tasks are not deleted");
		todoshomePageView.displaytodosHomePageTaskListCount(todosListCount);

	}
	@AfterMethod
	public void closeBrowser() {
		if (todoshomePageController != null) {
			todoshomePageController.getDriver().quit();
        }

	}
}
