package codepath.demos.helloworlddemo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class RetrofitClass {
    private static MyApiInterface myApiInterface ;

    private static RetrofitClass instance = null;
    private RetrofitClass(){

    }
   public synchronized static MyApiInterface getInstance(){
        if (instance==null) {
            Gson gson = new GsonBuilder()
                    .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                    .create();
            Retrofit retrofit;
            retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.PHONE_NUMBER_API)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
            myApiInterface = retrofit.create(MyApiInterface.class);
            return myApiInterface;
        }else{
            return myApiInterface;
        }
    }
public MyApiInterface getMyApiInterface(){
    return myApiInterface;
}

}
