package member;


public class MemberVO {
	
	private String name, id, pw, addr, tel, gender, birth, post, email, admin;

	public MemberVO() {
		super();
	}

	public MemberVO(String name, String id, String pw, String addr, String tel, String gender, String birth,
			String post, String email, String admin) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.addr = addr;
		this.tel = tel;
		this.gender = gender;
		this.birth = birth;
		this.post = post;
		this.email = email;
		this.admin = admin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	
	

}
