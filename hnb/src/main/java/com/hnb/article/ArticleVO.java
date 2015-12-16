package com.hnb.article;

import org.springframework.stereotype.Component;

@Component
public class ArticleVO {
	int rcdNo; // 글번호
	int grpNo; // 글그룹
	String usrName; // 작성자
	String usrMail; // 이메일
	String usrSubject; // 제목
	String usrPass; // 비번
	String usrContent; // 내용
	String usrFileName; // 파일명
	int usrFileSize; // 파일크기
	String usrDate; // 작성일
	int usrRefer; // 글 참조횟수
	int rcdLevel; // 글 레벨
	int rcdOrder; // 글 그룹에서 글의 출력순서
	
	public int getRcdNo() {
		return rcdNo;
	}
	public int getGrpNo() {
		return grpNo;
	}
	public String getUsrName() {
		return usrName;
	}
	public String getUsrMail() {
		return usrMail;
	}
	public String getUsrSubject() {
		return usrSubject;
	}
	public String getUsrPass() {
		return usrPass;
	}
	public String getUsrContent() {
		return usrContent;
	}
	public String getUsrFileName() {
		return usrFileName;
	}
	public int getUsrFileSize() {
		return usrFileSize;
	}
	public String getUsrDate() {
		return usrDate;
	}
	public int getUsrRefer() {
		return usrRefer;
	}
	public int getRcdLevel() {
		return rcdLevel;
	}
	public int getRcdOrder() {
		return rcdOrder;
	}
	public void setRcdNo(int rcdNo) {
		this.rcdNo = rcdNo;
	}
	public void setGrpNo(int grpNo) {
		this.grpNo = grpNo;
	}
	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}
	public void setUsrMail(String usrMail) {
		this.usrMail = usrMail;
	}
	public void setUsrSubject(String usrSubject) {
		this.usrSubject = usrSubject;
	}
	public void setUsrPass(String usrPass) {
		this.usrPass = usrPass;
	}
	public void setUsrContent(String usrContent) {
		this.usrContent = usrContent;
	}
	public void setUsrFileName(String usrFileName) {
		this.usrFileName = usrFileName;
	}
	public void setUsrFileSize(int usrFileSize) {
		this.usrFileSize = usrFileSize;
	}
	public void setUsrDate(String usrDate) {
		this.usrDate = usrDate;
	}
	public void setUsrRefer(int usrRefer) {
		this.usrRefer = usrRefer;
	}
	public void setRcdLevel(int rcdLevel) {
		this.rcdLevel = rcdLevel;
	}
	public void setRcdOrder(int rcdOrder) {
		this.rcdOrder = rcdOrder;
	}
}
