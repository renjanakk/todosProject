package Controller;


import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BaseClass.baseClass;
import Model.todosHomePageModel;
import View.todosHomePageView;


public class todosHomePageController extends baseClass {
	private todosHomePageModel todoshomePageModel;
	private todosHomePageView todoshomePageView;
	
	public todosHomePageController(todosHomePageModel todoshomePageModel,todosHomePageView todoshomePageView ) {
		this.todoshomePageModel=todoshomePageModel;
		this.todoshomePageView=todoshomePageView;
	}
	
	//Actions
    public String gettodosHomePageTitle() {
        return driver.getTitle();
    }
    
    public String gettodosHomePageHeader() {
        return todoshomePageModel.getTodoHeader().getText();
    }
    
    public void todosHomePageLoad() {
        driver.get(todoshomePageModel.getUrl());
        //System.out.println("from loginctrl.loadpage : " + loginPageModel.getUrl());
    }

    public WebDriver getDritodoshomePageModelver() {
    	return driver;
    }
    
    public boolean verifytodosHomePageHeader() {
    	return todoshomePageModel.getTodoHeader().isDisplayed();
    	
    }
    
    public WebDriver getDriver() {
    	return driver;
    }
     
    public void verifytodosHomePageAddNewTask(String ipTask) {
    	todoshomePageModel.getNewTodo().sendKeys(ipTask);
    	todoshomePageModel.getNewTodo().sendKeys(Keys.ENTER);
    }
    public void verifytodosHomePageAddNewTaskTextBox() {
    	todoshomePageModel.getNewTodo().click();
    }
    public String verifytodosHomePageReadTask() {
    	return todoshomePageModel.getNewlyEnteredTask().getText();
    }
    public void verifytodosHomePageEditTask(String editText) {
    	point = new Actions(driver);
		point.moveToElement(todoshomePageModel.getNewlyEnteredTask()).doubleClick();
		point.sendKeys(Keys.SPACE);
		point.sendKeys(editText);
		point.sendKeys(Keys.ENTER);
		point.perform();
   }
    public boolean verifytodosHomePageTaskCheckBox() {
       	//wait=new WebDriverWait(driver,Duration.ofSeconds(30));
    	//wait.until(ExpectedConditions.visibilityOf(todoshomePageModel.getNewlyEnteredTaskCheckbox()));

    	return todoshomePageModel.getNewlyEnteredTaskCheckbox().isEnabled();
    }
    public boolean verifytodoHomePageNewTaskTxtBox() {
    	return todoshomePageModel.getNewTodo().isDisplayed();
    }
    public int verifyTodoCount(){
    	String todoCount=todoshomePageModel.getTodoCount().getText();
    	return Integer.parseInt(todoCount.substring(0,todoCount.indexOf(" ")));
    }
    public boolean verifytodoHomePageAllTaskLinkDisplay() {
    	return todoshomePageModel.getAllTaskLink().isDisplayed();
    }
    public boolean verifytodoHomePageActiveTaskLinkDisplay() {
    	return todoshomePageModel.getActiveTaskLink().isDisplayed();
    }
    public boolean verifytodoHomePageCompletedTaskLinkDisplay() {
    	return todoshomePageModel.getCompletedTaskLink().isDisplayed();
    	
    }
    public boolean verifytodoHomePageClearCompletedTaskButtonDisplay() {
    	return todoshomePageModel.getClearCompletedTaskButton().isDisplayed();
    	
    }
    public boolean verifytodoHomePageDownArrowInNewTaskDisplay() {
    	point = new Actions(driver);
		point.moveToElement(todoshomePageModel.getDownArrowInNewTaskTxtBox()).click();
		
		point.perform();
		
    	return todoshomePageModel.getDownArrowInNewTaskTxtBox().isEnabled();
    	
    }
    public void verifytodosHomePageMarkOneTaskCompleted() {
    	todoshomePageModel.getNewlyEnteredTaskCheckbox().click();
    }
    public void verifytodoHomePageCompletedTaskListDisplay() {
    	todoshomePageModel.getCompletedTaskLink().click();
    	
    }
    public boolean verifytodosHomePageCompletedTaskCheckBoxSelected() {
     	return todoshomePageModel.getNewlyEnteredTaskCheckbox().isSelected();
    }
    public void verifytodosHomePageAllTaskDisplay() {
    	todoshomePageModel.getAllTaskLink().click();
    }
    public void verifytodosHomePageFullTaskList() {
		todoshomePageView.displaytodosHomePageTaskList(todoshomePageModel.getTodoList());
	}
    public void verifytodosHomePageActiveTaskListDisplay() {
    	todoshomePageModel.getActiveTaskLink().click();
    }
    public void verifytodosHomePageMarkAllTaskCompletedDisplay() {
      	//wait=new WebDriverWait(driver,Duration.ofSeconds(30));
    	//wait.until(ExpectedConditions.elementToBeClickable(todoshomePageModel.getDownArrowInNewTaskTxtBox()));

    	//todoshomePageModel.getDownArrowInNewTaskTxtBox().click();
    	
    	point = new Actions(driver);
		point.moveToElement(todoshomePageModel.getDownArrowInNewTaskTxtBox()).click();
		
		point.perform();
    }
    
    public int verifytodosHomePageDeleteTask() {
    	point = new Actions(driver);
		point.moveToElement(todoshomePageModel.getNewlyEnteredTask());
		point.moveToElement(todoshomePageModel.getDeleteTaskButton()).click();
		point.perform();
		return todoshomePageModel.getTodoList().size();
   }
}