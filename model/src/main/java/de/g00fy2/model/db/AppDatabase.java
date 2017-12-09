package de.g00fy2.model.db;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Thomas Wirth on 09.12.2017.
 */

@Database(name = AppDatabase.NAME, version = AppDatabase.VERSION)
public class AppDatabase {

  public static final String NAME = "AppDatabase";

  public static final int VERSION = 1;
}