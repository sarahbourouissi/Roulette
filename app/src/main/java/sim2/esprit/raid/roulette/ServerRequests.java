package sim2.esprit.raid.roulette;

/**
 * Created by Mohamed Raid Raddaou on 02-Jun-16.
 */

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

import java.util.ArrayList;



//a class to send requests to php files
public class ServerRequests {
    ProgressDialog progressDialog;

    //connection setttings
    public static final int CONNECTION_TIMEOUT = 1000 * 15;
    public static final String SERVER_ADDRESS = "http://raidraidraid.net23.net/";

    public ServerRequests(Context context) {
        //prepare the progress dialog
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(false);
        progressDialog.setTitle("Processing...");
        progressDialog.setMessage("Please wait...");
    }


    public void updateUserDataInBackground(int r, GetUserCallback userCallBack) {
        progressDialog.show();
        new updateUserDataAsyncTask(r, userCallBack).execute();
    }


    //update user's informations
    public class updateUserDataAsyncTask extends AsyncTask<Void, Void, Void> {
        int r;
        GetUserCallback userCallBack;

        public updateUserDataAsyncTask(int r, GetUserCallback userCallBack) {
            this.r = r;
            this.userCallBack = userCallBack;
        }

        @Override
        protected Void doInBackground(Void... params) {
            ArrayList<NameValuePair> dataToSend = new ArrayList<>();

            dataToSend.add(new BasicNameValuePair("number", r+""));
//            dataToSend.add(new BasicNameValuePair("Password", user.getPassword()));
//            dataToSend.add(new BasicNameValuePair("FirstName", user.getFirstName()));
//            dataToSend.add(new BasicNameValuePair("LastName", user.getLastName()));
//            dataToSend.add(new BasicNameValuePair("Email", user.getEmail()));
//            dataToSend.add(new BasicNameValuePair("Tel", user.getTel()));
//            dataToSend.add(new BasicNameValuePair("Country", user.getCountry()));

            HttpParams httpRequestParams = getHttpRequestParams();

            HttpClient client = new DefaultHttpClient(httpRequestParams);
         //   HttpPost post = new HttpPost(SERVER_ADDRESS
           //         +"addNumber.php");
            HttpPost post = new HttpPost("http://raidraidraid.net23.net/addNumber.php");

            try {
                post.setEntity(new UrlEncodedFormEntity(dataToSend));
                client.execute(post);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;
        }

        private HttpParams getHttpRequestParams() {
            HttpParams httpRequestParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpRequestParams,
                    CONNECTION_TIMEOUT);
            HttpConnectionParams.setSoTimeout(httpRequestParams,
                    CONNECTION_TIMEOUT);
            return httpRequestParams;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            progressDialog.dismiss();
            userCallBack.done(r);
        }
    }


}