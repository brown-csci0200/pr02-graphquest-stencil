package src;

public class NodeNameExistsException extends IllegalArgumentException {
    public NodeNameExistsException() {
        super("Node name already exists");
    }

    public NodeNameExistsException(String label) {
        super("Node name " + label + " already exists");
    }
}
