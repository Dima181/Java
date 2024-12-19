package stonks.util;

import java.sql.SQLException;
import java.time.LocalDate;
import stonks.Valute;

public interface DatabaseService {
    Valute getValuteOfDate(LocalDate var1) throws SQLException;

    void saveMaxValuteOfDate(String var1, Valute var2, LocalDate var3) throws SQLException;
}
