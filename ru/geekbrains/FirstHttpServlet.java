package ru.geekbrains;

import ru.geekbrains.persist.User;
import ru.geekbrains.persist.UserRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/first-http-servlet/*")
public class FirstHttpServlet extends HttpServlet {

    private UserRepository userRepository;

    @Override
    public void init() throws ServletException {
        this.userRepository = (UserRepository) getServletContext().getAttribute("userRepository");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = userRepository.findAll();
        if (req.getPathInfo().equals("/users")) {
            resp.getWriter().println("<h1>Таблица Users</h1>");

            StringBuilder sb = new StringBuilder();
            sb.append("<table >\n" +
                    "  <tr>\n" +
                    "    <th>id</th>\n" +
                    "    <th>User name</th>\n" +
                    "  </tr>\n");

            for (int i = 0; i < userList.size(); i++) {
                sb.append("  <tr>\n" +
                        "    <th>" + userList.get(i).getId() + "</th>\n" +
                        "    <th>" + userList.get(i).getUsername() + "</th>\n" +
                        "  </tr>\n");

            }
            sb.append("\"</table>\"");
            String strTable = sb.toString();

            resp.getWriter().println(strTable);
        }

        StringBuilder sbUser = new StringBuilder();
        sbUser.append("<table >\n" +
                "  <tr>\n" +
                "    <th>id</th>\n" +
                "    <th>User name</th>\n" +
                "  </tr>\n");
        for (int i = 0; i < userList.size(); i++) {
            if (req.getPathInfo().equals("/user/" + userList.get(i).getId())) {
                sbUser.append("  <tr>\n" +
                        "    <th>" + userList.get(i).getId() + "</th>\n" +
                        "    <th>" + userList.get(i).getUsername() + "</th>\n" +
                        "  </tr>\n" +
                        "\"</table>\"");
                String strTableUser = sbUser.toString();
                resp.getWriter().println(strTableUser);
            }
        }
    }
}
