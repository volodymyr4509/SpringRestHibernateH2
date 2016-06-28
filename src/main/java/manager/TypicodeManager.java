package manager;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.TypicodeDAO;
import dao.TypicodeDAOImpl;
import dto.Typicode;
import util.RequestHandler;

import java.io.IOException;
import java.util.List;

/**
 * Created by volodymyr on 28.06.16.
 */
public class TypicodeManager {
    private static final String URL = "http://jsonplaceholder.typicode.com/posts/";
    private RequestHandler handler = new RequestHandler();
    private TypicodeDAO typicodeDAO = new TypicodeDAOImpl();

    /**
     * DO nothing in case of any issues:)
     */
    public void handleInput(long id) {
        Typicode typicode = readFromUrl(id);
        if (typicode == null) {
            return ;
        }
        writeToDatabase(typicode);
    }

    public List<Typicode> getTypicodeList() {
        return typicodeDAO.getAll();
    }

    private Typicode readFromUrl(long id) {
        String s = handler.sendGet(URL + id);
        if (s == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(s, Typicode.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * write or update
     */
    private void writeToDatabase(Typicode typicode) {
        Typicode byID = typicodeDAO.getByID(typicode.getId());
        if (byID == null) {
            typicodeDAO.save(typicode);
        } else {
            typicodeDAO.update(typicode);
        }
    }
}
