package com.example.armn.inventoryapplication;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import java.util.List;

import com.fiuady.db.Category;
import com.fiuady.db.Inventory;


public class MainActivity extends AppCompatActivity {

   private Inventory inventory;
    private Spinner categoriesSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    //   InventoryHelper.backupDatabseFile((getApplicationContext()));

    //   invetoryhepler = new InventoryHelper(getApplicationContext());
    //   db = invetoryhepler.getWritableDatabase();


        categoriesSpinner = (Spinner)findViewById(R.id.categories_list);
        inventory = new Inventory(getApplicationContext());

        ArrayAdapter<String> adapter =new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item);
      //  adapter.add("Hola");
       // adapter.add("Android");
        //adapter.add("Java");
        categoriesSpinner.setAdapter((adapter));

        List<Category> categories = inventory.getAllCategories();

        for (Category c:  inventory.getAllCategories())
        {
            adapter.add(c.getDescription());
        }


    // Cursor cursor = db.rawQuery("SELECT * FROM categories ORDER BY id", null);
    //  while (cursor.moveToNext()){
    //adapter.add(cursor.getString(cursor.getColumnIndex(CategoriesTable.Columns.DESCRIPTION)));
    //  }
    //cursor.close();


    Category c = categories.get(4);
    c.setDescription(("Motherboards"));
    inventory.updateCategory(c);



}

        //InventoryHelper.backupDatabaseFile(getApplicationContext());

   //  inventory = new Inventory(getApplicationContext());
   //
   //   for(Category category: inventory.getAllCategories())
   //   {
   //       adapter.add(category.getDescription());
   //   }
   //


}
