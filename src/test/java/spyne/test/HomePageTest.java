package spyne.test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import spyne.page.HomePage;

public class HomePageTest {
        private WebDriver driver;
        private HomePage homePage;

        @BeforeMethod
        public void setUp() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get("https://www.spyne.ai/image-upscaler");
            homePage = new HomePage(driver);
        }

        @Test
        public void testNavigation() {
            String currentUrl = driver.getCurrentUrl();
            Assert.assertEquals(currentUrl, "https://www.spyne.ai/image-upscaler");
        }

        @Test
        public void testFileUpload() {
            homePage.uploadImage("/path/to/valid-image.jpg");
            Assert.assertTrue(homePage.isImagePreviewDisplayed(), "Image preview should be displayed");
        }

        @Test
        public void testInvalidFileUpload() {
            homePage.uploadImage("/path/to/invalid-file.txt");
            // Implement logic to check error message
        }

        @Test
        public void testImageUpscaling() {
            homePage.uploadImage("/path/to/valid-image.jpg");
            // Implement logic to check if upscaling process starts and completes
        }

        @Test
        public void testDownloadFunctionality() {
            homePage.uploadImage("/path/to/valid-image.jpg");
            homePage.clickDownloadButton();
            // Implement logic to verify image download
        }

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }
    }


