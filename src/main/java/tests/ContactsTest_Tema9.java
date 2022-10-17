package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.ContactsPage;
import pages.NavMenuPage;
import pages.SingleAuthorPage;
import utils.BaseTest;

public class ContactsTest_Tema9 extends BaseTest{
	
	@Test(priority=0)
	public void PozitivTest() throws InterruptedException {
		NavMenuPage navMenu= new NavMenuPage(driver);
		ContactsPage pag=new ContactsPage(driver);
		navMenu.navigateTo(pag.contactsLink);
		Thread.sleep(2000);	
		
		pag.addText(pag.nameField, "Flori");
		pag.addText(pag.emailField, "email@email.com");	
		pag.addText(pag.SubjectField, "Subiect1");		
		pag.addText(pag.messageField, "Message1");
		
		
		pag.pressSendButton(pag.sendMessageButton);
		Thread.sleep(3000);
		assertEquals(pag.checkEmptyField(pag.nameField),"");
		assertEquals(pag.checkEmptyField(pag.emailField),"");
		assertEquals(pag.checkEmptyField(pag.messageField),"");
		
	}
	
	@Test(priority=1)
	public void NameEmpty() throws InterruptedException {
		NavMenuPage navMenu= new NavMenuPage(driver);
		ContactsPage pag=new ContactsPage(driver);
		navMenu.navigateTo(pag.contactsLink);
		Thread.sleep(2000);	
		
		//pag.addText(pag.nameField, "Flori");
		pag.addText(pag.emailField, "email@email.com");	
		pag.addText(pag.SubjectField, "Subiect1");		
		pag.addText(pag.messageField, "Message1");
		Thread.sleep(3000);
		
		pag.pressSendButton(pag.sendMessageButton);
		Thread.sleep(3000);
		assertEquals(pag.checkEmptyField(pag.emptyMessage),"The field is required.");
	
		
	}
	@Test(priority=2)
	public void EmailEmpty() throws InterruptedException {
		NavMenuPage navMenu= new NavMenuPage(driver);
		ContactsPage pag=new ContactsPage(driver);
		navMenu.navigateTo(pag.contactsLink);
		Thread.sleep(2000);	
		
		pag.addText(pag.nameField, "Flori");
		//pag.addText(pag.emailField, "email@email.com");	
		pag.addText(pag.SubjectField, "Subiect1");		
		pag.addText(pag.messageField, "Message1");
		Thread.sleep(3000);
		
		pag.pressSendButton(pag.sendMessageButton);
		Thread.sleep(3000);
		assertEquals(pag.checkEmptyField(pag.emptyMessage),"The field is required.");
	
		
	}
	@Test(priority=3)
	public void MessageEmpty() throws InterruptedException {
		NavMenuPage navMenu= new NavMenuPage(driver);
		ContactsPage pag=new ContactsPage(driver);
		navMenu.navigateTo(pag.contactsLink);
		Thread.sleep(2000);	
		
		pag.addText(pag.nameField, "Flori");
		pag.addText(pag.emailField, "email@email.com");	
		pag.addText(pag.SubjectField, "Subiect1");		
		//pag.addText(pag.messageField, "Message1");
		Thread.sleep(3000);
		
		pag.pressSendButton(pag.sendMessageButton);
		Thread.sleep(3000);
		assertEquals(pag.checkEmptyField(pag.emptyMessage),"The field is required.");
	
		
	}
	

}
