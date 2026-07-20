# Calculator Maven Demo (Tomcat Deployment & JMeter Load Test)

A complete sample Java Web Application built with Maven packaging targeting **Apache Tomcat 10+** (Jakarta Servlet API 6.0), bundled with a web interface, JUnit 5 support, and a JMeter load testing script that generates an interactive HTML performance report.

---

## Project Structure

```text
calculator-maven-demo/
├── pom.xml
├── README.md
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/calculator/
│   │   │       ├── CalculatorServlet.java
│   │   │       └── CalculatorService.java
│   │   └── webapp/
│   │       ├── index.html
│   │       └── WEB-INF/
│   │           └── web.xml
│   └── test/
│       └── java/
│           └── com/example/calculator/
│               └── CalculatorServiceTest.java
└── jmeter/
    └── calculator_load_test.jmx
```

---

## Prerequisites

Ensure the following tools are installed on your machine:
* **Java Development Kit (JDK 17+)**
* **Apache Maven (3.8+)**
* **Apache Tomcat (10.1+)**
* **Apache JMeter (5.5+)**
* **Git**

---

## Implementation & Build Steps

### 1. Run Unit Tests & Build the WAR Artifact
Open your terminal in the root directory (`calculator-maven-demo`) and package the web application using Maven:

```bash
# Run unit tests and package into target/calculator-maven-demo.war
mvn clean package
```

Upon success, Maven creates the artifact:
`target/calculator-maven-demo.war`

---

## Launching on Apache Tomcat

### Step 1: Deploy to Tomcat
Copy the generated WAR file into your Apache Tomcat installation's `webapps` folder:

* **Linux / macOS:**
  ```bash
  cp target/calculator-maven-demo.war /path/to/apache-tomcat-10.x/webapps/
  ```
* **Windows (Command Prompt):**
  ```cmd
  copy target\calculator-maven-demo.war C:\path\to\apache-tomcat-10.x\webapps\
  ```

### Step 2: Start Apache Tomcat
Navigate to Tomcat's `bin` directory and run the startup script:

* **Linux / macOS:**
  ```bash
  cd /path/to/apache-tomcat-10.x/bin
  ./startup.sh
  ```
* **Windows:**
  ```cmd
  cd C:\path\to\apache-tomcat-10.x\bin
  startup.bat
  ```

### Step 3: Access Application Interface
Open your browser and navigate to:
* **UI Interface:** `http://localhost:8080/calculator-maven-demo/`
* **API Endpoint Example:** `http://localhost:8080/calculator-maven-demo/api/calculate?a=10&b=5&op=add`

---

## Load Testing with Apache JMeter

Execute non-GUI load testing against the running Tomcat server and generate a full HTML dashboard:

```bash
# Navigate to the project root
cd calculator-maven-demo

# Run JMeter load test script and generate HTML report
jmeter -n -t jmeter/calculator_load_test.jmx -l jmeter/results.jtl -e -o jmeter/html_report
```

### Viewing Performance Results
Open the generated report in your web browser:
```text
jmeter/html_report/index.html
```

---

## Uploading to GitHub

Initialize git locally and push to your remote GitHub repository:

```bash
git init
git add .
git commit -m "Initial commit of Tomcat Calculator Maven project with JMeter scripts"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/calculator-maven-demo.git
git push -u origin main
```
