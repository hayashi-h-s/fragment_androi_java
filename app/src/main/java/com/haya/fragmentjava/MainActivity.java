package com.haya.fragmentjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // コードからFragmentを追加

        // Fragmentを作成します
        MainFragment fragment = new MainFragment();
        // Fragmentの追加や削除といった変更を行う際は、Transactionを利用します
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // 新しく追加を行うのでaddを使用します
        // 他にも、よく使う操作で、replace removeといったメソッドがあります
        // メソッドの1つ目の引数は対象のViewGroupのID、2つ目の引数は追加するfragment
        transaction.add(R.id.container, MainFragment.createInstance("hoge", Color.RED));
        transaction.add(R.id.container, MainFragment.createInstance("fuga", Color.BLUE));
        transaction.add(R.id.container, MainFragment.createInstance("fuga", Color.GREEN));
        // 最後にcommitを使用することで変更を反映します
        transaction.commit();
    }
}