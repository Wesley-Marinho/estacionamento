package br.com.wesley.resources.exceptions;

public class StandartError {
	private Long timestampLong;
	private Integer status;
	private String error;
	
	public StandartError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StandartError(Long timestampLong, Integer status, String error) {
		super();
		this.timestampLong = timestampLong;
		this.status = status;
		this.error = error;
	}

	public Long getTimestampLong() {
		return timestampLong;
	}

	public void setTimestampLong(Long timestampLong) {
		this.timestampLong = timestampLong;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
