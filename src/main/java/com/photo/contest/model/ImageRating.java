package com.photo.contest.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="image_rating",
uniqueConstraints = {@UniqueConstraint(columnNames = {"file_id", "judge_id"})})
public class ImageRating implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int  id;
	//private int fileId;
	private int judgeId;
	private int rating;
	private File file;
	
	public ImageRating() {
		super();
		// TODO Auto-generated constructor stub
	}

	private ImageRating(int id/*, int fileId*/, int judgeId, int rating, File file) {
		super();
		this.id = id;
		//this.fileId = fileId;
		this.judgeId = judgeId;
		this.rating = rating;
	}

	
	@Id 
	@GeneratedValue(strategy=IDENTITY)
	@Column(name="id", unique=true, nullable=false)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*@Column(name="file_id", nullable=false, length=5)
	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}*/
	
	@Column(name="judge_id", nullable=false, length=12)
	public int getJudgeId() {
		return judgeId;
	}

	public void setJudgeId(int judgeId) {
		this.judgeId = judgeId;
	}

	@Column(name="rating", nullable=true, length=2)
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="file_id", nullable=false)
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
		

}
