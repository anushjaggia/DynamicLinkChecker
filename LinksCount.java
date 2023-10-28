import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LinksCount {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());

		// Limiting scope to footer links
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());

		// limiting the scope of driver to a specific column in footer

		WebElement columnFooter = footerdriver.findElement(By.xpath("//tbody/tr/td[1]/ul"));
		System.out.println(columnFooter.findElements(By.tagName("a")).size());

		// click on each link in the column and check if each link is opening
		for (int i = 1; i < columnFooter.findElements(By.tagName("a")).size(); i++) {
			String clickonLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnFooter.findElements(By.tagName("a")).get(i).sendKeys(clickonLinkTab);
		}
		// iterator to parse every window
		Set<String> abc = driver.getWindowHandles();
		Iterator<String> it = abc.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());

		}

	}
}
