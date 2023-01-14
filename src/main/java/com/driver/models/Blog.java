package  com.driver.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "blog")

public class Blog{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;

    private String title;
    private String content;

    @CreationTimestamp
    private Date pubDate;

    @OneToMany(mappedBy = "blog",cascade = CascadeType.ALL)
    @JsonIgnoreProperties("blog")
    private List<Image> imageList;

    @ManyToOne
    @JoinColumn
    private User user;

    public Blog(){

    }

    public Blog(int id, String title, String content, Date pubDate, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.pubDate = pubDate;
        this.user = user;
    }

    public Blog(String title, String content, Date pubDate) {
        this.title = title;
        this.content = content;
        this.pubDate = pubDate;
    }

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;

    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }
}