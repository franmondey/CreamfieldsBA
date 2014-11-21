package com.franmondey.creamfields2014;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.franmondey.creamfields2014.util.UploadHelper;
import com.joanzapata.android.iconify.IconDrawable;
import com.joanzapata.android.iconify.Iconify;
import com.tundem.aboutlibraries.Libs;
import com.tundem.aboutlibraries.ui.LibsActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {
    private List<Dj> dj = new ArrayList<Dj>();

    private Toolbar toolbar;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    private DrawerLayout mDrawerLayout;
    private LinearLayout mDrawerList;

    private RecyclerView mRecyclerView;
    //private ApplicationAdapter mAdapter;
    private MyAdapter mAdapter;
    //private View fabButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //supportRequestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set explode animation when enter and exit the activity
        //Utils.configureWindowEnterExitTransition(getWindow());

        // Handle Toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Handle DrawerLayout
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        // Handle ActionBarDrawerToggle
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close);
        actionBarDrawerToggle.syncState();

        // Handle different Drawer States :D
        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);

        // Handle DrawerList
        mDrawerList = (LinearLayout) findViewById(R.id.drawerList);

        // Init DrawerElems NOTE Just don't do this in a live app :D
        /*final SharedPreferences pref = getSharedPreferences("com.franmondey.applicationreader", 0);
        ((Switch) mDrawerList.findViewById(R.id.drawer_autoupload)).setChecked(pref.getBoolean("autouploadenabled", false));
        ((Switch) mDrawerList.findViewById(R.id.drawer_autoupload)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                SharedPreferences.Editor editor = pref.edit();
                editor.putBoolean("autouploadenabled", isChecked);
                editor.apply();
            }
        });*/

        ((ImageView) mDrawerList.findViewById(R.id.drawer_soundcloud_icon)).setImageDrawable(new IconDrawable(this, Iconify.IconValue.fa_soundcloud).colorRes(R.color.secondary).actionBarSize());

        mDrawerList.findViewById(R.id.drawer_franmondey_soundcloud).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create an intent with context and the Activity class
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://souncloud.com/franmondey/"));
                startActivity(intent);
            }
        });
        ((ImageView) mDrawerList.findViewById(R.id.drawer_twitter_icon)).setImageDrawable(new IconDrawable(this, Iconify.IconValue.fa_twitter).colorRes(R.color.secondary).actionBarSize());

        mDrawerList.findViewById(R.id.drawer_franmondey_twitter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create an intent with context and the Activity class
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://twitter.com/franmondey/"));
                startActivity(intent);
            }
        });
        ((ImageView) mDrawerList.findViewById(R.id.drawer_opensource_icon)).setImageDrawable(new IconDrawable(this, Iconify.IconValue.fa_github).colorRes(R.color.secondary).actionBarSize());


        mDrawerList.findViewById(R.id.drawer_opensource).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create an intent with context and the Activity class
                Intent i = new Intent(getApplicationContext(), LibsActivity.class);
                //Pass the fields of your application to the lib so it can find all external lib information
                i.putExtra(Libs.BUNDLE_FIELDS, Libs.toStringArray(R.string.class.getFields()));

                //Display the library version (OPTIONAL)
                i.putExtra(Libs.BUNDLE_VERSION, false);
                //Display the library license (OPTIONAL
                i.putExtra(Libs.BUNDLE_LICENSE, true);

                //Set a title (OPTIONAL)
                i.putExtra(Libs.BUNDLE_TITLE, getString(R.string.drawer_opensource));

                //Pass your theme (OPTIONAL)
                i.putExtra(Libs.BUNDLE_THEME, R.style.AboutTheme);

                //start the activity
                startActivity(i);
            }
        });
        ((ImageView) mDrawerList.findViewById(R.id.drawer_opensource_icon)).setImageDrawable(new IconDrawable(this, Iconify.IconValue.fa_github).colorRes(R.color.secondary).actionBarSize());

        // Fab Button
        //fabButton = findViewById(R.id.fab_button);
        //fabButton.setOnClickListener(fabClickListener);
        //Utils.configureFab(fabButton);

        mRecyclerView = (RecyclerView) findViewById(R.id.list);

        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //mAdapter = new ApplicationAdapter(new ArrayList<Dj>(), R.layout.row_application, MainActivity.this);
        mAdapter = new MyAdapter(djNames,djTimes,this);

        List<SimpleSectionedRecyclerViewAdapter.Section> sections =
                new ArrayList<SimpleSectionedRecyclerViewAdapter.Section>();

        //Sections
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(0,"Main Stage"));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(9,"Cream Arena"));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(17,"Arena 1"));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(27,"Enter"));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(37,"Cocoon Arena"));

        //Add your adapter to the sectionAdapter
        SimpleSectionedRecyclerViewAdapter.Section[] dummy = new SimpleSectionedRecyclerViewAdapter.Section[sections.size()];
        SimpleSectionedRecyclerViewAdapter mSectionedAdapter = new
                SimpleSectionedRecyclerViewAdapter(this,R.layout.section,R.id.section_text,mAdapter);
        mSectionedAdapter.setSections(sections.toArray(dummy));
        mRecyclerView.setAdapter(mSectionedAdapter);


        //new InitializeDjsTask().execute();
    }


    View.OnClickListener fabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            UploadHelper.getInstance(MainActivity.this, dj).uploadAll();
        }
    };


    //public void animateActivity(Dj dj, View appIcon) {
     //   Intent i = new Intent(this, DetailActivity.class);
        /*i.putExtra("appInfo", dj.getComponentName());
*/
    //    ActivityOptionsCompat transitionActivityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(this, Pair.create(fabButton, "fab"), Pair.create(appIcon, "appIcon"));
    //    startActivity(i, transitionActivityOptions.toBundle());
    //}


