package View;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import BaseClass.baseClass;

public class todosHomePageView  extends baseClass{
	public void displaytodosHomePageTitle(String pageTitle) {
		System.out.println("todosHomePageTitle: - " + pageTitle);
	}
	public void displaytodosHomePageHeader(String pageHeader) {
		System.out.println("todosHomePageHeader: - " + pageHeader);
	}
	public boolean displaytodosHomePageTaskList(List<WebElement> todoList) {
		boolean TaskChecked=false;
		System.out.println();
		System.out.println("There are "+ todoList.size() +" tasks in the list");
		int i=1;
    	for (WebElement e  : todoList) {
    		WebElement chk=driver.findElement(By.xpath("//ul[@class='todo-list']//li["+ i +"]//div//input"));
    		System.out.printf("%-35s" , e.getText());
    		System.out.printf(" -- " + (chk.isSelected()? "Checked":"UnChecked"));
    		System.out.println();
    		i++;
    		if (chk.isSelected()) {
    			TaskChecked=true;
    		}
    	}
    	return TaskChecked;
	}
	public void displaytodosHomePageTaskListCount(int taskListCount) {
		
		System.out.println("todosHomePage Task List Count: - " + taskListCount);
	}
}
