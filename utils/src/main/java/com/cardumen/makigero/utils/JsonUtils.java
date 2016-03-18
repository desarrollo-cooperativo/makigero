package com.cardumen.makigero.utils;

import android.database.Cursor;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * @author diego.rotondale
 * @version 0.1
 *
 * Utils to work with json format
 */
public class JsonUtils {

    //region Constructor
    private JsonUtils() {
        // Private constructor to avoid instantiation.
    }
    //endregion

    //region Public Static Implementation
    /**
     * @param cursor The cursor to be transformed
     * @param keys a key, value {@link Map} that describes how a certain column will be named in the output json
     * @return The cursor data in json format
     */
    public static String transformCursorToJson(Cursor cursor, Map<String, String> keys) {
        String json = null;
        if (cursor != null) {
            JSONArray arr = new JSONArray();
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                int nColumns = cursor.getColumnCount();
                JSONObject row = new JSONObject();
                for (int i = 0; i < nColumns; i++) {
                    String colName = cursor.getColumnName(i);
                    if (colName != null) {
                        String val = "";
                        try {
                            switch (cursor.getType(i)) {
                                case Cursor.FIELD_TYPE_BLOB:
                                    row.put(getKey(keys, colName), cursor.getBlob(i));
                                    break;
                                case Cursor.FIELD_TYPE_FLOAT:
                                    row.put(getKey(keys, colName), cursor.getDouble(i));
                                    break;
                                case Cursor.FIELD_TYPE_INTEGER:
                                    row.put(getKey(keys, colName), cursor.getLong(i));
                                    break;
                                case Cursor.FIELD_TYPE_NULL:
                                    row.put(getKey(keys, colName), null);
                                    break;
                                case Cursor.FIELD_TYPE_STRING:
                                    row.put(getKey(keys, colName), cursor.getString(i));
                                    break;
                            }
                        } catch (JSONException e) {
                            Log.e(JsonUtils.class.getName(), e.getMessage());
                        }
                    }
                }
                arr.put(row);
                if (!cursor.moveToNext()) {
                    break;
                }
            }
            json = arr.toString();
            cursor.close();
        }
        return json;
    }
    //endregion

    //region Public Static Implementation
    private static String getKey(Map<String, String> keys, String colName) {
        if (keys == null || keys.isEmpty()) {
            return colName;
        } else {
            if (keys.containsKey(colName)) {
                return keys.get(colName);
            }
        }
        return null;
    }
    //endregion
}