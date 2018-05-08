package com.linyk3.bean;

public class GAPI_DISTANCE_RESULT implements Comparable<Object> {
	private String origin_id;
	private String dest_id;
	private String distance;
	private String duration;
	private String info;
	private String code;

	public String getOrigin_id() {
		return origin_id;
	}

	public void setOrigin_id(String origin_id) {
		this.origin_id = origin_id;
	}

	public String getDest_id() {
		return dest_id;
	}

	public void setDest_id(String dest_id) {
		this.dest_id = dest_id;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "GAPI_DISTINCT_RESULT [origin_id=" + origin_id + ", dest_id=" + dest_id + ", distance=" + distance
				+ ", duration=" + duration + ", info=" + info + ", code=" + code + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if (this == o) {
			return 0;
		} else if (o != null && o instanceof GAPI_DISTANCE_RESULT) {
			GAPI_DISTANCE_RESULT u = (GAPI_DISTANCE_RESULT) o;
			if (Integer.parseInt(this.distance) <= Integer.parseInt(u.distance)) {
				return -1;
			} else {
				return 1;
			}
		} else {
			return -1;
		}
	}

}
