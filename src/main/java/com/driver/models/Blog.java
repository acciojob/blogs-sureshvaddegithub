package  com.driver.models;

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
    private List<Image> listOfImages;

    @ManyToOne
    @JoinColumn
    private User user;

    public Blog(){

    }

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;

    }

    public List<Image> getListOfImages() {
        return listOfImages;
    }

    public void setListOfImages(List<Image> listOfImages) {
        this.listOfImages = listOfImages;
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