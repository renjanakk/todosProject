package Model;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.baseClass;

public class todosHomePageModel extends baseClass {
	private String url;

	//PageFactory or ObjectRepository of HomePage
	@FindBy(xpath ="//h1[text()='todos']") 
  	public WebElement todoHeader;

	@FindBy(id ="todo-input") 
  	public WebElement enterNewTask;
	
	//@FindBy(css ="main.main>div.toggle-all-container>label.toggle-all-label") 	
	//@FindBy(css ="main.main>div.toggle-all-container>input.toggle-all") 
	//@FindBy(xpath ="//input[@class='toggle-all' and @type='checkbox']") 
	
	@FindBy(css ="input.toggle-all")
  	public WebElement downArrowInNewTaskTxtBox;
	
	@FindBy(css ="ul.todo-list>li:last-of-type>div.view>label") 
  	public WebElement newlyEnteredTask;
	
	@FindBy(css ="ul.todo-list>li:nth-of-type(1)>div.view>input.toggle") 
  	public WebElement newlyEnteredTaskCheckbox;
	
	@FindBy(css ="ul.todo-list>li:last-of-type>div.view>button") 
  	public WebElement deleteTaskButton;
	
	@FindBy(xpath ="//ul[@class='todo-list']//li") 
  	public List<WebElement> todoList;
	
	@FindBy(xpath ="//ul[@class='todo-list']//li//div//input") 
  	public List<WebElement> todoListCheckBoxes;
	
	@FindBy(css ="span.todo-count") 
  	public WebElement todoCount;
	
	@FindBy(xpath ="//a[text()='All']") 
  	public WebElement allTaskLink;

	@FindBy(xpath ="//a[text()='Active']") 
  	public WebElement activeTaskLink;
	
	@FindBy(xpath ="//a[text()='Completed']") 
  	public WebElement completedTaskLink;
	
	@FindBy(xpath ="//button[text()='Clear completed']") 
  	public WebElement clearCompletedTaskButton;
	
	//Initializing the page objects
  	public todosHomePageModel(String url) {
  		PageFactory.initElements(driver, this);
  		this.url=url;
  	}
  	
  	public String getUrl() {
	    return url;
	}
	
	public WebElement getTodoHeader() {
		return todoHeader;
	}
	
	public WebElement getNewTodo() {
		return enterNewTask;
	}

	public WebElement getNewlyEnteredTaskCheckbox() {
		return newlyEnteredTaskCheckbox;
	}

	public List<WebElement> getTodoList() {
		return todoList;
	}

	public WebElement getTodoCount() {
		return todoCount;
	}

	public WebElement getAllTaskLink() {
		return allTaskLink;
	}

	public WebElement getActiveTaskLink() {
		return activeTaskLink;
	}

	public WebElement getCompletedTaskLink() {
		return completedTaskLink;
	}

	public WebElement getClearCompletedTaskButton() {
		return clearCompletedTaskButton;
	}

	public WebElement getDeleteTaskButton() {
		return deleteTaskButton;
	}
	
	public WebElement getNewlyEnteredTask() {
		return newlyEnteredTask;
	}
	
	public WebElement getDownArrowInNewTaskTxtBox() {
		return downArrowInNewTaskTxtBox;
	}
	
	public List<WebElement> getTodoListCheckBoxes() {
		return todoListCheckBoxes;
	}
}
