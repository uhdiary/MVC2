package board.model.vo;

import java.sql.Date;

public class Board implements java.io.Serializable{
	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private Date boardDate;
	private int readCount;
	private int boardReplyRef;
	private int boardReplyLev;
	private int boardReplySeq;
	
	public Board(){}

	public Board(int boardNo, String boardTitle, String boardWriter, String boardContent, Date boardDate, int readCount,
			int boardReplyRef, int boardReplyLev, int boardReplySeq) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.readCount = readCount;
		this.boardReplyRef = boardReplyRef;
		this.boardReplyLev = boardReplyLev;
		this.boardReplySeq = boardReplySeq;
	}
	
	public Board(String boardTitle, String boardWriter, String boardContent){
		super();
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardContent = boardContent;
	}
	
	public Board(String boardTitle, String boardWriter, String boardContent, int boardNo){
		super();
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardContent = boardContent;
		this.boardNo = boardNo;
	}

	public Board(String boardTitle, String boardWriter, String boardContent, int boardNo,int boardReplyLev, int boardReplySeq){
		super();
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardContent = boardContent;
		this.boardNo = boardNo;
		this.boardReplyLev =boardReplyLev;
		this.boardReplySeq = boardReplySeq;
	}
	

	/*public Board(String boardWriter, String boardContent, int boardNo) {
		super();
		this.boardWriter = boardWriter;
		this.boardContent = boardContent;
	}*/
	
	public Board(String boardTitle, String boardContent, int boardNo){
		super();
		//this.boardWriter = boardWriter;
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	public int getBoardReplyRef() {
		return boardReplyRef;
	}

	public void setBoardReplyRef(int boardReplyRef) {
		this.boardReplyRef = boardReplyRef;
	}

	public int getBoardReplyLev() {
		return boardReplyLev;
	}

	public void setBoardReplyLev(int boardReplyLev) {
		this.boardReplyLev = boardReplyLev;
	}

	public int getBoardReplySeq() {
		return boardReplySeq;
	}

	public void setBoardReplySeq(int boardReplySeq) {
		this.boardReplySeq = boardReplySeq;
	}
	
	@Override
	public String toString(){
		return this.boardNo + ", " + this.boardTitle + ", " + this.boardWriter + ", " + this.boardContent + ", "
				+ this.boardDate + ", " + this.readCount + ", " + this.boardReplyRef + ", " + this.boardReplyLev 
				+ ", " + this.boardReplySeq;
	} 
	
	
}
