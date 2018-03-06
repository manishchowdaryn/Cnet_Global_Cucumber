package listener;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public enum Screenshot {
    INSTANCE;
    private String screenshotPath;
   
    
    /*Date date = new Date() ;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;*/
    //dateFormat.format(date)
    
    Date dNow = new Date( );
    SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	
    
    
	Screenshot() {
			this.screenshotPath = "FailedTestsScreenshots" + File.separator + "Run_" + ft.format(dNow) + File.separator
	                + "failure.jpg";

		}

	public String getScreenshotPath() {
		return screenshotPath;
	}

	public void setScreenshotPath(String screenshotPath) {
		this.screenshotPath = screenshotPath;
	}


    
}
