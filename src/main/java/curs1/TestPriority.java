package curs1;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestPriority { //ruleaza intai cele fara priority alfabetic si apoi prio0, 1..., deci dc pui la una priority pune la toate metodele cel mai bine
	
	@Test(priority = 0)
	public void one() {
		System.out.println("First");
	}
	@Test(priority = 1)
	public void two() {
		System.out.println("Second");
	}
	@Test(priority = 2)
	public void three() {
		System.out.println("Third");
	}
	@Test
	public void four() {
		System.out.println("Fourth");
	}
	@Ignore //fie pun ignore fie commentez @Test
	public void five() {
		System.out.println("Fifth");
	}

}
