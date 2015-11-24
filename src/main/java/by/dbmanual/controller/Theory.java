package by.dbmanual.controller;

import by.dbmanual.model.NoSuchTheoryException;
import javafx.scene.Node;
import javafx.scene.web.WebView;

import java.net.URL;

public class Theory {
    private WebView view = new WebView();

    public Theory(String resourceName) throws NoSuchTheoryException {
        URL resource = Theory.class.getResource(resourceName);
        if (resource != null) {
            view.getEngine().load(resource.toExternalForm());
        } else {
            throw new NoSuchTheoryException(String.format("Theory resource (\"%s\") not found", resourceName));
        }
    }

    public Node getView() {
        return view;
    }
}
