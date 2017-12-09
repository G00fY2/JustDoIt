package de.g00fy2.model.entities.db;

import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import de.g00fy2.model.db.AppDatabase;

/**
 * Created by Thomas Wirth on 09.12.2017.
 */

@Table(database = AppDatabase.class, allFields = true) public class SummonerSpellDbEntity {

  @PrimaryKey public int id;
  public int summonerLevel;
  public String name;
  public String key;
  public String description;

  @Override public String toString() {
    return "SummonerSpellDbEntity{"
        + "id="
        + id
        + ", summonerLevel="
        + summonerLevel
        + ", name='"
        + name
        + '\''
        + ", key='"
        + key
        + '\''
        + ", description='"
        + description
        + '\''
        + '}';
  }
}
