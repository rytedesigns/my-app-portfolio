package com.rytedesigns.portfolioapp;

import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.inject(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void launchApplication(String packageName, String applicationName)
    {
        Intent applicationLaunchIntent = getPackageManager().getLaunchIntentForPackage(packageName);

        if (applicationLaunchIntent != null)
        {
            startActivity(applicationLaunchIntent);
        }
        else
        {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) findViewById(R.id.snackbar_location);

            Snackbar.make(coordinatorLayout, applicationName +
                    getString(R.string.not_installed_snackbar_message), Snackbar.LENGTH_LONG).show();
        }
    }

    @OnClick({R.id.popular_movies_button, R.id.scores_button,
            R.id.library_button, R.id.build_it_bigger_button,
            R.id.xyz_reader_button, R.id.capstone_button})
    public void onClick(View view)
    {
        String packageName = null;

        String applicationName = "";

        switch (view.getId())
        {
            case R.id.popular_movies_button:

                packageName = getString(R.string.popular_movies_package_name);

                applicationName = getString(R.string.popular_movies_app_name);

                break;

            case R.id.scores_button:

                packageName = getString(R.string.scores_package_name);

                applicationName = getString(R.string.scores_app_name);

                break;

            case R.id.library_button:

                packageName = getString(R.string.library_package_name);

                applicationName = getString(R.string.library_app_name);

                break;

            case R.id.build_it_bigger_button:

                packageName = getString(R.string.build_it_bigger_package_name);

                applicationName = getString(R.string.build_it_bigger_app_name);

                break;

            case R.id.xyz_reader_button:

                packageName = getString(R.string.xyz_reader_package_name);

                applicationName = getString(R.string.xyz_reader_app_name);

                break;

            case R.id.capstone_button:

                packageName = getString(R.string.capstone_package_name);

                applicationName = getString(R.string.capstone_app_name);

                break;
        }

        if (packageName != null)
        {
            launchApplication(packageName, applicationName);
        }
    }
}
