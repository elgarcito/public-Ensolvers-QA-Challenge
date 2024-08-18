# QA Challenge

## Objective
The purpose of this challenge is to test your QA skills in a practical scenario. At [https://qa-challenge.ensolvers.com](https://qa-challenge.ensolvers.com), you will find a very simple to-do app which allows you to manage to-do items and group them in folders. You can log in as a user with "user" both as a username and password.

In this challenge you will need to:

- **Task 1**: Build a Use Case list specifying, with the most formal description possible, the different flows to be tested so they can be used as a reference for testing the app by you or any other QA team member.
- **Task 2**: Test the app end-to-end and report any bug or UX issue that you consider needs to be solved. Again, in this case, you must be as formal as possible when describing each one using the tools, templates, and/or artifacts that you think suit better for this task.
- **Task 3**: Write a suite of automated tests using Selenium, Cypress, or any other tool/framework you know to automatically check if all the flows defined in Task 1 are fulfilled as expected.

## Deliverables
- For **Task 1**, a document describing each flow.
- For **Task 2**, if applicable, a description in detail of each bug or UX issue.
- For **Task 3**, a suite of automated tests that implements the automatic tests.


# Resolution
To understand each test you should use the test Excel file: test Description. There you will have all the test and
it explanation.

To solve this challenge we are going to use Carina testing framework. You can find all the test cases, showed in the 
Excel file in the following [folder](src/test/java/com/ensolvers/carina/example).
All the test suites are in the following [folder](src/test/resources/testng_suites)

 Two of the Tests fail in suites but work individually.
I couldn't correct it due to a lack of time, these are:
EditToDoItemTest
DeleteAFolderTest


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

### Test pages creation recommended steps for android and desktop
0. Before all creations, you should change the configuration file according
   to the type of test that you use on Desktop or Mobile
1. First, create in [common folder](src/main/java/com/ensolvers/carina/example/gui/pages/common)
the Abstract page class with the abstract methods that your desktop or android web test is going to use.This class
should extend AbstractPage class of carina. You should name it <ClassName>Base for example HomePageBase
2. Then create the implementation of it in the [desktop](src/main/java/com/ensolvers/carina/example/gui/pages/desktop) folder.
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
5. After you do this you must set an page opening strategy, that mean to set an url or an element in
screen that is needed to check if the page is opened. For example
```
    @FindBy(xpath = "")
    private ExtendedWebElement invalidPageMessage;
    public InvalidPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(invalidPageMessage);
    }
```
In this example this page that is the result of an action in other class,
that delivers us this InvalidPage. This page has an ExtendedWebElement invalidPageMessage that
is going to be a marker to know if the page has been loaded.First we set an opening strategy
with `setPageOpeningStrategy(PageOpeningStrategy.)` and then set the marker with `setUiLoadedMarker(invalidPageMessage)`

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
2. When creating test the main idea is to have an action and then an assertion
to check if every step is done properly
3. When we test WEB we must use `.open()` and also then we check it when
`.isPageOpened()`
4. When we test API we should test `.expectResponseStatus(HttpResponseStatusType.OK_200)` with 
this we check the proper response status then, `.callAPI()` to call the API. 
Finally we use `.validateResponseAgainstSchema("path")`
5. When calling a suite in `POM.xml` we should change `<suite>suit_xml_name</suite>`
6. If we want to add TEST data we use the following `R.TESTDATA.get("propertyName")`.
We must previously have created the `_testdata.properties` in the resources folder, this file
should be written in the following way, as example:
```
user:standard_user
password:secret_sauce
```
So if we want to use it in the test, we should write, as example:
``` 
loginPage.typeUsername(R.TESTDATA.get("user"));
loginPage.typePassword(R.TESTDATA.get("password"));
```
Before running Tests remember to run [mvn lifecycle](https://maven.apache.org/guides/introduction/introduction-to-the-lifecycle) or only 
``` 
mvn package -D skipTests 
```



### Author
[@Edgar Aguirre](https://github.com/elgarcito)

For educative purpose.
