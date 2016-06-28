package dto;

import javax.persistence.*;

/**
 * Created by volodymyr on 28.06.16.
 */

@Entity
@Table(name = "typicode")
public class Typicode {

    private long userId;
    @Id
    private long id;
    private String title;
    private String body;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Typicode typicode = (Typicode) o;

        if (userId != typicode.userId) return false;
        if (id != typicode.id) return false;
        if (title != null ? !title.equals(typicode.title) : typicode.title != null) return false;
        return body != null ? body.equals(typicode.body) : typicode.body == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (body != null ? body.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Typicode{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}

