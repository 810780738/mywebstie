package cn.mywebsite.domain;


public class UserInfo {
	
	private String userinfo_id;
	private String userName;
	private String loginname;
	private String email;
	private String aboutuser;
	private String userPassword;
	private String sex;
	private String age;
	private String address;
	private String CreateTime;
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAboutuser() {
		return aboutuser;
	}
	public void setAboutuser(String aboutuser) {
		this.aboutuser = aboutuser;
	}
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getUserinfo_id() {
		return userinfo_id;
	}
	public void setUserinfo_id(String userinfo_id) {
		this.userinfo_id = userinfo_id;
	}
	
	@Override
	public String toString() {
		return "UserInfo [userinfo_id=" + userinfo_id + ", userName=" + userName + ", loginname=" + loginname
				+ ", email=" + email + ", aboutuser=" + aboutuser + ", userPassword=" + userPassword + ", sex=" + sex
				+ ", age=" + age + ", address=" + address + ", CreateTime=" + CreateTime + "]";
	}
	public UserInfo(String userName, String userPassword, String sex, String age, String address) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
		this.sex = sex;
		this.age = age;
		this.address = address;
	}
	
	
	public UserInfo(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public UserInfo() {
		super();
	}
	
}
