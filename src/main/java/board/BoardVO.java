package board;

import java.sql.Date;

public class BoardVO {
	private int id, readcnt, no;
	private String title, content, writer, name, filename, filepath;
	private Date writedate;
	public BoardVO() {
		super();
	}
	public BoardVO(int id, int readcnt, int no, String title, String content, String writer, String name,
			String filename, String filepath, Date writedate) {
		super();
		this.id = id;
		this.readcnt = readcnt;
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.name = name;
		this.filename = filename;
		this.filepath = filepath;
		this.writedate = writedate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getReadcnt() {
		return readcnt;
	}
	public void setReadcint(int readcnt) {
		this.readcnt = readcnt;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
	
	

}
