# Carina Testing basic configuration
This repository brings you the basic structures and latest
dependencies to use a Carina testing framework.
So far, It doesn't contain the configuration to use:
* myBatis
* TestRail
* Amazon
* Azure
* Crypto
* Dynamic proxy
* Jenkins

For these options, the configuration file has the ones that [Carina Demo](https://github.com/zebrunner/carina-demo) has.

With this structure, dependencies, and plugins, you can test the following kinds of tests:
* Desktop web test
* Mobile with android
* API
### Getting started
To run this project, you will need at least version 21 of Java.
First, clone this repository in a folder of your PC.
You have to put the following command in a terminal:

```bash
  git clone this-repo-url
```
Once copied, you must run the following command in the console:
```bash
  mvn clean install -D skipTests
```

### Web and API Test _config.properties configuration
Steps to create a web test:

1. Fill the [configuration file](src/main/resources/_config.properties) with the following [code](https://drive.google.com/file/d/10gQsSpApME1hvKOj14vjLylRovnpL36l/view?usp=drive_link)
2. Fill the `url= ` and `api.url= ` with the `http or https` url of the page or API
that you want to test.


### Android _config.properties configuration
1. Fill the [configuration file](src/main/resources/_config.properties) with the following [code](https://drive.google.com/file/d/1_uylMFI41w12Iwh9J25lLNXaF6VBvMOs/view?usp=drive_link)
2. You probably should set your following capabilities according to the emulator or device that you are using. You must replace
<> with your info (without using <>).

```
capabilities.automationName=UiAutomator2
capabilities.deviceName=<Your device name>
capabilities.platformVersion=<The emulator or device android version>
capabilities.udid=<The emulator or device android id>
```
3. If you use the global url for this android test, uncomment it in global configuration `#url=` and add your url.

## Start testing
### Previous configuration
### Web testing and API

1. First, start the selenium standalone. You must have previously downloaded the [standalone](https://selenium-release.storage.googleapis.com/index.html?path=3.9/)(last version selenium-server-standalone-3.9.1.jar)
and the [Chromedriver](https://googlechromelabs.github.io/chrome-for-testing/) (download your Chrome version, you can check it in help using your browser) 
and put them in the same folder.
2. Once done, initiate a cmd window and move to the folder where you save both files. 
3. Run the following command
```
java -Dwebdriver.chrome.driver=./chromedriver.exe -jar selenium-server-standalone-3.9.1.jar
```
4. This should start the selenium standalone server on port 4444
5. You must leave this cmd console open while you are testing

### Android Testing
1. Install [android studio](https://developer.android.com/studio)
2. Once installed, go inside android studio and settings->Android SDK then click Sdk Tools
3. Select Android SDK Command-line Tools(latest) and android SDK Platform-Tools (if it is not installed). Then apply
4. Configure your environment variable ANDROID_HOME. Create your user variable ANDROID_HOME and path:
```
C:\Users\YourUser\AppData\Local\Android\Sdk
```
5. Then configure your environment variable go to a path and add at the end:
```
%ANDROID_HOME%\tools
%ANDROID_HOME%\platform-tools
C:\Users\edgar\AppData\Local\Android\Sdk\platform-tools
```
6. Click accept
7. Install [node js](https://nodejs.org/en/download/current) latest version

8. Install [appium doctor](https://www.npmjs.com/package/@appium/doctor) using, run this on your cmd
```bash
npm install @appium/doctor -g
```
9. Run appium doctor, run this on your cmd 
```bash
appium-doctor
```
Check only for needed configuration not optional
10. Install [appium](https://appium.io/docs/en/latest/quickstart/install/), run this on your cmd
```bash
npm i -g appium
```
11. Close the console and install the UiAutomator2 driver, run this on your cmd
```bash
appium driver install uiautomator2
```
12. Install [appium inspector](https://github.com/appium/appium-inspector/releases/tag/v2023.12.2)
13. Before start testing only once you must run 
```bash
appium-doctor
```
And leave it open in the background, don't close the console

### Test pages creation recommended steps for android and desktop
1. First, create in [common folder](src/main/java/com/solvd/carina/example/pages/common)
the Abstract page class with the abstract methods that your desktop or android web test is going to use.This class
should extend AbstractPage class of carina. You should name it <ClassName>Base for example HomePageBase
2. Then create the implementation of it in the [desktop](src/main/java/com/solvd/carina/example/pages/desktop) folder.
This class should extend its abstract class — for example, HomePage extends HomePageBase. 
You must use the following annotation over the child class:
```
@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = <ClassName>Base.class)
```
If you are using android
```
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = <ClassName>Base.class)
```
For example for android:
```
@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
```
3. Use protected ExtendedWebElement to save page elements, using the tag over the element created:
```
@FindBy(id,xpath,etc = )
```
For Android, we use xpath, and for desktop any of it. As example
```
    @FindBy(id = "footmenu")
    private FooterMenu footerMenu;
```
4. If we have a method that click on an object, then it creates a new page, we using `initPage(getDriver(),parentBase.class)`
.This mean that we return the Abstract class of the new page **NOT** the implementation. For example, in the HomePage.java
which is an implementation for desktop of the HomePageBase.java abstract class, we override the abstract method
`goToAppPage()`. This method returns us an Abstract AppPageBase Object:
```
    @Override
    public AppPageBase goToAppPage() {
        appButton.click();
        return initPage(getDriver(),AppPageBase.class);
    }
```

### Test creation 
1. All web Test classes should implement IAbstractTest as example
```
public class HelloWorld implements IAbstractTest {}
```
For Android apps also, we should implement and IAndroidUtils (For IOS and android IMobileUtils), as an example for android:
```
public class HelloWorld implements IAbstractTest,IAndroidUtils {}
```
General example
```
public class HelloWorld implements IAbstractTest,IMobileUtils {}
```

### Author
[@Edgar Aguirre](https://github.com/elgarcito)

For educative purpose.