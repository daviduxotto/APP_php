package dawareestudio.app_php;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import  org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
public class HttpHandler {


     public String post (String posturl)
    {


        try
        {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost htppost = new HttpPost(posturl);
            HttpResponse resp = httpclient.execute(htppost);
            HttpEntity ent = resp.getEntity();
            String text = EntityUtils.toString(ent);
            return text;

        } catch (Exception e)
        {
                return "El servidor no esta encendido "+e;
        }
    }

}
