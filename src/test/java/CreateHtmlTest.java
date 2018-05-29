import org.junit.Test;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateHtmlTest {

    @Test
    public void testPrint() throws IOException, SQLException {
        try (Connection connection = SetUpDB.getConnection();
             Statement statement = connection.createStatement();
        ) {
            String sql = "SELECT * FROM AUTHORS";

            ResultSet resultSet = statement.executeQuery(sql);
            CreateHtml.print(resultSet);
            //SelectResult.html created
        }
    }
}
