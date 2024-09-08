package spyne.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

        private By uploadButton = By.id("uploadButton"); // Adjust according to actual ID
        private By imagePreview = By.id("imagePreview"); // Adjust according to actual ID
        private By downloadButton = By.id("downloadButton"); // Adjust according to actual ID

        public HomePage(WebDriver driver) {
            super(driver);
        }

        public void uploadImage(String filePath) {
            WebElement uploadElem = driver.findElement(uploadButton);
            uploadElem.sendKeys(filePath);
        }

        public boolean isImagePreviewDisplayed() {
            WebElement previewElem = driver.findElement(imagePreview);
            return previewElem.isDisplayed();
        }

        public void clickDownloadButton() {
            WebElement downloadElem = driver.findElement(downloadButton);
            downloadElem.click();
        }
    }


