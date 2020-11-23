package com.google.firebase.quickstart.database.java;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.quickstart.database.R;

public class A_MapActivity extends AppCompatActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_a_map, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int i = item.getItemId();
        if (i == R.id.action_logout) {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(this, SignInActivity.class));
            finish();
            return true;
        }else if(i == R.id.action_post) {
            startActivity(new Intent(this, A_MainActivity.class));
            finish();
            return true;
        }else {
            return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Seoul and move the camera

        LatLng office1 = new LatLng(37.447312, 126.658367);
        LatLng office2 = new LatLng(37.448442, 126.657112);
        LatLng office3 = new LatLng(37.449030, 126.657368);
        MarkerOptions markerOptions1 = new MarkerOptions();
        markerOptions1.position(office1);
        markerOptions1.title("IT지원실");
        markerOptions1.snippet("1호관 108호");
        mMap.addMarker(markerOptions1);
        MarkerOptions markerOptions2 = new MarkerOptions();
        markerOptions2.position(office2);
        markerOptions2.title("공용PC운영실");
        markerOptions2.snippet("5호관 408호");
        mMap.addMarker(markerOptions2);
        MarkerOptions markerOptions3 = new MarkerOptions();
        markerOptions3.position(office3);
        markerOptions3.title("전산정보원");
        markerOptions3.snippet("7호관 409호");
        mMap.addMarker(markerOptions3);

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(office1, 16.0f));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14));


    }
}
