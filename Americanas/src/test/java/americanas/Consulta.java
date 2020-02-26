package americanas;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Consulta {
	String url;
	WebDriver driver;
	String nomePasta = new SimpleDateFormat("yyyy-MM-dd HH-mm").format(Calendar.getInstance().getTime());

	// Funções e Métodos de Apoio

	// Tirar Print da Tela
	public void Print(String nomePrint) throws IOException {
		File foto = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(foto, new File("C:\\Users\\xande\\fts-workspace\\Americanas\\target\\evidencias\\" + nomePasta + "\\" + nomePrint + ".png"));

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

	@Given("^I acess Americanas site$")
	public void i_acess_Americanas_site() throws Throwable {
		driver.get(url);
		Print("Step 1 - I acess Americanas site");

	}

	@When("^I type the term \"([^\"]*)\" and click Enter and I click in a product$")
	public void i_type_the_term_and_click_Enter_and_I_click_in_a_product(String term) throws Throwable {
		driver.findElement(By.id("h_search-input")).clear();
		driver.findElement(By.id("h_search-input")).sendKeys(term);
		driver.findElement(By.id("h_search-input")).sendKeys(Keys.ENTER);
		driver.findElement(By.xpath("//*[@id=\"content-middle\"]/div[6]/div/div/div/div[1]/div[1]/div/div[2]/a/section/div[1]/div/div/picture/img")).click();
		Print("Step 2 - I type the term and click Enter and I click in a product");
	}

	@When("^I press Buy$")
	public void i_press_Buy() throws Throwable {
		Thread.sleep(5000);
		driver.findElement(By.id("btn-buy")).sendKeys(Keys.ENTER);
		Print("Step 3 - I clicked Buy");
	}

	@Then("^I see the Carts Page$")
	public void i_see_the_Carts_Page() throws Throwable {
		assertEquals("minha cesta", driver.findElement(By.xpath("//*[@id=\"app\"]/section/header/h2")).getText());
		Print("Step 4 - I saw the Carts Page");
	}

}
