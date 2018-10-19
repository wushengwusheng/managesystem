package comment;

public class Comments {
    private int id;
    private int article_id;
    private int comments_id;
    private String comments_name;
    private String comments_email;
    private String comments_content;
    private int comments_partid;
    private String comments_time;
    private int comments_status;
    
    public Comments(){
    	super();
    }
    
    public Comments(int id,String comments_name,String comments_email,String comments_content,String comments_time,int comments_status){
    	super();
    	this.id=id;
    	this.comments_name=comments_name;
    	this.comments_email=comments_email;
    	this.comments_content=comments_content;
    	this.comments_time=comments_time;
    	this.comments_status=comments_status;
    }
    
    public Comments(int id, int article_id,int comments_id,String comments_name,String comments_email,String comments_content,int comments_partid,String comments_time,int comments_status){
    	super();
    	this.id=id;
    	this.article_id=article_id;
    	this.comments_id=comments_id;
    	this.comments_name=comments_name;
    	this.comments_email=comments_email;
    	this.comments_content=comments_content;
    	this.comments_partid=comments_partid;
    	this.comments_time=comments_time;
    	this.comments_status=comments_status;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getArticleid() {
        return article_id;
    }
    public void setArticleid(int article_id) {
        this.article_id = article_id;
    }
    public int getCommentsid() {
        return comments_id;
    }
    public void setCommentsid(int comments_id) {
        this.comments_id = comments_id;
    }
    public String getCommentsname() {
        return comments_name;
    }
    public void setCommentsname(String comments_name) {
        this.comments_name = comments_name;
    }
    public String getCommentsemail() {
        return comments_email;
    }
    public void setCommentsemail(String comments_email) {
        this.comments_email = comments_email;
    }
    public String getCommentscontent() {
        return comments_content;
    }
    public void setCommentscontent(String comments_content) {
        this.comments_content = comments_content;
    }
    public int getCommentspartid() {
        return comments_partid;
    }
    public void setCommentspartid(int comments_partid) {
        this.comments_partid = comments_partid;
    }
    public String getCommentstime() {
        return comments_time;
    }
    public void setCommentstime(String comments_time) {
        this.comments_time = comments_time;
    }
    public int getCommentsstatus() {
        return comments_status;
    }
    public void setCommentsstatus(int comments_status) {
        this.comments_status = comments_status;
    }
}
