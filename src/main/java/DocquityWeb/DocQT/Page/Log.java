package DocquityWeb.DocQT.Page;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

	/**
	 * @author SarabjitSingh
	 *
	 */
	public class Log {
		
		public static ExtentReports extent;
		public static ExtentTest extentLogger; //helps to generate logs in extent test report
		public static ExtentHtmlReporter reporter;
		
		
		public static void info(String message, Logger LOGGER) {
			LOGGER.info(message);
	         extentLogger.log(Status.INFO, message);
	       }
		 
	    public static void warn(String message, Logger LOGGER) {
	    	LOGGER.warn(message);
	        extentLogger.log(Status.WARNING, message);
	       }
	    public static void error(String message, Logger LOGGER) {
	    	LOGGER.error(message);
	    	extentLogger.log(Status.ERROR, message);
	       }

	   public static void fatal(String message, Logger LOGGER) {
		   LOGGER.fatal(message);
		   extentLogger.log(Status.FATAL, message);
	     }
	   public static void debug(String message, Logger LOGGER) {
		   LOGGER.debug(message);
		   extentLogger.log(Status.DEBUG, message);
	     }
	   
	   public static void initialiseExtentReport(Logger LOGGER) {
		   LOGGER.debug("===================      Configuring Extent Report      =========================");
		   // Create Object of ExtentHtmlReporter and provide the path where you want to generate the report 
		   // I used (.) in path where represent the current working directory
		   reporter=new ExtentHtmlReporter("./test-output/newExtentReport.html");
		    
		   // Create object of ExtentReports class- This is main class which will create report
		   extent = new ExtentReports();
		    
		   //attach the reporter which we created in Step 1
		   extent.attachReporter(Log.reporter);
		   extent.setSystemInfo("Project Name", "DocquityWeb Test");
		    
		   //configuration items to change the look and feel
	       //add content, manage tests etc
		   reporter.config().setChartVisibilityOnOpen(true);
		   reporter.config().setDocumentTitle("Extent Report for Docquity Web");
		   reporter.config().setReportName("Test Report");
		   reporter.config().setTestViewChartLocation(ChartLocation.TOP);
		   reporter.config().setTheme(Theme.STANDARD);
		   reporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");   
	   }
	   
	   public static void flushExtent(Logger LOGGER) {
		   LOGGER.info("===================      Flushing Extent Report      =========================");
		   	extent.flush();
	   }
	   
	   public static void afterMethodLogResult(Method method, ITestResult result, WebDriver driver ) throws IOException {
		   if(ITestResult.FAILURE==result.getStatus()) {
				String temp = takeScreenshot(method.getName(), driver);
				Log.extentLogger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
				Log.extentLogger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
			}
			 else if(ITestResult.SUCCESS == result.getStatus()) {
				 Log.extentLogger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
			 }
			 else {
				 Log.extentLogger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
				 Log.extentLogger.skip(result.getThrowable());
			 }
		   
	   	}
	   
	   public static String takeScreenshot(String screenshotName, WebDriver driver) {
			Date date = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyy-hhmmss");
			String strDate = formatter.format(date);
			File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String path= System.getProperty("user.dir")+ screenshotName+strDate+".jpg";
			try {
			Files.copy(srcFile , new File(path));
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			return path;
		}
	
	}

