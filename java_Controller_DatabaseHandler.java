package Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import Model.User;
import Utils.Utils;
public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String LOGCAT = null;
    public DatabaseHandler(@Nullable Context context) {
        super(context, Utils.DATABASE_NAME , null, Utils.DATABASE_VERSION);
        Log.d(LOGCAT,"Created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + Utils.TABLE_NAME +
                 "( " + Utils.KEY_UserName + " TEXT PRIMARY KEY, " +
                Utils.KEY_Password + " TEXT ); ";
        db.execSQL(CREATE_USERS_TABLE);
        Log.d(LOGCAT,"Users Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if(i != i1) {
            db.execSQL("DROP TABLE IF EXISTS " + Utils.TABLE_NAME);
            onCreate(db);
        }

    }

    public void addUser (User user ){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values= new ContentValues();
        values.put(Utils.KEY_UserName , user.getUserName());
        values.put(Utils.KEY_Password, user.getPassword());
        database.insert(Utils.TABLE_NAME , null ,values);
        database.close();
    }

    public User getUser(String username){
        SQLiteDatabase database = this.getReadableDatabase();
        User user = null;
         Cursor cursor = database.query(Utils.TABLE_NAME,
                new String[]{Utils.KEY_UserName,
                        Utils.KEY_Password},
                Utils.KEY_UserName + "= ?", new String[]{username},
                null, null, null, null);
            if (cursor.getCount() > 0 && cursor.moveToFirst())
                user = new User(cursor.getString(0), cursor.getString(1));
                return user;
    }
    }
