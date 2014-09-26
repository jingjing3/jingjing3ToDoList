package com.jliang3.todo;
  

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import java.util.Properties;
import java.util.Date;  
import java.util.Properties;  
  
 
public class E_mailActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.e_mail_list);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.e_mail, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public class MailSenderInfo  
	{  
	      
	    private String mailServerHost;    
	    private String mailServerPort = "25";    
	     
	    private String fromAddress;  
	    private String toAddress;  
	    private String subject;  
	    private String content;  
	        
	    private String[] attachFileNames;  
	            
	    public Properties getProperties(){      
	    	Properties p = new Properties();     
	        p.put("mail.smtp.host", this.mailServerHost);     
	        p.put("mail.smtp.port", this.mailServerPort);   
	         
	       return p;    
	     }  
	    public String getMailServerHost()  
	    {  
	        return mailServerHost;  
	    }  
	    public void setMailServerHost(String mailServerHost)  
	    {  
	        this.mailServerHost = mailServerHost;  
	    }  
	    public String getMailServerPort()  
	    {  
	        return mailServerPort;  
	    }  
	    public void setMailServerPort(String mailServerPort)  
	    {  
	        this.mailServerPort = mailServerPort;  
	    }  
	     
	    public String getFromAddress()  
	    {  
	        return fromAddress;  
	    }  
	    public void setFromAddress(String fromAddress)  
	    {  
	        this.fromAddress = fromAddress;  
	    }  
	    public String getToAddress()  
	    {  
	        return toAddress;  
	    }  
	    public void setToAddress(String toAddress)  
	    {  
	        this.toAddress = toAddress;  
	    }  
	    public String getSubject()  
	    {  
	        return subject;  
	    }  
	    public void setSubject(String subject)  
	    {  
	        this.subject = subject;  
	    }  
	    public String getContent()  
	    {  
	        return content;  
	    }  
	    public void setContent(String content)  
	    {  
	        this.content = content;  
	    }  
	    public String[] getAttachFileNames()  
	    {  
	        return attachFileNames;  
	    }  
	    public void setAttachFileNames(String[] attachFileNames)  
	    {  
	        this.attachFileNames = attachFileNames;}
	    }
}
