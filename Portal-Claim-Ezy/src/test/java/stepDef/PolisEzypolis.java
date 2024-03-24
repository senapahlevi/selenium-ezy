package stepDef;
import config.env_target;
import static org.junit.Assert.fail;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;

import io.cucumber.java.en_scouse.An;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PolisEzypolis extends env_target {
    @Given("User is already on homepage")
    public void user_in_homepage(){
        System.setProperty("webdriver.chrome.driver", "src/main/java/resource/chromedriver");
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(Polis);

        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("claim_number")));
    }
    @When("User fill registration number")
    public void user_input_registration(){
        driver.findElement(By.name("claim_number")).sendKeys("CLM-0093-EB-05-12-2023-Test");

    }

    @And("User Click Claim Check Button")
    public void user_verify_data_claim(){
        driver.findElement(By.id("button-submit")).click();
    }
    @Then("User verify data claim")
    public void user_verify_claim_result(){
        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        try {
//           WebElement success =  wait.until(ExpectedConditions.or(
//                    ExpectedConditions.visibilityOfElementLocated(By.id("dataModalLabel"))
//            ));
            WebElement successFound = driver.findElement(By.id("dataModalLabel"));
            if (successFound.isDisplayed()){
                System.out.println("sukses");

            }else {
                fail("Error: Element with id='dataModalLabel' is not visible and no error popup is displayed within the given time.");
            }

        }catch (TimeoutException e){

            System.out.println("error");
            fail("Error: "+e);

        } finally {
            driver.quit();
        }
    }
}
