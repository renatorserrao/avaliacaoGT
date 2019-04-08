package br.com.cadastro.ws;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

@Component	
public class EstadoWS {

	public String GET(String url) throws Exception{
		
		 try(CloseableHttpClient httpclient = HttpClients.createDefault()) {
           HttpGet httpget = new HttpGet(url);
           System.out.println("Executing request " + httpget.getRequestLine());

           ResponseHandler<String> responseHandler = response -> {
               int status = response.getStatusLine().getStatusCode();
               if (status >= 200 && status < 500) {
                   HttpEntity entity = response.getEntity();
                   return entity != null ? EntityUtils.toString(entity) : null;
               } else {
                   throw new ClientProtocolException("Unexpected response status: " + status);
               }
           };
         
           return httpclient.execute(httpget, responseHandler);
	            
		 }catch (Exception e) {
				throw e;
		 }
	}
	
}
