package com.rytedesigns.portfolioapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Button spotifyStreamerButton = (Button) findViewById(R.id.spotify_streamer_button);

        spotifyStreamerButton.setOnClickListener(LauncherOnClickListener);

        Button scoresButton = (Button) findViewById(R.id.scores_button);

        scoresButton.setOnClickListener(LauncherOnClickListener);

        Button libraryButton = (Button) findViewById(R.id.library_button);

        libraryButton.setOnClickListener(LauncherOnClickListener);

        Button buildItBiggerButton = (Button) findViewById(R.id.build_it_bigger_button);

        buildItBiggerButton.setOnClickListener(LauncherOnClickListener);

        Button xyzReaderButton = (Button) findViewById(R.id.xyz_reader_button);

        xyzReaderButton.setOnClickListener(LauncherOnClickListener);

        Button capstoneButton = (Button) findViewById(R.id.capstone_button);

        capstoneButton.setOnClickListener(LauncherOnClickListener);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void launchApplication(String packageName, String applicatlionName)
    {
        Intent applicationLaunchIntent = getPackageManager().getLaunchIntentForPackage(packageName);

        if (applicationLaunchIntent != null)
        {
            startActivity(applicationLaunchIntent);
        }
        else
        {
            Toast.makeText(this, "This button will launch my " + applicatlionName + " App!", Toast.LENGTH_LONG).show();
        }
    }

    View.OnClickListener LauncherOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view)
        {
            String packageName = null;

            String applicationName = "";

            switch (view.getId())
            {

                case R.id.spotify_streamer_button:

                    packageName = "com.rytedesigns.spotifyStreamer";

                    applicationName = "Spotify Streamer";

                    break;

                case R.id.scores_button:

                    packageName = "com.rytedesigns.scores";

                    applicationName = "Scores";

                    break;

                case R.id.library_button:

                    packageName = "com.rytedesigns.library";

                    applicationName = "Library";

                    break;

                case R.id.build_it_bigger_button:

                    packageName = "com.rytedesigns.buildItBigger";

                    applicationName = "Build It Bigger";

                    break;

                case R.id.xyz_reader_button:

                    packageName = "com.rytedesigns.xyzReader";

                    applicationName = "XYZ Reader";

                    break;

                case R.id.capstone_button:

                    packageName = "com.rytedesigns.capstone";

                    applicationName = "Capstone";

                    break;
            }

            if (packageName != null)
            {
                launchApplication(packageName, applicationName);
            }
        }
    };
}
