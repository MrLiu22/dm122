package lms;

public class Page {
	private int rowTitle; //总的记录数
	private int pageno=1;  //页码
	private int pagesize=10;  //每页容量
	
	public Page(int rowTitle, int pageno, int pagesize) {
		super();
		this.rowTitle = rowTitle;
		this.pageno = pageno;
		this.pagesize = pagesize;
	}

	//获取第一页
	public int getFirst(){
		return 1;
	}
	
	//获取上一页
	public int getPrev(){
		if(pageno>1)
			return pageno-1;
		else
			return 1;
	}
	//获取下一页
	public int getNext(){
		if(pageno<this.getLast())
			return pageno+1;
		else
			return this.getLast();
	}
	//获取最后一页
	public int getLast(){
		//判断每页是否数据全满
		if(this.getRowTitle()%this.getPagesize()==0)
		    return this.getRowTitle()/this.getPagesize();
		else
		    return this.getRowTitle()/this.getPagesize()+1;

	}
	
	public int getRowTitle() {
		return rowTitle;
	}
	public void setRowTitle(int rowTitle) {
		this.rowTitle = rowTitle;
	}
	public int getPageno() {
		return pageno;
	}
	public void setPageno(int pageno) {
		this.pageno = pageno;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

}
