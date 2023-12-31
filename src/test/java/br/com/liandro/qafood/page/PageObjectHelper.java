package br.com.liandro.qafood.page;

import br.com.liandro.qafood.utils.enuns.SwipeDirection;
import br.com.liandro.qafood.utils.DeviceDimensions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;

public class PageObjectHelper extends PageObjectFactory {

    public static int value = 0;

    DeviceDimensions deviceDimensions = new DeviceDimensions();

    public Integer getCountTest() {
        return value = value + 1;
    }

    public PageObjectHelper(AppiumDriver driver) {
        super(driver);
    }

    public Platform getPlatform() {
        return driver.getCapabilities().getPlatformName();
    }

    protected String getPlatformNameString() {
        return driver.getCapabilities().getPlatformName().toString();
    }

    protected void takeScreenshot(String step) throws IOException {
        File evidence = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String stepNameToScreenshot = step
                .toLowerCase()
                .replace(" ", "_");
        FileUtils.moveFile(evidence,
                new File("target/screenshots/" + getPlatformNameString() + "/" + getCountTest() + "_" + getPlatformNameString() + "__" + stepNameToScreenshot + ".jpg"));
    }

    private final PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

    @SuppressWarnings("SameParameterValue")
    protected void swipe(SwipeDirection direction) {
        if (Platform.ANDROID.equals(getPlatform())) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        Sequence dragNDrop = new Sequence(finger, 1);
        int startX, startY, endX, endY;
        switch (direction) {
            case SWIPE_RIGHT:
                startX = deviceDimensions.getMiddleWidth();
                startY = deviceDimensions.getMiddleHeight();
                endX = deviceDimensions.getInitialWidth();
                endY = deviceDimensions.getMiddleHeight();
                break;
            case SWIPE_LEFT:
                startX = deviceDimensions.getInitialWidth();
                startY = deviceDimensions.getMiddleHeight();
                endX = deviceDimensions.getMiddleWidth();
                endY = deviceDimensions.getMiddleHeight();
                break;
            case SWIPE_DOWN:
                startX = deviceDimensions.getMiddleWidth();
                startY = deviceDimensions.getMiddleHeight();
                endX = deviceDimensions.getMiddleWidth();
                endY = deviceDimensions.getInitialHeight();
                break;
            case SWIPE_UP:
                startX = deviceDimensions.getMiddleWidth();
                startY = deviceDimensions.getInitialHeight();
                endX = deviceDimensions.getMiddleWidth();
                endY = deviceDimensions.getMiddleHeight();
                break;
            default:
                throw new IllegalArgumentException("Invalid swipe direction: " + direction);
        }
        dragNDrop.addAction(finger.createPointerMove(Duration.ofSeconds(0),
                PointerInput.Origin.viewport(), startX, startY));
        dragNDrop.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        dragNDrop.addAction(finger.createPointerMove(Duration.ofMillis(700),
                PointerInput.Origin.viewport(), endX, endY));
        dragNDrop.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(dragNDrop));
    }

    public void swipeToElementAndroid(String elementText) {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator
                ("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\"" + elementText + "\").instance(0))"));
    }

    @SuppressWarnings({"rawtypes", "unchecked", "JSUnresolvedReference", "UnnecessaryLabelJS"})
    public void swipeToElementIos(WebElement element) {
        HashMap scrollObjects = new HashMap();
        scrollObjects.put("element", element);
        scrollObjects.put("direction", "up");
        driver.executeScript("mobile: swipe", scrollObjects);
    }

    public void waitVisibilityOfElement(WebElement element) {
        waitDriver.until(ExpectedConditions.visibilityOf(element));
    }

    public void checkElementIsVisible(WebElement element) {
        if (Platform.ANDROID.equals(getPlatform())) {
            waitVisibilityOfElement(element);
        }
        element.isDisplayed();
    }

    protected void getElementClickable(WebElement element) {
        waitDriver.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitElementToBeClickable(WebElement element) {
        waitDriver.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void clickOnElement(WebElement element) {
        if (Platform.ANDROID.equals(getPlatform())) {
            waitElementToBeClickable(element);
            getElementClickable(element);
        }
        element.click();
    }

    public void elementExistsAndIsDisplay(WebElement element) {
        try {
            waitVisibilityOfElement(element);
            element.isDisplayed();
        } catch (NullPointerException | NoSuchElementException | StaleElementReferenceException ex) {
        }
    }

    public int randomNumber(int maxNumber) {
        Random random = new Random();
        return random.nextInt(maxNumber);
    }

}
