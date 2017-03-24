package com.fiuady.db;

/**
 * Created by Armín on 17/03/2017.
 */
public final class InventoryDbSchema { // Nos sirve únicamente como guía para conocer cada uno de las atributos que
                                       // presenta cada Tabla en la base de Datos
    public static final class CategoriesTable{
        public static final String NAME = "categories";

        public static final class Columns
        {
            public static final String ID = "id";
            public static final String DESCRIPTION = "description";
        }

    }

    public static final class ProductsTable{
        public static final String NAME = "products";

        public static final class Columns
        {
            public static final String ID = "id";
            public static final String CATEGORY_ID= "category_id";
            public static final String DESCRITPION= "description";
            public static final String PRICE= "price";
            public static final String QUANTITY= "qty";

        }



    }

}
