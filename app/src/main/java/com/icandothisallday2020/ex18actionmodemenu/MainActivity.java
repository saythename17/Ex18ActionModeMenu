package com.icandothisallday2020.ex18actionmodemenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        //액션모드메뉴 시작하기!
        startActionMode(new ActionMode.Callback() {
            //액션모드메뉴가 처음 만들어질때 1번 호출되는 메소드(최초)
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                getMenuInflater().inflate(R.menu.actionmode,menu);
                //p.s 액션모드- 추가 설정
                mode.setTitle("Action Mode");//액션모드 액션바 타이틀 설정
                mode.setSubtitle("This is action mode");
                //액션메뉴의 배경색: style.xml 에서만 지정 가능
                return true;//리턴값을 true 로 해야 액션모드 발동
            }
            //1번 호출후, 액션모드메뉴가 시작될때마다 발동하는 메소드(버튼 누를때마다)
            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }
            //액션모드메뉴의 아이템클릭시 발동하는 메소드
            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_share:
                        Toast.makeText(MainActivity.this,"Share",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_crop:
                        Toast.makeText(MainActivity.this,"crop", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_map:
                        Toast.makeText(MainActivity.this,"map",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
            //액션모드가 닫힐때 자동 실행
            @Override
            public void onDestroyActionMode(ActionMode mode) {

            }
        });//this.생략
    }
}
