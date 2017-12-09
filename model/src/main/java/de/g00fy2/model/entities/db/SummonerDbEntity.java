package de.g00fy2.model.entities.db;

import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import de.g00fy2.model.db.AppDatabase;

/**
 * Created by Thomas Wirth on 09.12.2017.
 */

@Table(database = AppDatabase.class, allFields = true) public class SummonerDbEntity {

  public int profileIconId;
  public String name;
  public long summonerLevel;
  public long revisionDate;
  @PrimaryKey public long id;
  public long accountId;
}
