package dto;

import java.sql.Date;

public class Article {
	Integer num;
	String title;
	String content;
	String writer;
	String filename;
	String imgfilename;
	Integer viewcnt;
	Date createdate;
	
	
	public Article() {}
	public Article(String title, String content, String writer, String filename, String imgfilename) {
		super();
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.filename = filename;
		this.imgfilename = imgfilename;
	}


	public Article(Integer num, String title, String content, String writer, String filename, String imgfilename) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.filename = filename;
		this.imgfilename = imgfilename;
	}
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
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
	public String getImgfilename() {
		return imgfilename;
	}
	public void setImgfilename(String imgfilename) {
		this.imgfilename = imgfilename;
	}
	public Integer getViewcnt() {
		return viewcnt;
	}
	public void setViewcnt(Integer viewcnt) {
		this.viewcnt = viewcnt;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
	@Override
	public String toString() {
		return "Article [num=" + num + ", title=" + title + ", content=" + content + ", writer=" + writer
				+ ", filename=" + filename + ", imgfilename=" + imgfilename + ", viewcnt=" + viewcnt + ", createdate="
				+ createdate + "]";
	}
}