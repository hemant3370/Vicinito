package hemant3370.vicinito.com.vicinito.Retrofit.Services;




import java.util.List;

import hemant3370.vicinito.com.vicinito.Models.Stream.ItemDetail.ItemDetail;
import hemant3370.vicinito.com.vicinito.Models.Stream.StreamResponse;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by rahulkumarlohra on 18/06/16.
 */
public interface ApiInterface {

    //OTP Login with Phone
//    @POST("/api/login")
//    Call<LoginResponse> login(@Body LoginInput modal);
//
//    @POST("/api/register")
//    Call<LoginResponse> register(@Body RegisterInput modal);
//
//
    @Headers("Content-Type: application/json")
    @GET("/feed/getStream/")
    Call<StreamResponse> getFeed();

    @Headers("Content-Type: application/json")
    @GET("/view/content/{id}")
    Call<ItemDetail> getFeedItem(@Path("id") String id);
//
//
//
//    @Headers("Content-Type: application/json")
//    @GET("/api/gallery")
//    Call<GallaryResponse> getGallary(@Header(Constants.AUTHORIZATION) String authorization);
//
//    @Headers("Content-Type: application/json")
//    @GET("/api/match")
//    Call<MatchResponse> getMatches(@Header(Constants.AUTHORIZATION) String authorization);
//
//    @POST("/api/user")
//    Call<BasicResponse> setBasicProfile(@Header(Constants.AUTHORIZATION) String authorization, @Body UserInput modal);
//
//    @POST("/api/users/{user}/contact")
//    Call<BasicResponse> setContactDetails(@Header(Constants.AUTHORIZATION) String authorization, @Path("user") String id, @Body ContactInput modal);
//
//    @Headers("Content-Type: application/json")
//    @GET("/api/users/{user}/contact")
//    Call<ContactResponse> getContactData(@Header(Constants.AUTHORIZATION) String authorization, @Path("user") String id);
//
//
//
//    @Headers("Content-Type: application/json")
//    @GET("/api/users/{user}/desire")
//    Call<DesiredResponse> getDesiredData(@Header(Constants.AUTHORIZATION) String authorization, @Path("user") String id);
//
//    @Multipart
//    @POST("/api/avatar")
//    Call<AvatarRespaonse> uploadAvatar(@Header(Constants.AUTHORIZATION) String authorization,
//                                       @Part("description") RequestBody description,
//                                       @Part MultipartBody.Part file);



}
