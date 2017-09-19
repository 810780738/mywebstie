package cn.mywebsite.domain;

public class UserInfo {
	private String user_id;
	private String userName;
	private String userPassword;
	private String sex;
	private String age;
	public String getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}
	private String address;
	private String CreateTime;
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
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public UserInfo(String user_id, String userName, String userPassword, String sex, String age, String address,
			String createTime) {
		super();
		this.user_id = user_id;
		this.userName = userName;
		this.userPassword = userPassword;
		this.sex = sex;
		this.age = age;
		this.address = address;
		CreateTime = createTime;
	}
	@Override
	public String toString() {
		return "UserInfo [user_id=" + user_id + ", userName=" + userName + ", userPassword=" + userPassword + ", sex="
				+ sex + ", age=" + age + ", address=" + address + ", CreateTime=" + CreateTime + "]";
	}
	
}
