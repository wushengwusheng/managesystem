package user;

public class User {
    private int id;
    private String username;
    private int sex;
    private int isdelete;
    private String password;
    private String phone;
    private String email;
    private String address;
    private String registtime;
    private String comment;
    
    public User(){
    	super();
    }
    
    public User(String username,String password){
    	super();
    	this.username=username;
    	this.password=password;
    }
    
    public User(int id, String username,String password,int sex,String phone,String email,String address,String registtime,String comment,int isdelete){
    	super();
    	this.id=id;
    	this.username=username;
    	this.password=password;
    	this.sex=sex;
    	this.phone=phone;
    	this.email=email;
    	this.address=address;
    	this.registtime=registtime;
    	this.comment=comment;
    	this.isdelete=isdelete;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String description) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getSex() {
        return sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getRegisttime() {
        return registtime;
    }
    public void setRegisttime(String registtime) {
        this.registtime = registtime;
    }
    public String getComment() {
        return comment;
    }
    public void setComment(String comment) {
        this.comment = comment;
    }
    public int getIsdelete() {
        return isdelete;
    }
    public void setIsdelete(int isdelete) {
        this.isdelete = isdelete;
    }
}
