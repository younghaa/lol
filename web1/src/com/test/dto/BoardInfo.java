package com.test.dto;

public class BoardInfo {
private int boardNum;
private String boardTitle;
public int getBoardNum(){
	return boardNum;
}
public String getBoardTitle() {
	return boardTitle;
}
public void setBoardTitle(String boardTitle) {
	this.boardTitle = boardTitle;
}
public void setBoardNum(int boardNum) {
	this.boardNum = boardNum;
}
}
