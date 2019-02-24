package com.photo.contest.model;

import java.util.Arrays;

// default package
// Generated May 11, 2018 12:05:26 PM by Hibernate Tools 3.2.2.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * File generated by hbm2java
 */
@Entity
@Table(name="file"
    , uniqueConstraints = @UniqueConstraint(columnNames={"category_id", "user_id", "category_index"}) 
)
public class File  implements java.io.Serializable {


     private Integer fileId;
     private Category category;
     private Users users;
     private byte[] file;
     private String originalFileName;
     private String titel;
     private Date uploadTime;
     private String categoryIndex;
     private Set<ImageRating> imageRatings = new HashSet<ImageRating>();

    public File() {
    }

   
   
    private File(Integer fileId, Category category, Users users, byte[] file, String originalFileName, String titel,
			Date uploadTime, String categoryIndex, Set<ImageRating> imageRatings) {
		super();
		this.fileId = fileId;
		this.category = category;
		this.users = users;
		this.file = file;
		this.originalFileName = originalFileName;
		this.titel = titel;
		this.uploadTime = uploadTime;
		this.categoryIndex = categoryIndex;
		this.imageRatings = imageRatings;
	}



	@Id 
	@GeneratedValue(strategy=IDENTITY)    
    @Column(name="file_id", unique=true, nullable=false)
    public Integer getFileId() {
        return this.fileId;
    }
    
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="category_id", nullable=false)
    public Category getCategory() {
        return this.category;
    }
    
    public void setCategory(Category category) {
        this.category = category;
    }
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    public Users getUsers() {
        return this.users;
    }
    
    public void setUsers(Users users) {
        this.users = users;
    }
    
    @Column(name="file", nullable=false)
    public byte[] getFile() {
        return this.file;
    }
    
    public void setFile(byte[] file) {
        this.file = file;
    }
    
    @Column(name="original_file_name", nullable=false, length=200)
    public String getOriginalFileName() {
        return this.originalFileName;
    }
    
    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }
    
    @Column(name="titel", nullable=false, length=200)
    public String getTitel() {
        return this.titel;
    }
    
    public void setTitel(String titel) {
        this.titel = titel;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="upload_time", nullable=false, length=19)
    public Date getUploadTime() {
        return this.uploadTime;
    }
    
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
    
    @Column(name="category_index", nullable=false, length=45)
    public String getCategoryIndex() {
        return this.categoryIndex;
    }
    
    public void setCategoryIndex(String categoryIndex) {
        this.categoryIndex = categoryIndex;
    }

    //@OneToMany(mappedBy="fileId")
    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="file")
    public Set<ImageRating> getImageRatings() {
		return imageRatings;
	}

	public void setImageRatings(Set<ImageRating> imageRatings) {
		this.imageRatings = imageRatings;
	}



	@Override
	public String toString() {
		return "File [fileId=" + fileId + ", category=" + category + ", users=" + users + ", file="
				+ Arrays.toString(file) + ", originalFileName=" + originalFileName + ", titel=" + titel
				+ ", uploadTime=" + uploadTime + ", categoryIndex=" + categoryIndex /*+ ", imageRatings=" + imageRatings*/
				+ "]";
	}
    

}


