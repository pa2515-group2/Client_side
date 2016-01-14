package UI;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.swing.DefaultListModel;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class ServerCode {
	public ServerCode() {
		System.out.println("Executing server code...");
	}
	
	public static String URL_PREFIX = "http://192.168.59.200:8080/v1/";

	
	public int PostData(JSONObject json, String url, String callFun, String headerData) {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		String responseString = null;
		try {
			StringEntity entity;
			entity = new StringEntity(json.toString());
			httpPost.setEntity(entity);
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");
//			if (callFun == "Login")
//				httpPost.setHeader("role", headerData);
			httpPost.setHeader("role", Client.role);
			httpPost.setHeader("token", Client.authToken);
			CloseableHttpResponse response;
			System.out.println("httpPost: "+httpPost.toString());
			response = client.execute(httpPost);
			System.out.println("response: "+response);
//			if (callFun == "Login") {
////				Client.authToken = response.getFirstHeader("token").getValue();
//				Client.authToken = response.toString();			
//				Client.role = headerData;
//			}
			HttpEntity en = response.getEntity();
			responseString = EntityUtils.toString(en, "UTF-8");
			if (callFun == "Login") {
				JSONParser par = new JSONParser();
				JSONObject resp_obj = (JSONObject) par.parse(
						responseString);
				for (Object key : resp_obj.keySet()) {
					String keyStr = (String) key;						
					Object keyvalue = resp_obj.get(keyStr);
					if (keyStr.equals("token")) {
						Client.authToken = keyvalue.toString();		
					}
				}

				Client.role = headerData;
			}
			System.out.println("responseString: "+responseString);
			System.out.println("Response: " + response.getStatusLine().getStatusCode());

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (responseString != "0")
			return 1;

		return 0;
	}
	
	public int PostObj(JSONObject json, String url, File file, String headerData) {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		String responseString = null;
		try {
	
			
			JSONObject obj = new JSONObject();
			obj.put("objname", file.getName());
			obj.put("datetime", "20160112");
			obj.put("description", "x-ray");
			
			StringEntity entity;
			entity = new StringEntity(obj.toString());
			httpPost.setEntity(entity);
			
			httpPost.setHeader("Accept", "application/json");
			httpPost.setHeader("Content-type", "application/json");
//			if (callFun == "Login")
//				httpPost.setHeader("role", headerData);
			httpPost.setHeader("role", Client.role);
			httpPost.setHeader("token", Client.authToken);
			CloseableHttpResponse response;
			System.out.println("httpPost: "+httpPost.toString());
			response = client.execute(httpPost);
			System.out.println("response: "+response);
//			if (callFun == "Login") {
////				Client.authToken = response.getFirstHeader("token").getValue();
//				Client.authToken = response.toString();			
//				Client.role = headerData;
//			}
			HttpEntity en = response.getEntity();
			responseString = EntityUtils.toString(en, "UTF-8");
			
			System.out.println("responseString: "+responseString);
			
			JSONParser par = new JSONParser();
			JSONObject respJson = (JSONObject) par.parse(responseString);
			String storage_url = (String) respJson.get("storage_url");
			String swift_token = (String) respJson.get("auth_token");
			

			HttpClient httpclient = new DefaultHttpClient();
			HttpPut httpPut = new HttpPut(storage_url);
			httpPut.addHeader("X-Auth-Token", swift_token);
//		
			FileEntity fileent = new FileEntity(file);
			httpPut.setEntity(fileent);
	
			
			CloseableHttpResponse swift_response;
			System.out.println("httpPut File: "+httpPut.toString());
			swift_response = client.execute(httpPut);
			System.out.println("response: "+swift_response);

			HttpEntity en_swift = swift_response.getEntity();
			responseString = EntityUtils.toString(en_swift, "UTF-8");
			
			System.out.println("responseString: "+responseString);
			
			System.out.println("Response: " + response.getStatusLine().getStatusCode());

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (responseString != "0")
			return 1;

		return 0;
	}
	
	public String getData(String url) {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		String responseString = null;
		try {
			httpGet.addHeader("token", Client.authToken);
			httpGet.addHeader("role", Client.role);
			CloseableHttpResponse response;
			response = client.execute(httpGet);
			HttpEntity en = response.getEntity();
			responseString = EntityUtils.toString(en, "UTF-8");
			System.out.println(responseString);
			System.out.println("Response: " + response.getStatusLine().getStatusCode());

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return responseString;
	}
	
	public int PutData(JSONObject json, String url, String callFun, String headerData) {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpPut httpPut = new HttpPut(url);
		String responseString = null;
		try {
			StringEntity entity;
			entity = new StringEntity(json.toString());
			httpPut.setEntity(entity);
			

			httpPut.setHeader("Accept", "application/json");
			httpPut.setHeader("Content-type", "application/json");
//			if (callFun == "Login")
//				httpPost.setHeader("role", headerData);
			httpPut.setHeader("role", Client.role);
			httpPut.setHeader("token", Client.authToken);
			CloseableHttpResponse response;
			System.out.println("httpPut: "+httpPut.toString());
			response = client.execute(httpPut);
			System.out.println("response: "+response);
//			if (callFun == "Login") {
////				Client.authToken = response.getFirstHeader("token").getValue();
//				Client.authToken = response.toString();			
//				Client.role = headerData;
//			}
			HttpEntity en = response.getEntity();
			responseString = EntityUtils.toString(en, "UTF-8");
			if (callFun == "Login") {
				JSONParser par = new JSONParser();
				JSONObject resp_obj = (JSONObject) par.parse(
						responseString);
				for (Object key : resp_obj.keySet()) {
					String keyStr = (String) key;						
					Object keyvalue = resp_obj.get(keyStr);
					if (keyStr.equals("token")) {
						Client.authToken = keyvalue.toString();		
					}
				}

				Client.role = headerData;
			}
			System.out.println("responseString: "+responseString);
			System.out.println("Response: " + response.getStatusLine().getStatusCode());

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (responseString != "0")
			return 1;

		return 0;
	}
	
	public String deleteData(String url) {
		CloseableHttpClient client = HttpClients.createDefault();
		HttpDelete httpDelete = new HttpDelete(url);
		String responseString = null;
		try {
			httpDelete.addHeader("token", Client.authToken);
			httpDelete.addHeader("role", Client.role);
			CloseableHttpResponse response;
			response = client.execute(httpDelete);
			HttpEntity en = response.getEntity();
			responseString = EntityUtils.toString(en, "UTF-8");
			System.out.println(responseString);
			System.out.println("Response: " + response.getStatusLine().getStatusCode());

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
		} finally {
			try {
				client.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return responseString;
	}
}