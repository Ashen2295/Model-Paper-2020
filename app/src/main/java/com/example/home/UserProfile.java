package com.example.home;

import android.provider.BaseColumns;

public class UserProfile {
    private UserProfile() {}

    /* Inner class that defines the table contents */
    public static class Users implements BaseColumns {
        public static final String TABLE_NAME = "UserInfo";
        public static final String COLUMN_1 = "userName";
        public static final String COLUMN_2 = "dateOfBirth";
        public static final String COLUMN_3 = "gender";
    }

}