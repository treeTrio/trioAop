package io.github.zh.cn.trio.aop.function.logger.config.bean;

public class LoggerOne {

	private String time;
	private String level;
	private String name;
	private String info;
	private Throwable e;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Throwable getE() {
		return e;
	}

	public void setE(Throwable e) {
		this.e = e;
	}

}
