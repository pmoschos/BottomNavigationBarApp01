package gr.aueb.cf.bottomnavigationbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import gr.aueb.cf.bottomnavigationbar.Fragments.FavoriteFragment;
import gr.aueb.cf.bottomnavigationbar.Fragments.HomeFragment;
import gr.aueb.cf.bottomnavigationbar.Fragments.PostFragment;
import gr.aueb.cf.bottomnavigationbar.Fragments.ProfileFragment;
import gr.aueb.cf.bottomnavigationbar.Fragments.UploadFragment;

public class MainActivity extends AppCompatActivity {

    private MaterialToolbar toolbar;
    private FrameLayout frameLayout;
    private BottomNavigationView bottomNV;
    private FragmentManager fragmentManager;
    private TextView titleTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        titleTV = findViewById(R.id.titleTV);
        toolbar = findViewById(R.id.toolbar);
        frameLayout = findViewById(R.id.frameLayout);
        bottomNV = findViewById(R.id.bottomNV);

        fragmentManager = getSupportFragmentManager();

        // when app opens then HomeFragment appears to the user
        bottomNV.getMenu().getItem(2).setChecked(true);
        fragmentManager.beginTransaction().replace(R.id.frameLayout,new HomeFragment(),"HomeFragment").commit();
        titleTV.setText("Home");

        bottomNV.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.uploadItem:
                        fragmentManager.beginTransaction().replace(R.id.frameLayout,new UploadFragment(),"UploadFragment").commit();
                        titleTV.setText("Upload");
                        break;
                    case R.id.postItem:
                        fragmentManager.beginTransaction().replace(R.id.frameLayout,new PostFragment(),"PostFragment").commit();
                        titleTV.setText("My Posts");
                        break;
                    case R.id.homeItem:
                        fragmentManager.beginTransaction().replace(R.id.frameLayout,new HomeFragment(),"HomeFragment").commit();
                        titleTV.setText("Home");
                        break;
                    case R.id.favoriteItem:
                        fragmentManager.beginTransaction().replace(R.id.frameLayout,new FavoriteFragment(),"FavoriteFragment").commit();
                        titleTV.setText("Favorite Posts");
                        break;
                    case R.id.profileItem:
                        fragmentManager.beginTransaction().replace(R.id.frameLayout,new ProfileFragment(),"ProfileFragment").commit();
                        titleTV.setText("My Profile");
                        break;
                }
                return true;
            }
        });

    }
}