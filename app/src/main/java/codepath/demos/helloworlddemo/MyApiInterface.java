package codepath.demos.helloworlddemo;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface MyApiInterface {
    /*@GET(Constants.PHONE_NUMBER_API+"/{mobile}")*/
    @GET("CallingApp/Server?")
    Call<ResponseClass> getPhoneNumber(@Query("mobile") String phoneNumber);
}
