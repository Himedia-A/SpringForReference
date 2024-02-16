package notice;

import java.util.Date;

public class NoticeVO {
	private int id, readcnt, no, root, step, indent;
	private String title, content, writer, filename, filepath, name;
	private Date writeDate;
	public NoticeVO() {
		super();
	}

	public NoticeVO(int id, int readcnt, int no, int root, int step, int indent, String title, String content,
			String writer, String filename, String filepath, String name, Date writeDate) {
		super();
		this.id = id;
		this.readcnt = readcnt;
		this.no = no;
		this.root = root;
		this.step = step;
		this.indent = indent;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.filename = filename;
		this.filepath = filepath;
		this.name = name;
		this.writeDate = writeDate;
	}

	public int getRoot() {
		return root;
	}

	public void setRoot(int root) {
		this.root = root;
	}

	public int getStep() {
		return step;
	}
	public void setStep(int step) {
		this.step = step;
	}
	public int getIndent() {
		return indent;
	}

	public void setIndent(int indent) {
		this.indent = indent;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
	public void setReadcnt(int readcnt) {
		this.readcnt = readcnt;
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
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	
	
	
	

}
