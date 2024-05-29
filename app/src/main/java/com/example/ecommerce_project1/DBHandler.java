package com.example.ecommerce_project1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class DBHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "ecommerce";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "tblusers";
    private static final String TABLE_CART = "tblcart";
    private static final String TABLE_PRODUCTS = "tblproducts";
    private static final String TABLE_ORDERS = "tblorders";

    // below variable is for our id column.
    private static final String ID_COL = "id";

    // below variable is for our course name column
    private static final String NAME_COL = "name";

    // below variable id for our course duration column.
    private static final String PASSWORD = "password";
    private static final String USER_ID = "userid";
    private static final String PRODUCT_ID = "itemid";
    private static final String QUANTITY = "quantity";
    private static final String EMAIL = "email";
    private static final String PRODUCT_NAME = "name";
    private static final String PRODUCT_PRICE = "price";

    // creating a constructor for our database handler.
    public DBHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + PASSWORD + " INTEGER,"
                + EMAIL + " TEXT)";

        // at last we are calling a exec sql
        // method to execute above sql query

        String tblcartquery = "CREATE TABLE " + TABLE_CART + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USER_ID + " INTEGER,"
                + PRODUCT_ID + " INTEGER,"
                + PRODUCT_NAME + " TEXT,"
                + PRODUCT_PRICE + " INTEGER,"
                + QUANTITY + " TEXT)";

        String productsTableQuery = "CREATE TABLE " + TABLE_PRODUCTS + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PRODUCT_NAME + " TEXT,"
                + PRODUCT_PRICE + " INTEGER)";
        String orders = "CREATE TABLE " + TABLE_ORDERS + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USER_ID + " INTEGER,"
                + PRODUCT_ID + " INTEGER,"
                + PRODUCT_NAME + " TEXT,"
                + PRODUCT_PRICE + " INTEGER,"
                + QUANTITY + " TEXT)";
        db.execSQL(query);
        db.execSQL(tblcartquery);
        db.execSQL(productsTableQuery);
        db.execSQL(orders);
        insertInitialProducts(db);

    }

    private void insertInitialProducts(SQLiteDatabase db) {
        addProductDirect(db, 1, "Laptop1", 23599);
        addProductDirect(db, 2, "Laptop2", 49555);
        addProductDirect(db, 3, "Laptop3", 35999);
        addProductDirect(db, 4, "Phone1", 5999);
        addProductDirect(db, 5, "Phone2", 3999);
        addProductDirect(db, 6, "Phone3", 8999);
        addProductDirect(db, 7, "GPU1", 5999);
        addProductDirect(db, 8, "GPU2", 11999);
        addProductDirect(db, 9, "GPU3", 18999);
    }

    private void addProductDirect(SQLiteDatabase db, int itemid, String productName, int price) {
        ContentValues values = new ContentValues();
        values.put(ID_COL, itemid);
        values.put(PRODUCT_NAME, productName);
        values.put(PRODUCT_PRICE, price);
        db.insert(TABLE_PRODUCTS, null, values);
    }

    // this method is use to add new course to our sqlite database.
    public void addNewUser(String username, String email, String password) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, username);
        values.put(EMAIL, email);
        values.put(PASSWORD, password);



        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
    }
    public void addToCart(int id, int itemid, String productName, int price) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(USER_ID, id);
        values.put(PRODUCT_ID, itemid);
        values.put(PRODUCT_NAME, productName);
        values.put(PRODUCT_ID, productName);
        values.put(PRODUCT_PRICE, price);
        values.put(QUANTITY, "1");



        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_CART, null, values);

        // at last we are closing our
        // database after adding database.
    }
    public void addProducts(int itemid, String productName, int price) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(USER_ID, itemid);
        values.put(PRODUCT_NAME, productName);
        values.put(PRODUCT_ID, productName);
        values.put(PRODUCT_PRICE, price);
        values.put(QUANTITY, "1");



        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_PRODUCTS, null, values);

        // at last we are closing our
        // database after adding database.
    }
    public void addToOrders(int userid, String productName, int price) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(USER_ID, userid);
        values.put(PRODUCT_NAME, productName);
        values.put(PRODUCT_ID, productName);
        values.put(PRODUCT_PRICE, price);
        values.put(QUANTITY, "1");



        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_ORDERS, null, values);

        // at last we are closing our
        // database after adding database.
    }
    public void createTableCart(SQLiteDatabase db) {
        String tblcartquery = "CREATE TABLE " + TABLE_CART + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USER_ID + " INTEGER,"
                + PRODUCT_ID + " INTEGER,"
                + QUANTITY + " TEXT)";
        db.execSQL(tblcartquery);
    }
    public int readUser(String username, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE " + NAME_COL + " = '" + username + "' AND " + PASSWORD + " = '" + password + "'";
        Cursor cursor = null;
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }
        if (cursor.getCount() == 0 || cursor == null) {
            return -1;
        } else {
            while (cursor.moveToNext()) {
                if (cursor.getString(1).equals(username) && cursor.getString(2).equals(password)) {
                    return cursor.getInt(0);
                }
            }
        }
        return -1;
    }
    public void createOrder(int userid, int itemid, int quantity) {
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();
        values.put(USER_ID, userid);
        values.put(PRODUCT_ID, itemid);
        values.put(QUANTITY, quantity);
        // after adding all values we are passing
        // content values to our table.
        long result = db.insert(TABLE_CART, null, values);
        if (result == -1) {
            Log.d("DBHandler", "Failed to create order");
        } else {
            Log.d("DBHandler", "Order created successfully");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CART);
        onCreate(db);
    }
    public Cursor getAllItems() {
        Cursor cursor = null;
        String query = "SELECT *  FROM " + TABLE_PRODUCTS;
        SQLiteDatabase db = this.getReadableDatabase();
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    public Cursor getCartItems() {
        Cursor cursor = null;
        String query = "SELECT " + ID_COL + "," + PRODUCT_ID + ","+ PRODUCT_NAME + "," + PRODUCT_PRICE +" FROM " + TABLE_CART
                + " WHERE " + USER_ID + " = " + MainActivity.user.getId();
        SQLiteDatabase db = this.getReadableDatabase();
        if(db != null) {
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }
    public List<String> getCartDetailsWithProductNames() {
        List<String> cartDetails = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT " + TABLE_CART + "." + ID_COL + ", "
                + TABLE_CART + "." + USER_ID + ", "
                + TABLE_PRODUCTS + "." + PRODUCT_NAME + ", "
                + TABLE_CART + "." + QUANTITY + " FROM "
                + TABLE_CART + " INNER JOIN "
                + TABLE_PRODUCTS + " ON "
                + TABLE_CART + "." + PRODUCT_ID + " = "
                + TABLE_PRODUCTS + "." + ID_COL;

        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(0);
                int userId = cursor.getInt(1);
                String productName = cursor.getString(2);
                int quantity = cursor.getInt(3);
                cartDetails.add("ID: " + id + ", UserID: " + userId + ", Product: " + productName + ", Quantity: " + quantity);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return cartDetails;
    }
}
