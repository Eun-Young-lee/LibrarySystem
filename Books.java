package GUI;

import GUI.ReaderManagements;

public class Books implements Comparable <Books> {
    
private String bId;
private String authorF;
private String authorL;
private String title;
private String genre;

public Books(String bId, String authorF, String authorL, String title, String genre){
    this.bId = bId;
    this.authorF = authorF;
    this.authorL = authorL;
    this.title = title;
    this.genre = genre;
}


public String getbId() {
	return bId;
}

public void setbId(String bId) {
	this.bId = bId;
}

public String getAuthorF() {
	return authorF;
}

public void setAuthorF(String authorF) {
	this.authorF = authorF;
}

public String getAuthorL() {
	return authorL;
}

public void setAuthorL(String authorL) {
	this.authorL = authorL;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getGenre() {
	return genre;
}

public void setGenre(String genre) {
	this.genre = genre;	
}

@Override
public int compareTo(Books b) {
	return this.getbId().compareTo(b.getbId());	
	}

//public int compareTo(Books b) {
//	return this.getAuthorF().compareTo(b.getAuthorF());	
//	}

@Override
public String toString() {
	return "[bId=" + bId + ", authorF=" + authorF + ", authorL=" + authorL + ", title=" + title + ", genre="
			+ genre + "]"+"\r\n";

}
}


