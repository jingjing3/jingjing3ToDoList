package com.jliang3.todo;

	import java.io.BufferedReader;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.IOException;  
import java.io.InputStreamReader;    

import com.jliang3.todo.E_mailActivity.MailSenderInfo;

/** modified the following code based on 
 * http://blog.csdn.net/aassdd_zz/article/details/8204407  2014-10-23
 * 
*/    
	public class Sendmail {  
	 
		
	      private static MailSenderInfo mailInfo;

		public static boolean sendHtmlMail(File file){  
	    	    
			
	            BufferedReader br = null;  
	            StringBuffer sb = null;  
	            try{  
	           
	                  
	                FileInputStream fileInputStream = new FileInputStream(file);  
	                br = new BufferedReader(new InputStreamReader(fileInputStream));  
	                String line = null;  
	                sb = new StringBuffer();  
	                while ((line = br.readLine()) != null) {  
	                    sb.append(line);  
	                }  
	                  
	            }catch(Exception e){  
	                e.printStackTrace();  
	                return false;  
	            }finally{  
	                if(br!=null){  
	                    try  
	                    {  
	                        br.close();  
	                    }  
	                    catch (IOException e)  
	                    {  
	                        e.printStackTrace();  
	                        return false;  
	                    }  
	                }  
	            }  
	              
	           
				mailInfo.setContent(sb.toString());  
	               
	            return true;  
	        } 

}
