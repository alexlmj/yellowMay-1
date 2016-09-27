package net.bluehack.yellowmay;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private FutsalCardAdapter futsalCardAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<FutsalItem> futsalItemList;
    private Context context;
    private Button btn_km;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestContactPermission();

        context = getApplicationContext();

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        futsalItemList = new ArrayList<FutsalItem>();

        //TODO : 서버에서 받은 데이터를 futsalItemList에 채우기
        //TODO : img파일은 resources에서 관리
        //밑 코드는 임시 테스트 코드
        int img1 = R.drawable.field1;
        int img2 = R.drawable.field2;
        futsalItemList.add(new FutsalItem(img1, "잠실축구장", "3km", "무료"));
        futsalItemList.add(new FutsalItem(img2, "일산축구장","7km", "유료"));


        futsalCardAdapter = new FutsalCardAdapter(context, futsalItemList);
        mRecyclerView.setAdapter(futsalCardAdapter);


        btn_km=(Button)findViewById(R.id.km);
        btn_km.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DialogRadio();
            }
        });
    }

    private void DialogRadio(){
        final String[] distance = {"3 Km","5 Km", "7 Km", "8 Km", "10 Km", "10 Km 이상"};
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
        alt_bld.setTitle("반경 거리 변경");
        alt_bld.setSingleChoiceItems(distance, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                String str = distance[item];
                btn_km.setText(str);
                dialog.dismiss();
            }
        });
        AlertDialog alert = alt_bld.create();
        alert.show();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MarshmallowPermission.PERMISSIONS_REQUEST_INTERNET: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    ServiceUtil.startLoaderService(context);
                } else {
                    //권한 거절시
                    permissionDialog();

                }
                return;
            }

            case MarshmallowPermission.PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    ServiceUtil.startLoaderService(context);
                } else {
                    //권한 거절시
                    permissionDialog();
                }
                return;
            }

            case MarshmallowPermission.PERMISSIONS_REQUEST_ACCESS_COARSE_LOCATION: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    ServiceUtil.startLoaderService(context);
                } else {
                    //권한 거절시
                    permissionDialog();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    private void requestContactPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                // (왜필요한지) 설명
            }

            //권한 요청
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MarshmallowPermission.PERMISSIONS_REQUEST_ACCESS_FINE_LOCATION);
        }
        else if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_COARSE_LOCATION)) {
                // (왜필요한지) 설명
            }

        }
        else {
            //
        }
    }

    private void permissionDialog(){
        AlertDialog.Builder alt_bld = new AlertDialog.Builder(this);
        alt_bld.setMessage("권한 요청을 하셔야 이용할 수 있습니다").setCancelable(
                false).setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Action for 'Yes' Button
                        requestContactPermission();

                    }
                }).setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Action for 'NO' Button
                        dialog.cancel();
                    }
                });
        AlertDialog alert = alt_bld.create();
        // Title for AlertDialog
        alert.setTitle("권한");
        // Icon for AlertDialog
        //alert.setIcon(R.drawable.icon);
        alert.show();
    }

}