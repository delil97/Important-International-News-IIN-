package com.example.importantnews.Classes;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchData extends AsyncTask<Void, Void, Void> {// it needs 3 parameters
    String data = "";
    String dataParsed = "";
    String singleParsed = "";


    @Override
    protected Void doInBackground(Void... voids) { // background thread

        try {
            URL url = new URL ("https://polisen.se/api/events");// our data will be fetched from this URL

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection (); // the connection
            InputStream inputStream = httpURLConnection.getInputStream (); // we are getting the inputStream from this connection
            BufferedReader bufferedReader = new BufferedReader (new InputStreamReader (inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine ();
                data = data + line; // the lines are being added to this data
            }

            JSONArray JA = new JSONArray (data);
            for (int i =0 ;i<JA.length (); i++){
                //define JSON object
                JSONObject JO = (JSONObject) JA.get (i);

                        singleParsed =  "Event type: " + JO.get("type") + " \n" +
                        "\n" +
                        "Date,type and location: " + JO.get("name") + " \n"+
                        "\n" +
                        "Summary: " + JO.get("summary") + " \n"+
                                "\n___________________________________" +

                "\n";

                        dataParsed = dataParsed + singleParsed; // adds each object into this total data

            }


        } catch (MalformedURLException e) {
            e.printStackTrace ();
        } catch (IOException e) {
            e.printStackTrace ();
        } catch (JSONException e) {
            e.printStackTrace ();
        }


        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) { // UI thread
        super.onPostExecute (aVoid);

        SecondActivity.data.setText (this.dataParsed);
    }
}
