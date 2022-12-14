public class Fact {
    private String id;
    private String text;
    private String type;
    private String user;
    private String upvotes;

    public Fact(String id, String text, String type, String user, String upvotes) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.user = user;
        this.upvotes = upvotes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(String upvotes) {
        this.upvotes = upvotes;
    }

    @Override
    public String toString() {
        return "Fact id " + id + ":" + "\n" +
                "text: " + text + "\n" +
                "type: " + type + "\n" +
                "user: " + user + "\n" +
                "upvotes: " + upvotes + "\n";
    }
}

