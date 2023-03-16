package com.example.ohumbrella;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class borrowAct extends FragmentActivity implements OnMapReadyCallback{
//,GoogleMap.OnMarkerClickListener
    private GoogleMap mMap;
    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrow);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used. (맵생성)
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        //콜백클래스 설정
        mapFragment.getMapAsync(this);

        AlertDialog.Builder ad = new AlertDialog.Builder(borrowAct.this);
        ad.setIcon(R.mipmap.ic_launcher_cloud);
        ad.setTitle("대여");
        ad.setMessage("대여를 원하시는 장소를 선택해주세요");

        ad.setPositiveButton("확인", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        ad.show();

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        //자유관 m0
        LatLng A1 = new LatLng(36.612166, 127.284676);
        mMap.addMarker(new MarkerOptions().position(A1).title("자유관"));
        //정의관 m1
        LatLng A2 = new LatLng(36.611744, 127.285201);
        mMap.addMarker(new MarkerOptions().position(A2).title("정의관"));
        //진리관 m2
        LatLng A3 = new LatLng(36.610900, 127.284429);
        mMap.addMarker(new MarkerOptions().position(A3).title("진리관"));
        //미래관 m3
        LatLng A4 = new LatLng(36.611080, 127.285298);
        mMap.addMarker(new MarkerOptions().position(A4).title("미래관"));

        //제1과기대 m4
        LatLng B1 = new LatLng(36.609901, 127.284236);
        mMap.addMarker(new MarkerOptions().position(B1).title("과학기술1관"));
        //icon(BitmapDescriptorFactory.fromResource(R.drawable.main_umbrella)) 이걸로 icon 변경가능함
        //제2과기대 m5
        LatLng B2 = new LatLng(36.611098, 127.286875);
        mMap.addMarker(new MarkerOptions().position(B2).title("과학기술2관"));

        //농심국제관 m6
        LatLng B3 = new LatLng(36.609169, 127.285555);
        mMap.addMarker(new MarkerOptions().position(B3).title("농심국제관"));
        //학술정보원 m7
        LatLng B4 = new LatLng(36.609840, 127.287090);
        mMap.addMarker(new MarkerOptions().position(B4).title("학술정보원"));

        //마커 클릭에 대한 이벤트 리스너
        mMap.setOnMarkerClickListener(markerClickListener);

        //학교쪽으로 시작 줌인
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(B2,17));


    }

    //마커 클릭 리스너
    GoogleMap.OnMarkerClickListener markerClickListener = new GoogleMap.OnMarkerClickListener() {
        @Override
        public boolean onMarkerClick(Marker marker) {

            String m = marker.getId();

            if(m.equals("m0")){ //자유
                borrow_umb_jayu umb_jayu = new borrow_umb_jayu();
                umb_jayu.show(getSupportFragmentManager(),"umb_jayu");

            }
            else if(m.equals("m1")){ //정의
                borrow_umb_jeongui umb_jeongui = new borrow_umb_jeongui();
                umb_jeongui.show(getSupportFragmentManager(),"umb_jeongui");
            }
            else if(m.equals("m2")){ //진리
                borrow_umb_jinli umb_jinli = new borrow_umb_jinli();
                umb_jinli.show(getSupportFragmentManager(),"umb_jinli");
            }
            else if(m.equals("m3")){ //미래
                borrow_umb_miere umb_miere = new borrow_umb_miere();
                umb_miere.show(getSupportFragmentManager(),"umb_miere");
            }
            else if(m.equals("m4")){ //1과기
                borrow_umb_1science umb_1science = new borrow_umb_1science();
                umb_1science.show(getSupportFragmentManager(),"umb_1science");
            }
            else if(m.equals("m5")){ //2과기
                borrow_umb_2science umb_2science = new borrow_umb_2science();
                umb_2science .show(getSupportFragmentManager(),"umb_2science");
            }
            else if(m.equals("m6")){ //농심국제관
                borrow_umb_nongsim umb_nongsim = new borrow_umb_nongsim();
                umb_nongsim.show(getSupportFragmentManager(),"umb_nongsim");
            }
            else if(m.equals("m7")){ //학술정보원
                borrow_umb_haksul umb_haksul = new borrow_umb_haksul();
                umb_haksul.show(getSupportFragmentManager(),"umb_haksul");
            }

            return false;
        }
    };
}
