import org.junit.Test;
import java.io.IOException;
import java.sql.SQLException;

public class QueryAppTest {

    @Test
    public void testRunCreate() {
        String sql = "CREATE TABLE TEST(ID INT, Info CHAR(20))";
        QueryApp.run(sql);
    }

    @Test
    public void testRunInsert() throws IOException, SQLException {
        String sql = "select test.* from test";
        QueryApp.run(sql);
        sql = "insert into TEST(ID, Info) values(1, 'qwdqwdq')";
        QueryApp.run(sql);
        sql = "insert into TEST(ID, Info) values(4, 'djjd')";
        QueryApp.run(sql);
        sql = "insert into TEST(ID, Info) values(56, 'jdgj')";
        QueryApp.run(sql);
        sql = "select test.* from test";
        QueryApp.run(sql);
    }

    @Test
    public void testRunSelect() throws IOException, SQLException {
        String sql = "select test.* from test";
        QueryApp.run(sql);
    }

    @Test
    public void testRunUpdate() throws IOException, SQLException {
        String sql = "select test.* from test";
        QueryApp.run(sql);
        sql = "update test set info = 'testtest'";
        QueryApp.run(sql);
        sql = "select test.* from test";
        QueryApp.run(sql);
    }

    @Test
    public void testRunDelete() throws IOException, SQLException {
        String sql = "select test.* from test";
        QueryApp.run(sql);
        sql = "delete from test where id = 56";
        QueryApp.run(sql);
        sql = "select test.* from test";
        QueryApp.run(sql);
    }

    @Test
    public void testRunDrop() throws IOException, SQLException {
        String sql = "DROP TABLE TEST";
        QueryApp.run(sql);
    }
}
