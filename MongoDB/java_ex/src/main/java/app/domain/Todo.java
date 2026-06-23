package app.domain;

import org.bson.types.ObjectId;

public class Todo {
    private ObjectId id;
    private String title;
    private String desc;
    private boolean done;

    public ObjectId getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDesc() {
        return this.desc;
    }

    public boolean isDone() {
        return this.done;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Todo)) {
            return false;
        }
        Todo other = (Todo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.isDone() != other.isDone()) {
            return false;
        }
        ObjectId this$id = this.getId();
        ObjectId other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) {
            return false;
        }
        String this$title = this.getTitle();
        String other$title = other.getTitle();
        if (this$title == null ? other$title != null : !this$title.equals(other$title)) {
            return false;
        }
        String this$desc = this.getDesc();
        String other$desc = other.getDesc();
        return !(this$desc == null ? other$desc != null : !this$desc.equals(other$desc));
    }

    protected boolean canEqual(Object other) {
        return other instanceof Todo;
    }

    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + (this.isDone() ? 79 : 97);
        ObjectId $id = this.getId();
        result = result * 59 + ($id == null ? 43 : $id.hashCode());
        String $title = this.getTitle();
        result = result * 59 + ($title == null ? 43 : $title.hashCode());
        String $desc = this.getDesc();
        result = result * 59 + ($desc == null ? 43 : $desc.hashCode());
        return result;
    }

    public String toString() {
        return "Todo(id=" + this.getId() + ", title=" + this.getTitle() + ", desc=" + this.getDesc() + ", done=" + this.isDone() + ")";
    }

    public Todo(ObjectId id, String title, String desc, boolean done) {
        this.id = id;
        this.title = title;
        this.desc = desc;
        this.done = done;
    }

    public Todo() {
    }
}
