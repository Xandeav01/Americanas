package americanas;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	String url;
	WebDriver driver;
	String nomePasta = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());

	// Funções e Métodos de Apoio

	// Tirar Print da Tela
	public void Print(String nomePrint) throws IOException {
		File foto = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(foto, new File("C:\\Users\\xande\\fts-workspace\\Americanas\\target\\evidencias\\"
				+ nomePasta + "\\" + nomePrint + ".png"));

	}

	@Before
	public void Iniciar() {
		url = "https://www.americanas.com.br";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\xande\\fts-workspace\\Americanas\\drivers\\chrome\\80\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}

	@After
	public void Finalizar() {
		driver.quit();
	}

	@Given("^Eu acesso o site da Americanas$")
	public void eu_acesso_o_site_da_Americanas() throws Throwable {
		driver.get(url);
		Print("Passo 1 - Eu acesso o site da Americanas");
	}

	@When("^Eu clico em cadastrese e clico em Entrar e preencho o email \"([^\"]*)\" e preencho a senha \"([^\"]*)\"$")
	public void eu_clico_em_cadastrese_e_clico_em_Entrar_e_preencho_o_email_e_preencho_a_senha(String email,
			String senha) throws Throwable {
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("#h_usr-link > span.usr-act-text")).click();
		driver.findElement(By.id("h_usr-signin")).click();
		driver.findElement(By.id("email-input")).clear();
		driver.findElement(By.id("email-input")).sendKeys(email);
		driver.findElement(By.id("password-input")).click();
		driver.findElement(By.id("password-input")).sendKeys(senha);
		Print("Passo 2 - Eu clico em cadastrese e clico em Entrar e preencho email e preencho a senha");

	}

	@When("^Eu clico em continuar$")
	public void eu_clico_em_continuar() throws Throwable {
		Thread.sleep(60000);
		driver.findElement(By.id("login-button")).click();
		Print("Passo 3 - Eu clico em continuar");
	}

	@Then("^Eu acesso a pagina da Americanas com meu login$")
	public void eu_acesso_a_pagina_da_Americanas_com_meu_login() throws Throwable {
		Thread.sleep(40000);
		assertEquals("olá Adriana", driver.findElement(By.xpath("//*[@id=\"h_user\"]/span[1]/div")).getText());
		Print("Passo 4 - Eu acesso a pagina da Americanas com o meu login");

	}

}
