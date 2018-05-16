package com.nelsonbenitez.sedesudea;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Locale;

public class MapsActivity extends AppCompatActivity implements GoogleMap.OnInfoWindowClickListener, OnMapReadyCallback,GoogleMap.OnMarkerDragListener,GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private Marker markerPrueba,InfoWindow,MarkerDragMedicina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng UdeACentral = new LatLng(6.2668161, -75.5692249);
        InfoWindow = googleMap.addMarker(new MarkerOptions()
        .position(UdeACentral)
        .title("Sede Central UdeA").draggable(true)
        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        //mMap.addMarker(new MarkerOptions().position(UdeACentral).draggable(true).title("UdeA Sede Central"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UdeACentral,7));



        LatLng UdeAMedicina = new LatLng(6.2611557, -75.5670534);
        MarkerDragMedicina =googleMap.addMarker(new MarkerOptions()
        .position(UdeAMedicina)
        .title("UdeA Facultad de Medicina").draggable(true));
        //mMap.addMarker(new MarkerOptions().position(UdeAMedicina).draggable(true).title("UdeA Facultad de Medicina"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UdeAMedicina,7));

        LatLng UdeAOdontologia = new LatLng(6.2612493, -75.5685112);
        mMap.addMarker(new MarkerOptions().position(UdeAOdontologia).draggable(true).title("UdeA Facultad Odontología"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UdeAOdontologia,7));

        LatLng UdeARobledo = new LatLng(6.2724463, -75.5898779);
        mMap.addMarker(new MarkerOptions().position(UdeARobledo).draggable(true).title("UdeA Facultad Odontología"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UdeARobledo,7));

        LatLng UdeAOriente = new LatLng(6.1055994, -75.389768);
        mMap.addMarker(new MarkerOptions().position(UdeAOriente).draggable(true).title("UdeA Sede Oriente"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UdeAOriente,7));

        LatLng UdeASedePosgrados = new LatLng(6.198011, -75.5868495);
        mMap.addMarker(new MarkerOptions().position(UdeASedePosgrados).draggable(true).title("UdeA Sede Posgrados"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UdeASedePosgrados,7));

        LatLng UdeASedeOccidente = new LatLng(6.5549563, -75.8287691);
        mMap.addMarker(new MarkerOptions().position(UdeASedeOccidente).draggable(true).title("UdeA Sede Occidente"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UdeASedeOccidente,7));

        LatLng UdeASedeNorte = new LatLng(6.9621234, -75.4199221);
        mMap.addMarker(new MarkerOptions().position(UdeASedeNorte).draggable(true).title("UdeA Sede Norte"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UdeASedeNorte,7));

        LatLng UdeASedeApartado = new LatLng(7.8696293, -76.6388933);
        mMap.addMarker(new MarkerOptions().position(UdeASedeApartado).draggable(true).title("UdeA Sede Apartadó")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_CYAN)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(UdeASedeApartado,7));


        //
        googleMap.setOnMarkerClickListener(this);

        //Dialog con info de la localización del marcador
        googleMap.setOnInfoWindowClickListener(this);

        // apra drag

        googleMap.setOnMarkerDragListener(this);


    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        if (marker.equals(InfoWindow)){
            String lat,lgn;
            lat = Double.toString(marker.getPosition().latitude);
            lgn= Double.toString(marker.getPosition().longitude);
            Toast.makeText(this, lat + " , "+ lgn, Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    @Override
    public void onInfoWindowClick(Marker marker) {
        if (marker.equals(InfoWindow)){
            SedeCentralFragment.newInstance(marker.getTitle(),getString(R.string.CentralInfo))
                    .show(getSupportFragmentManager(),null);
        }
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        if (marker.equals(MarkerDragMedicina)){
            Toast.makeText(this, "Start", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onMarkerDrag(Marker marker) {
        if (marker.equals(MarkerDragMedicina)){
            String newTitle = String.format(Locale.getDefault(),
                    getString(R.string.marker_detail_latlgn),
                    marker.getPosition().latitude,
                    marker.getPosition().latitude);

            setTitle(newTitle);
        }
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        if (marker.equals(MarkerDragMedicina)){
            Toast.makeText(this, "Finish", Toast.LENGTH_SHORT).show();
            setTitle(R.string.app_name);
        }
    }
}
