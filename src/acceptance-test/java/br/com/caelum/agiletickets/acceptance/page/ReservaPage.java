package br.com.caelum.agiletickets.acceptance.page;

import org.openqa.selenium.WebDriver;

public class ReservaPage {

	private static final String BASE_URL = "http://localhost:8080";
	private final WebDriver driver;

	public ReservaPage(WebDriver driver) {
		this.driver = driver;
	}

	public void abreListagem() {
		driver.get(BASE_URL + "/");
	}

}
