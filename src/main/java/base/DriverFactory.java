package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private String browser;

	public DriverFactory(String browser) {
		this.browser = browser.toLowerCase();
	}

	public WebDriver createDriver() {

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
			driver.set(new ChromeDriver());
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
			driver.set(new FirefoxDriver());
			break;

		default:
			System.out.println("Do not know how to start " + browser + ", starting chrome.");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
			driver.set(new ChromeDriver());
			break;
		}

		return driver.get();
	}
}