/*    private class InitializeDjsTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            MainActivity.this.setProgressBarIndeterminate(true);
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            //Query the applications
            //final Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
            //mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

            //Clean up ail
            //applicationList.clear();

            //List<ResolveInfo> ril = getPackageManager().queryIntentActivities(mainIntent, 0);
            //for (ResolveInfo ri : ril) {
            //    applicationList.add(new AppInfo(MainActivity.this, ri));
            //}
            //Collections.sort(applicationList);

/*

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            //MainActivity.this.setProgressBarIndeterminate(false);
            mAdapter.setDj(dj);

            Animation fadeIn = AnimationUtils.loadAnimation(MainActivity.this, android.R.anim.slide_in_left);
            fadeIn.setDuration(250);
            LayoutAnimationController layoutAnimationController = new LayoutAnimationController(fadeIn);
            mRecyclerView.setLayoutAnimation(layoutAnimationController);
            mRecyclerView.startLayoutAnimation();

            super.onPostExecute(result);
        }
    }*/

    private String[] djNames = {
            "Rama",
            "Catnapp",
            "Leandro Fresco & Gustavo Lamas",
            "Silver City",
            "Hercules & Love Affair",
            "Franco Cinelli & Deep Mariano",
            "David Guetta",
            "Martin Garrix",
            "Dimitri Vegas & Like Mike",


            "Guille Quero",
            "Deep Mariano",
            "Felipe Venegas",
            "Hernan Cattaneo",
            "The Martinez Brothers",
            "Tale of Us",
            "Solomun",
            "Deep Dish",


            "Santiago Martinez",
            "HIIO",
            "Jay West",
            "Facu Carri",
            "Zuker",
            "Otto Knows",
            "R3HAB",
            "Tommy Trash",
            "Fedde Le Grand",
            "Arty",


            "Jorge Savoretti",
            "Miguel Silver",
            "Brian Gros",
            "Franco Cinelli",
            "Barem",
            "Dubfire",
            "Maya Jane Coles",
            "Maetrik",
            "Gaiser",
            "Richie Hawtin",


            "Londonground",
            "Luis Nieva",
            "Ernesto Ferreyra",
            "Julian Jeweil",
            "Ilario Alicante",
            "Guy Gerber",
            "Art Department",
            "Sven Vath",
            "Mathias Kaden",
    };

    private String[] djTimes = {
            "16:00 - 18:00",
            "18:00 - 18:30",
            "18:45 - 19:30",
            "19:45 - 20:45",
            "21:00 - 22:00",
            "22:15 - 23:45",
            "00:15 - 02:15",
            "02:45 - 04:15",
            "04:45 - 06:00",


            "16:00 - 17:30",
            "17:30 - 19:00",
            "19:00 - 20:30",
            "20:30 - 22:30",
            "22:30 - 00:30",
            "00:30 - 02:15",
            "02:15 - 04:00",
            "04:15 - 06:00",


            "16:00 - 17:00",
            "17:00 - 18:00",
            "18:00 - 19:00",
            "19:00 - 20:00",
            "20:00 - 21:00",
            "21:00 - 22:45",
            "22:45 - 00:15",
            "00:15 - 02:15",
            "02:15 - 04:15",
            "04:15 - 06:00",


            "16:00 - 17:15",
            "17:15 - 18:30",
            "18:30 - 19:30",
            "19:30 - 20:30",
            "20:30 - 22:00",
            "22:00 - 00:00",
            "00:00 - 01:30",
            "01:30 - 03:00",
            "03:00 - 04:00",
            "04:00 - 06:00",


            "16:00 - 17:15",
            "17:15 - 18:45",
            "18:45 - 20:00",
            "20:00 - 21:30",
            "21:30 - 23:00",
            "23:00 - 00:30",
            "00:30 - 02:30",
            "02:30 - 04:30",
            "04:30 - 06:00",
    };
}
