package com.fiuady.db;

import android.database.CursorWrapper;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Armín on 17/03/2017.
 */

class CategoryCursor extends CursorWrapper
{
    public CategoryCursor(Cursor cursor) {
        super(cursor);
    }


    public  Category getCategory()
    {

        Cursor cursor = getWrappedCursor();
        return  new Category(cursor.getInt(cursor.getColumnIndex((InventoryDbSchema.CategoriesTable.Columns.ID))),
                cursor.getString(cursor.getColumnIndex((InventoryDbSchema.CategoriesTable.Columns.DESCRIPTION))));

    }

}




public final class Inventory {

    private InventoryHelper invetoryhelper;
    private SQLiteDatabase db;


    public  Inventory(Context context){
        invetoryhelper = new InventoryHelper(context);
        db = invetoryhelper.getWritableDatabase();

    }

    public List<Category> getAllCategories()
    {
        List<Category> list = new ArrayList<Category>();


        //  Cursor cursor = db.rawQuery("SELECT * FROM categories ORDER BY id", null);

        CategoryCursor cursor = new CategoryCursor((db.rawQuery("SELECT * FROM categories ORDER BY id", null)));

        while (cursor.moveToNext()){

            //list.add(new Category(cursor.getInt(cursor.getColumnIndex((InventoryDBSchema.CategoriesTable.Columns.ID))),
            //   cursor.getString(cursor.getColumnIndex((InventoryDBSchema.CategoriesTable.Columns.DESCRIPTION)))));

            list.add((cursor.getCategory()));  // metodo wrappcursor

        }
        cursor.close();


        return list;
    }


    public  void  updateCategory(Category category)
    {

        ContentValues values = new ContentValues();
        values.put(InventoryDbSchema.CategoriesTable.Columns.DESCRIPTION, category.getDescription());// asegura que siempre da correcto

        db.update(InventoryDbSchema.CategoriesTable.NAME, values, InventoryDbSchema.CategoriesTable.Columns.ID + " = ?", new String[]{Integer.toString(category.getId())});

    }



}