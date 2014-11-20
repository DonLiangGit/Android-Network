package don.com.sp_retrofit;

import java.util.List;

import don.com.pojo.SPData;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by new on 11/11/14.
 */
public class GitHubClient {

    private static final String API_URL= "https://api.github.com";

    // APIs declared Here
    public interface StylePuzzleService {

        // GET method with a return type will be executed Synchronously
        @GET("/repos/{owner}/{repo}/contributors")
        List<SPData> contributors(@Path("owner") String owner, @Path("repo") String repo);

        // Get method with a return type will be executed Asynchronously
        @GET("/repos/{owner}/{repo}/contributors")
        void contributors(@Path("owner") String owner, @Path("repo") String repo, Callback<List<SPData>> callback);
    }

    public static void getContributors(Callback<List<SPData>> callback) {

        // REST Adapter points to Endpoint
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_URL)
                .build();

        // Instance for StylePuzzle API interface
        StylePuzzleService spService = restAdapter.create(StylePuzzleService.class);

        // Fetch and print a list of the contributors to this library
        spService.contributors("square", "retrofit", callback);
    }


}
