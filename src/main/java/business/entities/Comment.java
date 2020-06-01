package business.entities;

public class Comment {
    private Integer id = null;
    private String text = null;

    public Comment(Integer id, String text) {
        this.id = id;
        this.text = text;
    }

    public Comment() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
