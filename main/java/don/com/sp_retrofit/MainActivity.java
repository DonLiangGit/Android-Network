package don.com.sp_retrofit;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;

import java.util.List;

import don.com.adapter.RetroAdapter;
import don.com.pojo.SPData;
import don.com.sp_fragment.infoFragment;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class MainActivity extends Activity {

    ListView mListView;
    ActionBar bar;
    ProgressBar mProgressbar;

    Callback<List<SPData>> callback = new Callback<List<SPData>>() {
        @Override
        public void success(List<SPData> contributors, Response response) {
            RetroAdapter adapter = new RetroAdapter(
                    getApplicationContext(),
                    R.layout.retro_listitem,
                    contributors);
            mListView.setAdapter(adapter);
            mProgressbar.setVisibility(View.GONE);
        }

        @Override
        public void failure(RetrofitError error) {
            Log.d("RetrofitError", error.getMessage());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        initUIthread();
        mListView = (ListView)findViewById(R.id.mlistview);
        GitHubClient.getContributors(callback);
    }

    public void initUIthread() {

        bar = getActionBar();
        bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#DA4241")));

        mProgressbar = (ProgressBar)findViewById(R.id.pb);
    }

    public void showInfoDialog() {
        infoFragment editNameDialog = new infoFragment();
        editNameDialog.show(getFragmentManager(), "EditNameDialog");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_info) {
            showInfoDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//    }
}
