package lms;

import java.text.SimpleDateFormat;
import java.util.Date;


//�����������--ʵ����
public class Dm {

	private int id;

	private String xm;//����

	private String xh;//ѧ��

	private int zc;//�ܴ�

	private int xq;//����

	private int zh;//����

	private String ip;

	private Date sj;//ʱ��

	private boolean yx;//��֤

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getXh() {
		return xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public int getZc() {
		return zc;
	}

	public void setZc(int zc) {
		this.zc = zc;
	}

	public int getXq() {
		return xq;
	}

	public void setXq(int xq) {
		this.xq = xq;
	}

	public int getZh() {
		return zh;
	}

	public void setZh(int zh) {
		this.zh = zh;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public Date getSj() {
		return sj;
	}
	
	public String getSj1(){
		SimpleDateFormat sdf = new SimpleDateFormat("MM-DD HH:mm");
		return sdf.format(sj);
	}

	public void setSj(Date sj) {
		this.sj = sj;
	}

	public boolean isYx() {
		return yx;
	}

	public String geyYxCn(){
		if(yx)
			return "��Ч";
		else
			return "��Ч";
	}
	
	public void setYx(boolean yx) {
		this.yx = yx;
	}

	

}
