package news;

public class News {
    private int id;
    private String title;
    private String brief_intro;
    private String type;
    private String pic;
    private String content;
    private String jsp;
    private String writer;
    private String part;
    private int goods_count;
    private int comment;
    private int view;
    private int status;
    private String time;
    
    public News(){
    	super();
    }
    
    public News(int id,String title,String brief_intro,String type,String pic,String content,String jsp,String writer,String part,int status,String time) {
    	super();
    	this.id = id;
    	this.title = title;
    	this.brief_intro = brief_intro;
    	this.type = type;
    	this.pic = pic;
    	this.content = content;
    	this.jsp = jsp;
    	this.writer = writer;
    	this.part = part;
    	this.status = status;
    	this.time = time;
    }
    
    public News(int id,String title,String brief_intro,String type,String pic,String content,String jsp,String writer,String part,int goods_count,int comment,int view,int status,String time) {
    	super();
    	this.id = id;
    	this.title = title;
    	this.brief_intro = brief_intro;
    	this.type = type;
    	this.pic = pic;
    	this.content = content;
    	this.jsp = jsp;
    	this.writer = writer;
    	this.part = part;
    	this.goods_count = goods_count;
    	this.comment = comment;
    	this.view = view;
    	this.status = status;
    	this.time = time;
    }

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the brief_intro
	 */
	public String getBrief_intro() {
		return brief_intro;
	}

	/**
	 * @param brief_intro the brief_intro to set
	 */
	public void setBrief_intro(String brief_intro) {
		this.brief_intro = brief_intro;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the pic
	 */
	public String getPic() {
		return pic;
	}

	/**
	 * @param pic the pic to set
	 */
	public void setPic(String pic) {
		this.pic = pic;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the jsp
	 */
	public String getJsp() {
		return jsp;
	}

	/**
	 * @param jsp the jsp to set
	 */
	public void setJsp(String jsp) {
		this.jsp = jsp;
	}

	/**
	 * @return the writer
	 */
	public String getWriter() {
		return writer;
	}

	/**
	 * @param writer the writer to set
	 */
	public void setWriter(String writer) {
		this.writer = writer;
	}

	/**
	 * @return the part
	 */
	public String getPart() {
		return part;
	}

	/**
	 * @param part the part to set
	 */
	public void setPart(String part) {
		this.part = part;
	}

	/**
	 * @return the goods_count
	 */
	public int getGoods_count() {
		return goods_count;
	}

	/**
	 * @param goods_count the goods_count to set
	 */
	public void setGoods_count(int goods_count) {
		this.goods_count = goods_count;
	}

	/**
	 * @return the comment
	 */
	public int getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(int comment) {
		this.comment = comment;
	}

	/**
	 * @return the view
	 */
	public int getView() {
		return view;
	}

	/**
	 * @param view the view to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the view
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param view the view to set
	 */
	public void setView(int view) {
		this.view = view;
	}
	
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
    
    
}