package de.g00fy2.model.entities.db;

import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import de.g00fy2.model.db.AppDatabase;

/**
 * Created by Thomas Wirth on 09.12.2017.
 */

@Table(database = AppDatabase.class, allFields = true) public class ChampionDbEntity {

  public String name;
  public String title;
  public String key;
  @PrimaryKey public int id;

  @Override public String toString() {
    return "ChampionDbEntity{"
        + "name='"
        + name
        + '\''
        + ", title='"
        + title
        + '\''
        + ", key='"
        + key
        + '\''
        + ", id="
        + id
        + '}';
  }
}
