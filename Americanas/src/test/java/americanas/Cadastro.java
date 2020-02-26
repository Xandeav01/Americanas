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

public class Cadastro {
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

	@Given("^Eu acesso o site da Americas$")
	public void eu_acesso_o_site_da_Americas() throws Throwable {
		driver.get(url);
		Print("Passo 1 - Eu acesso o site da Americanas");
	}

	@When("^Eu clico em cadastrese e clico em Cadastrar e preencho email \"([^\"]*)\" e preencho senha \"([^\"]*)\" e preencho cpf \"([^\"]*)\" e preencho nome \"([^\"]*)\" e preencho data de nascimento \"([^\"]*)\" e clico em sexo Feminino e preencho telefone \"([^\"]*)\"$")
	public void eu_clico_em_cadastrese_e_clico_em_Cadastrar_e_preencho_email_e_preencho_senha_e_preencho_cpf_e_preencho_nome_e_preencho_data_de_nascimento_e_clico_em_sexo_Feminino_e_preencho_telefone(
			String email, String senha, String cpf, String nome, String nascimento, String telefone) throws Throwable {
		driver.findElement(By.cssSelector("#h_usr-link > span.usr-act-text")).click();
		driver.findElement(By.className("usr-signup")).click();
		driver.findElement(By.id("email-input")).clear();
		driver.findElement(By.id("email-input")).sendKeys(email);
		driver.findElement(By.id("password-input")).clear();
		driver.findElement(By.id("password-input")).sendKeys(senha);
		driver.findElement(By.id("cpf-input")).clear();
		driver.findElement(By.id("cpf-input")).sendKeys(cpf);
		driver.findElement(By.id("name-input")).clear();
		driver.findElement(By.id("name-input")).sendKeys(nome);
		driver.findElement(By.id("birthday-input")).clear();
		driver.findElement(By.id("birthday-input")).sendKeys(nascimento);
		driver.findElement(By.xpath("//*[@id=\"gender\"]/div[2]/label")).click();
		driver.findElement(By.id("phone-input")).clear();
		driver.findElement(By.id("phone-input")).sendKeys(telefone);
		Print("Passo 2 - Eu clico em cadastrese e clico em Cadastrar e preencho email e preencho senha e preencho CPF e preencho nome e preencho data de nascimento e clico em sexo Feminino e preencho telefone");

	}

	@When("^E clico em criar seu cadastro$")
	public void e_clico_em_criar_seu_cadastro() throws Throwable {
		Thread.sleep(60000);
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/button")).click();
		Print("Passo 3 - E clico em criar seu cadastro");
	}

	@Then("^Eu acesso a pagina da Americanas com meu cadastro$")
	public void eu_acesso_a_pagina_da_Americanas_com_meu_cadastro() throws Throwable {
		Thread.sleep(40000);
		assertEquals("olá Marcela", driver.findElement(By.xpath("//*[@id=\"h_user\"]/span[1]/div")).getText());
		Print("Passo 4 - Eu acesso a pagina da Americanas com o meu cadastro");

	}
}
