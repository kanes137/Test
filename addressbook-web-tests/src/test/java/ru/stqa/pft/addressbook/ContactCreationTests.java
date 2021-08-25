package ru.stqa.pft.addressbook;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactCreationTests {
  private WebDriver driver;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    login("admin", "secret");
  }

  private void login(String username, String password) {
    driver.get("http://localhost/addressbook/index.php");
    driver.findElement(By.name("user")).click();
    driver.findElement(By.name("user")).clear();
    driver.findElement(By.name("user")).sendKeys(username);
    driver.findElement(By.name("pass")).clear();
    driver.findElement(By.name("pass")).sendKeys(password);
    driver.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testContactCreationTests() throws Exception {
    initContactCreation();
    fillContactForm("Goose", "Alekseevich", "Mr", "kanes173");
    saveContact();
    goToHomePage();
    logout();
  }

  private void goToHomePage() {
    driver.findElement(By.linkText("home page")).click();
  }

  private void saveContact() {
    driver.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  private void fillContactForm(String firstname, String middlename, String lastname, String nickname) {
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys(firstname);
    driver.findElement(By.name("middlename")).clear();
    driver.findElement(By.name("middlename")).sendKeys(middlename);
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys(lastname);
    driver.findElement(By.name("nickname")).click();
    driver.findElement(By.name("nickname")).clear();
    driver.findElement(By.name("nickname")).sendKeys(nickname);
  }

  private void initContactCreation() {
    driver.findElement(By.linkText("add new")).click();
  }

  private void logout() {
    driver.findElement(By.linkText("Logout")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
