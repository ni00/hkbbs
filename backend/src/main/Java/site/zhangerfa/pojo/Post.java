package site.zhangerfa.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.web.multipart.MultipartFile;
import site.zhangerfa.controller.tool.NewPost;

import java.util.Date;
import java.util.List;

@Schema(description = "帖子")
public class Post {
    private int id;
    @Schema(description = "发帖人学号")
    private String posterId;
    @Schema(description = "标题")
    private String title;
    @Schema(description = "正文")
    private String content;
    @Schema(description = "发帖时间")
    private Date createTime = new Date();
    @Schema(description = "评论数量")
    private int commentNum = 0;
    @Schema(description = "热度")
    private int hot = 0;
    @Schema(description = "帖子中图片URL集合")
    private List<Image> images;
    @JsonIgnore
    private MultipartFile[] imageFiles;

    public Post(){}

    public Post(NewPost newPost){
        title = newPost.getTitle();
        content = newPost.getContent();
    }

    public MultipartFile[] getImageFiles() {
        return imageFiles;
    }

    public void setImageFiles(MultipartFile[] imageFiles) {
        this.imageFiles = imageFiles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPosterId() {
        return posterId;
    }

    public void setPosterId(String posterId) {
        this.posterId = posterId;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}