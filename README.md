**QA Coding Challenge:
Exercise 2 - WEB FE AUTOMATION**

**The task:**
Please, write the automated tests to cover the requirement below: 
DEMO ONLINE SHOP: https://www.demoblaze.com/index.html
- Customer navigation through product categories: Phones, Laptops and Monitors
- Navigate to "Laptop" → "Sony vaio i5" and click on "Add to cart". Accept pop up confirmation.
- Navigate to "Laptop" → "Dell i7 8gb" and click on "Add to cart". 
- Accept pop up confirmation.
- Navigate to "Cart" → Delete "Dell i7 8gb" from cart.
- Click on "Place order".
- Fill in all web form fields.
- Click on "Purchase"
- Capture and log purchase Id and Amount.
- Click on "Ok“

Exercise instructions are used as a guidline for automation steps. One of the test cases is using all steps to run E2E checkout flow.

**Selected toolset:**

Java + Selenium + Cucumber (Maven Project)
Design pattern - POM (Selenium PageFactory class)

**Requirements:**

Google Chrome v102 (chromedriver.exe is in the code repository)
Java 8+
Maven
Intellij IDEA

**How to start tests:**

1. Clone the project
2. Open the project with Intellij IDEA
3. Build the project (CTRL+F9)
4. Open Scenario1.feature right click on any scenario outline/right click on the top of the page if you want to run the whole feature file > Run **OR** right click on TestRunner.java > Run

**How to check test results:**

- Passed/Failed/Skipped steps and logs are visible in "Run" section in Intellij
- HTML Report from the latests run is stored in target/HtmlReports/report.html 
- JSON Report from the latest run is stored in targer/JSONReports/report.json
- JUNIT Report from the latest run is stored in targer/JUnitReports/report.xml
- Screenshots with timestamps are stored in the project folder with name format "screenShot" + "MM.DD.YYYY " + "HH.MM.SS : a" + ".png"
