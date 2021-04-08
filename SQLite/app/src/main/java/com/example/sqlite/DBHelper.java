package haqnawaz.org.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class  DBHelper extends SQLiteOpenHelper {
    public static final String CUSTOMER_NAME = "CustomerName";
    public static final String CUSTOMER_AGE = "CustomerAge";
    public static final String ACTIVE_CUSTOMER = "ActiveCustomer";
    public static final String CUSTOMER_ID = "CustomerID";
    public static final String CUST_TABLE = "CustTable";

    public DBHelper(@Nullable Context context) {
        super(context, "MyDB.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //String createTableSTatementOne = "CREATE TABLE CustTable(CustomerID Integer PRIMARY KEY AUTOINCREMENT, " + CUSTOMER_NAME_FIRST + " Text, CustomerAge Int, ActiveCustomer BOOL) ";
        String createTableSTatement = "CREATE TABLE " + CUST_TABLE + "(" + CUSTOMER_ID + " Integer PRIMARY KEY AUTOINCREMENT, " + CUSTOMER_NAME + " Text, " + CUSTOMER_AGE + " Int, " + ACTIVE_CUSTOMER + " BOOL) ";
        db.execSQL(createTableSTatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addCustomer(CustomerModel customerModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();

        cv.put(CUSTOMER_NAME, customerModel.getName());
        cv.put(CUSTOMER_AGE, customerModel.getAge());
        cv.put(ACTIVE_CUSTOMER, customerModel.isActive());

        long insert = db.insert(CUST_TABLE, null, cv);
        db.close();
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }

    public List<CustomerModel> getAllRecords() {
        List<CustomerModel> records = new ArrayList<CustomerModel>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM " + CUST_TABLE;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        while (cursor.moveToNext()) {
            records.add(new CustomerModel(cursor.getString(1), cursor.getInt(2), cursor.getInt(3) == 1 ? true : false, cursor.getInt(0)));
        }
        cursor.close();
        sqLiteDatabase.close();
        return records;
    }

    public boolean updateRecord(int id, CustomerModel customerModel) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(CUSTOMER_ID, customerModel.getId());
        contentValues.put(CUSTOMER_NAME, customerModel.getName());
        contentValues.put(CUSTOMER_AGE, customerModel.getAge());
        contentValues.put(ACTIVE_CUSTOMER, customerModel.isActive());
        String whereClause = CUSTOMER_ID + " = ?";
        String whereArgs[] = {Integer.toString(id)};
        int updatedRecordsCount = sqLiteDatabase.update(CUST_TABLE, contentValues, whereClause, whereArgs);
        sqLiteDatabase.close();
        if (updatedRecordsCount > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteRecord(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String whereClause = CUSTOMER_ID + " = ?";
        String whereArgs[] = {Integer.toString(id)};
        int delete = sqLiteDatabase.delete(CUST_TABLE, whereClause, whereArgs);
        sqLiteDatabase.close();
        if (delete > 0) {
            return true;
        } else {
            return false;
        }
    }
}