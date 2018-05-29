import java.io.*;
import java.sql.*;

public class CreateHtml {
    public static void print(ResultSet resultSet) throws SQLException, IOException {
        ResultSetMetaData md = resultSet.getMetaData();
        int columnCount = md.getColumnCount();

        try (PrintWriter writer = new PrintWriter(new FileWriter("SelectResult.html"))) {
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Sql result</title>");
            writer.println("</head>");
            writer.println("<body>");
            writer.println("<table border=\"1\" cellspacing=\"1\" cellpadding=\"5\" width=\"100%\" height=\"10\"> ");
            writer.println("<tr>");
            //columns
            for (int i = 1; i <= columnCount; i++) {
                writer.print("<td style=\"background-color: slategray\">");
                writer.print("<b>");
                writer.print(md.getColumnLabel(i));
                writer.print("</b>");
                writer.println("</td>");
            }
            writer.println("</tr>");
            //content
            int row = 1;
            while (resultSet.next()) {
                writer.println("<tr>");
                if (row % 2 == 0) {
                    for (int i = 1; i <= columnCount; i++) {
                        writer.print("<td style=\"background-color: lightgray\">");
                        writer.print(resultSet.getString(i));
                        writer.println("</td>");
                    }
                } else {
                    for (int i = 1; i <= columnCount; i++) {
                        writer.print("<td>");
                        writer.print(resultSet.getString(i));
                        writer.println("</td>");
                    }
                }
                writer.println("<tr>");
                row++;
            }
            //end content
            writer.println("</table>");
            writer.println("</body>");
            writer.println("</html>");

        }
    }
}
