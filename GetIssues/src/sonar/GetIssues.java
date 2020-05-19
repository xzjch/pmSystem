package sonar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

public class GetIssues {

	
	public static void main(String[] args) {
		
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("login", "admin");
		user.put("password", "admin");
		
		//System.out.println(".");
		StringBuffer cookie = doPost("http://39.106.124.113:9000/api/authentication/login", user);
		String url = "http://39.106.124.113:9000/api/issues/search?componentKeys=pm&s=FILE_LINE&resolved=false&types=CODE_SMELL,BUG,VULNERABILITY&additionalFields=_all";
		String str = doGet(url, cookie.toString());
		System.out.println(str);
		writeFile(str, "../issues.txt");
		
	}
	
	public static String doGet(String url, String cookie) {
		
		InputStream is = null;
		BufferedReader br = null;
		String result = null;
		
		HttpClient httpClient = new HttpClient();
		
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
		
		GetMethod getMethod = new GetMethod(url);
		getMethod.setRequestHeader("cookie", cookie);
		
		getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
		
		getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, true));
		try {
			
			int statusCode = httpClient.executeMethod(getMethod);
			
			if (statusCode != HttpStatus.SC_OK) {
				
				System.err.println("Method faild: " + getMethod.getStatusLine());
			} else {
				
				is = getMethod.getResponseBodyAsStream();
				
				br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

				StringBuffer sbf = new StringBuffer();
				
				String temp = null;
				while ((temp = br.readLine()) != null) {
					sbf.append(temp).append("\r\n");
				}

				result = sbf.toString();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			getMethod.releaseConnection();
		}
		return result;
	}

	public static StringBuffer doPost(String url, Map<String, Object> paramMap) {
		
		StringBuffer tmpcookies = new StringBuffer();
		InputStream is = null;
		BufferedReader br = null;
		String result = null;
		
		
		HttpClient httpClient = new HttpClient();
		
		httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
		
		httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(15000);
		
		PostMethod postMethod = new PostMethod(url);
		
		NameValuePair[] nvp = null;
		
		if (null != paramMap && paramMap.size() > 0) {
			
			nvp = new NameValuePair[paramMap.size()];
			
			Set<Entry<String, Object>> entrySet = paramMap.entrySet();
			
			Iterator<Entry<String, Object>> iterator = entrySet.iterator();

			int index = 0;
			while (iterator.hasNext()) {
				Entry<String, Object> mapEntry = iterator.next();
				
				try {
					nvp[index] = new NameValuePair(mapEntry.getKey(),
							new String(mapEntry.getValue().toString().getBytes("UTF-8"), "UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				index++;
			}
		}
		
		if (null != nvp && nvp.length > 0) {
			
			postMethod.setRequestBody(nvp);

		}
		
		try {
			int statusCode = httpClient.executeMethod(postMethod);
			
			if (statusCode != HttpStatus.SC_OK) {
				System.err.println("Method faild: " + postMethod.getStatusLine());
			}
			Cookie[] cookies = httpClient.getState().getCookies();
			for (Cookie c : cookies) {
				tmpcookies.append(c.toString() + ";");
				System.out.println("cookies = " + c.toString());
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (null != is) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			postMethod.releaseConnection();
		}
		
		return tmpcookies;
	}
	
	public static void writeFile(String json, String FilePath) {
	    
    	try {
    		File file = new File(FilePath);
    
    		// if file doesnt exists, then create it
    		if (!file.exists()) {
    			file.createNewFile();
    		} else {
    			file.delete();
    			file.createNewFile();
    		}
    
    		// true = append file
    		FileWriter fileWritter = new FileWriter(file, false);
    		BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
    		bufferWritter.write(json);
    		bufferWritter.close();
    
    	} catch (IOException e) {
    		e.printStackTrace();
    	}
    }
	

}
