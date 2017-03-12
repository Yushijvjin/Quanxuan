package com.bwie.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CargoAdapter cargoAdapter;
    private ListView listView;
    private TextView tv_sum_price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView) findViewById(R.id.listView);
        tv_sum_price = (TextView) findViewById(R.id.tv_sum_price);
        findViewById(R.id.bt1).setOnClickListener(this);
        findViewById(R.id.bt2).setOnClickListener(this);
        findViewById(R.id.bt3).setOnClickListener(this);
        findViewById(R.id.bt4).setOnClickListener(this);

        initData();
        cargoAdapter = new CargoAdapter(cargoList, this, new OnMoneyChangeListener() {
            @Override
            public void setChange() {
                setMony();
            }
        });
        listView.setAdapter(cargoAdapter);

    }

    ArrayList<Cargo> cargoList = new ArrayList<>();

    private void initData() {

        for (int i = 0; i < 200; i++) {
            cargoList.add(new Cargo("商品" + i, null, false, i + i));

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt1:
                for (int i = 0; i < cargoList.size(); i++) {
                    cargoList.get(i).setFlag(true);
                }
                cargoAdapter.notifyDataSetChanged();

                setMony();
                break;
            case R.id.bt2:
                for (int i = 0; i < cargoList.size(); i++) {
                    cargoList.get(i).setFlag(!cargoList.get(i).isFlag());
                }
                cargoAdapter.notifyDataSetChanged();
                setMony();

                break;
            case R.id.bt3:
                for (int i = 0; i < cargoList.size(); i++) {
                    cargoList.get(i).setFlag(false);
                }
                cargoAdapter.notifyDataSetChanged();

                setMony();
                break;

            case R.id.bt4:

                int sum = 0;
                for (int i = 0; i < cargoList.size(); i++) {
                    if (cargoList.get(i).isFlag()) {
                        sum = sum + cargoList.get(i).getPrice();
                    }
                }
                Toast.makeText(this, ""+sum, Toast.LENGTH_SHORT).show();
                setMony();
                break;
        }


    }

    public void setMony() {
        int sum = 0;
        for (int i = 0; i < cargoList.size(); i++) {
            if (cargoList.get(i).isFlag()) {
                sum = sum + cargoList.get(i).getPrice();

            }
        }
        tv_sum_price.setText("总价格" + sum);

    }
}
