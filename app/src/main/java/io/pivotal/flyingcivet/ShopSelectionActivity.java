package io.pivotal.flyingcivet;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ShopSelectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_selection);

        ListView listView = (ListView) findViewById(R.id.coffee_places_list);
        ArrayAdapter<String> adapter = getShopListAdapter();
        listView.setAdapter(adapter);
    }

    @NonNull
    private ArrayAdapter<String> getShopListAdapter() {
        return new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.shop_list));
    }
}
