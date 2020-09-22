package lms;

public class Page {
	private int rowTitle; //�ܵļ�¼��
	private int pageno=1;  //ҳ��
	private int pagesize=10;  //ÿҳ����
	
	public Page(int rowTitle, int pageno, int pagesize) {
		super();
		this.rowTitle = rowTitle;
		this.pageno = pageno;
		this.pagesize = pagesize;
	}

	//��ȡ��һҳ
	public int getFirst(){
		return 1;
	}
	
	//��ȡ��һҳ
	public int getPrev(){
		if(pageno>1)
			return pageno-1;
		else
			return 1;
	}
	//��ȡ��һҳ
	public int getNext(){
		if(pageno<this.getLast())
			return pageno+1;
		else
			return this.getLast();
	}
	//��ȡ���һҳ
	public int getLast(){
		//�ж�ÿҳ�Ƿ�����ȫ��
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
